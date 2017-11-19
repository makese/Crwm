<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
<title>jQuery手机发送验证码倒计时</title>
<link rel="stylesheet" href="../css/zzsc.css" />
<link rel="stylesheet" href="../css/registerByPhone.css" />
<style type="text/css">
.show{
	
	display: none;
}
b{
color: red;
}
</style>
</head>
<body>
<div class="form">
	<div class="div-phone">
		<label for="phone">手机</label><input type="text" id="phone" class="infos" placeholder="请输入手机" />
		<a href="javascript:;" class="send1"  id="sendVerify"  onclick="sends.send();">发送验证码</a>
		&nbsp;&nbsp;<b id="b0">手机号不能为空</b>
		&nbsp;&nbsp;<b id="b3">用户已经存在</b>
	</div>
	<div class="div-ranks">
		<label for="ranks">验证码</label><input type="text" id="ranks" class="infos" placeholder="请输入验证码" onchange="" />
		&nbsp;&nbsp;<span id="span" style="color: red">验证码错误</span>
		&nbsp;&nbsp;<b id="b1">请先发送验证码</b>
	</div>
	<div class="div-conform">
		<input type="button" value="注册" id="btn" /><br /><br />
		<p>注：手机号注册初始密码为手机后六位</p>
	</div>
</div>


</body>
</html>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js" ></script>
<script>
		$(document).ready(function(){
			$("b").addClass("show");
			$("#span").addClass("show");
			$("#phone").change(function(){
				
			
			$("b").addClass("show");
			$("#span").addClass("show");
			});
			
			
			
			$("#btn").click(function(){
				var verify=$("#ranks").val();
				var val = $('#phone').val().replace(/\s+/g,""); //获取输入手机号码	
				$.ajax({
					type:"GET",
					url: "register_verifyShop",
					data:"tel="+val+"&verify="+verify,
					dataType:"json",
					success:function(data){
						var d=eval(data);
							if(d=="wrong"){
							
								$("#span").removeClass("show");
							
							}else if(d=="success"){
							
							window.top.location.href="../shopCenter.jsp";
							}else if(d=="miss"){
								$("#b0").addClass("show");
								$("#b1").removeClass("show");
							}else if(d=="noTEL"){
								$("#b0").removeClass("show");
							}else if(d=="existUser"){
								$("#b3").removeClass("show");
							}
						}				
				});
			});
		});

var sends = {
	checked:1,
	send:function(){
	$("b").addClass("show");
			//手机号
			var numbers = /^1\d{10}$/;
			var val = $('#phone').val().replace(/\s+/g,""); //获取输入手机号码
			if($('.div-phone').find('span').length == 0 && $('.div-phone a').attr('class') == 'send1'){
				if(!numbers.test(val) || val.length ==0){
					$('.div-phone').append('<span class="error">手机格式错误</span>');
					return false;
				}
			}
			//验证码
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
						url: "register_shopByPhone",
						data:"tel="+val,
						dataType:"json",
						success:function(data){
						var d=eval(data);
							if(d=="ok"){
								alert("发送验证码成功，请注意查收");
							}else{
							alert("发送失败，请重新发送");
							}
						}				
					});
	}
}
</script>