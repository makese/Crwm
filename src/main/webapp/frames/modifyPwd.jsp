<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/modifyPwd.css"></link>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#b1").attr("hidden",true);
			$("#sub").attr("disabled",true);
			$("#oldPwd").change(function(){
				var pwd=$("#oldPwd").val();
				alert(pwd);
				$.ajax({
					type: "GET",
					url: "personCenter_verifyPwd",
					data:	"user.pwd="+pwd,			
					dataType:"json",
					success: function(result){
						if(result=="yes"){
							$("#b1").attr("hidden",true);
							$("#sub").attr("disabled",false);
						}
						if(result=="no"){
							$("#b1").attr("hidden",false);
						}
					}	
				})
			});
		});
	
	
	</script>
	</head>
	<body>
	<div class="container">
	<div style="margin-top:15px;">
	<b>个人资料</b></div>
	<hr/>
	<div id="div0">
			<table border="0"   class="table table-hover">
			<tr><th>旧密 码:</th><td><input type="password"  id="oldPwd"><b id="b1" style="color: red;">原密码错误</b></td></tr>
			<form action="personCenter_modifyUserPwd">
				
			<tr><th>新密 码:</th><td><input type="password"  name="user.pwd"></td></tr>
			<tr><th>确认密 码:</th><td><input type="password"></td></tr>
			<tr><td colspan="2">
				<input type="submit"  value="确认" id="sub" class="btn btn-info" /></td></tr>
			</form>
			</table>
	</div>
	</div>
	</body>
</html>
