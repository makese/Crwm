<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
<title>密码登录</title>
<link rel="stylesheet" href="../css/zzsc.css" />
<link rel="stylesheet" href="../css/loginByPassword.css" />
<style type="text/css">
	.warn{
	
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
		<label for="phone">账号</label><input type="text" id="phone" class="infos" placeholder="手机/邮箱/用户名"  style="width: 200px;"/>
		&nbsp;&nbsp;<b id="b1">账号不能为空</b>
		<b id="b3">用户名或密码错误</b>
	</div>
	<div class="div-ranks">
		<label for="ranks">密码</label><input type="password" id="ranks" class="infos" placeholder="密码"  />
		&nbsp;&nbsp;<b id="b2">密码不能为空</b>
	</div>
	<div class="div-conform">
		<input type="button" value="登录" id="btn"/>
	</div>
	<div id="div1">
		<a href="">忘记密码？</a>
	</div>
</div>


</body>
</html>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
			$("b").addClass("warn");
			$("#btn").attr("disabled",true);
			
			$("#ranks").change(function(){
				var loginId=$("#phone").val();
				var pwd=$("#ranks").val();
					
				if(loginId!=null && pwd!=null ){
				$("b").addClass("warn");
					$("#btn").attr("disabled",false);
				}
				
				if(loginId=="" || pwd=="" ){
					
					$("#btn").attr("disabled",true);
				}
				if(loginId==""){
					$("#b1").removeClass("warn");
				
				}
				if(pwd==""){
					$("#b2").removeClass("warn");
				
				}
			});
			$("#phone").change(function(){
				var loginId=$("#phone").val();
				var pwd=$("#ranks").val();
					
				if(loginId!=null && pwd!=null ){
					$("b").addClass("warn");
					$("#btn").attr("disabled",false);
				}
				
				if(loginId=="" || pwd=="" ){
					$("#btn").attr("disabled",true);
				}
				if(loginId==""){
					$("#b1").removeClass("warn");
				
				}
				if(pwd==""){
					$("#b2").removeClass("warn");
				
				}
			
			});
			$("#btn").click(function(){
				var loginId=$("#phone").val();
				var pwd=$("#ranks").val();
				$.ajax({
					type: "GET",
					url: "login_userByPwd",
					data:"loginId="+loginId+"&pwd="+pwd,				
					dataType:"json",
					success: function(data){
						var d=eval(data);
						if(d=="noUser"){
							$("#b3").removeClass("warn");
							
						}else if(d=="ok"){
							window.top.location.href="pre_main_setAddr";
						}
					
					}
				})
						
			
			});
	});


</script>

