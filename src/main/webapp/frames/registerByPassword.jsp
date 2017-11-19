<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
<title>密码登录</title>
<link rel="stylesheet" href="../css/zzsc.css" />
<link rel="stylesheet" href="../css/registerByPassword.css" />
<style type="text/css">
	.warn{
	
	display: none;
	
	}
	.b{
	color: red;
	}
	.span{
	color: red;
	}
</style>
</head>
<body>
<div class="form">
	<div class="div-phone">
		<label for="phone">账号</label><input type="text" id="phone" class="infos" placeholder="手机/邮箱/用户名"  style="width: 200px;"/>
		&nbsp;&nbsp;<b class="b" id="b1">账号不能为空!</b>
		&nbsp;&nbsp;<b class="b" id="b2">用户已经存在!</b>
	</div>
	<div class="div-ranks">
		<label for="ranks">密码</label><input type="password" id="ranks" class="infos" placeholder="密码"  />
		&nbsp;&nbsp;<b class="span" >密码不一致!</b>
		&nbsp;&nbsp;<b class="b" id="b3">密码不能为空!</b>
	</div>
	<div class="div-ranks">
		<label for="ranks">确认</label><input type="password" id="ranks1"  class="infos" placeholder="确认密码"  />
		&nbsp;&nbsp;<b class="span">密码不一致!</b>
	</div>
	<div class="div-conform">
		<input type="button" value="注册" id="btn" />
	</div>
</div>
</body>
</html>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
	
		 $(".span").addClass("warn"); 
		$(".b").addClass("warn");
		$("#btn").attr("disabled",true);
		$("#phone").change(function(){
		$(".b").addClass("warn");
		
		})
	
		$(".infos").change(function(){
		var pwd=$("#ranks").val();
		var pwd1=$("#ranks1").val();
			if(pwd!==pwd1){
				 $(".span").removeClass("warn");
				 $("#btn").attr("disabled",true);
			}else if(pwd==pwd1){
				 $(".span").addClass("warn");
				 $("#btn").attr("disabled",false);
			}
			
		});
		
		$("#btn").click(function(){
		var loginId=$("#phone").val();
		var pwd=$("#ranks").val();
		var pwd1=$("#ranks1").val();
			$.ajax({
				type: "GET",
				url: "register_userByPwd",
				data:"loginId="+loginId+"&pwd="+pwd+"&pwd1="+pwd1,
				dataType:"json",	
				success:function(data){
					var d=eval(data);
					if(d=="nologinId"){
						$("#b1").removeClass("warn");	
					}else if(d=="existUser"){
						$("#b2").removeClass("warn");	
					}else if(d=="noPWD"){
						$("#b3").removeClass("warn");	
					}else if(d=="difPWD"){
						 $(".span").removeClass("warn");
				 		 $("#btn").addAttr("disabled");
					}else if(d=="ok"){
						alert("恭喜您！注册成功，请登录");
						window.top.location.href="../login.jsp";
					}
				}
			});
				
		});
	});
	
</script>