<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/accountBalance.css"></link>
			<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
			
	</head>
	<body>
	<div class="container">
		<div id="div0" style="margin-top:15px">
			<b>账户余额</b >
			<hr/>
			</div>
		<div id="div1"><br/>当前可用余额：￥<font  color="#FF0000">${user.userInfo.balance }</font>元
			<a href="recharge.jsp" type="button" class="btn btn-success"style="margin-left:65%;width:7%;height:37%;" >充值</a>
			<hr/>
			</div>
			</div>
			</div>
	</body> 
</html>
