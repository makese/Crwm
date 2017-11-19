<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/modifyUserName.css"></link>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div id="div0">	
			<div style="border:1px solid #F8F8F8;background-color:#F8F8F8;">
			<form action="personCenter_modifyUserName">
			<table id="tbl" border="0" class="table table-hover">
				<tr><td><b>修改用户名</b></td></tr>
			<tr><td><input type="text" value="${user.userInfo.nickName }" id="txt1" name="user.userInfo.nickName"/></td></tr>
			<tr><td><input type="submit" value="确定" id="btn1" class="btn btn-success" />&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取消" id="btn2" class="btn btn-success"/></td></tr>
			</table>
			</form>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn2").click(function(){
		
			window.location.href="userOrderList_setmax?operate=person";		
		
		});
	});

</script>