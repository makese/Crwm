<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
<title>jQuery手机发送验证码倒计时</title>
<link rel="stylesheet" href="../css/zzsc.css" />
<link rel="stylesheet" href="../css/loginByPhone.css" />
<style type="text/css">
	b{
	color: red;
	}
	.warn{
		display: none;
	}	
</style>
</head>
<body>
<div class="form">
	<div class="div-phone">
		<label for="phone">手机</label><input type="text" id="phone" class="infos" placeholder="请输入手机" />
		<a href="javascript:;" class="send1" onclick="sends.send();">发送验证码</a>
		&nbsp;<b id="b1">请输入手机号</b>
		&nbsp;<b id="b2">请先发送验证码</b>
	</div>
	<div class="div-ranks">
		<label for="ranks">验证码</label><input type="text" id="ranks" class="infos" placeholder="请输入验证码"  />
		&nbsp;<b id="b3">验证码错误</b>
	</div>
	<div class="div-conform">
		<input type="button" value="登录" id="btn"/>
	</div>
</div>


</body>
</html>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js" ></script>
<script>
	
	$(document).ready(function(){
			$("b").addClass("warn");
			$("#btn").click(function(){
			var val = $('#phone').val().replace(/\s+/g,""); //获取输入手机号码
			var verify=$("#ranks").val();
				if(val==""){
				$("#b1").removeClass("warn");
				}
					$.ajax({
							type: "GET",
							url: "login_verify",
							data:"tel="+val+"&verify="+verify,
							dataType:"json",
							success: function(data){
								var d=eval(data);
								if(d=="noVerify"){
								
								$("#b2").removeClass("warn");
								
								}else if(d=="errorVerify"){
								
								$("#b3").removeClass("warn");
								
								}else if(d=="ok"){
									window.top.location.href="pre_main_setAddr";
								}
							}
						});	
			
			});
			$("#phone").change(function(){
			var val = $('#phone').val().replace(/\s+/g,""); //获取输入手机号码
				if(val!=""){
					$("b").addClass("warn");
				}
			});
	});
		


var sends = {
	checked:1,
	send:function(){
			var numbers = /^1\d{10}$/;
			var val = $('#phone').val().replace(/\s+/g,""); //获取输入手机号码
			if($('.div-phone').find('span').length == 0 && $('.div-phone a').attr('class') == 'send1'){
				if(!numbers.test(val) || val.length ==0){
					$('.div-phone').append('<span class="error">手机格式错误</span>');
					return false;
				}
			}
			if(numbers.test(val)){
				var time = 30;
				$('.div-phone span').remove();
				function timeCountDown(){
					if(time==0){
						clearInterval(timer);
						$('.div-phone a').addClass('send1').removeClass('send0').html("发送验证码");
						sends.checked = 1;
						return true;
					}
					$('.div-phone a').html(time+"S后再次发送");
					time--;
					return false;
					sends.checked = 0;
				}
				$('.div-phone a').addClass('send0').removeClass('send1');
				timeCountDown();
				var timer = setInterval(timeCountDown,1000);
			}
		$.ajax({
			type: "GET",
			url: "login_userByPhone",
			data:"tel="+val,
			dataType:"json",
			success: function(data){
				var d=eval(data);
				if(d=="send-ok"){
				
					alert("验证码已经成功发送，请注意查收");
				}
			}
		});	
			
	}
}
</script>