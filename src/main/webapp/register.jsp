<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
		<title>登录页面</title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/register.css" />
		<script type="text/javascript" src="js/register.js"></script>
	</head>

	<body scroll="no">
		<div id="div1">
			<div id="div2">
				<a href="index.jsp"><img src="images/logo.png" /></a><br />
				<div id="div5">
					<font onclick="registerByPhone()">手机注册</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font onclick="registerByPassword()">账号注册</font>
				</div>
				<div id="div4">
					<iframe src="frames/registerByPhone.jsp" scrolling="no" noresize="0" name="panel" id="if1" name="if1"></iframe>
				</div>
				<div id="div6">
					已经注册过！请点击
					<a href="login.jsp">直接登录</a>
				</div>
			</div>
			<div id="div3">
				<span>我要开店|联系我们|服务条款和协议|加入我们</span><br />
				<span>增值MAIMENG业务许可证 :艾泽拉斯 PKQ-20170921 | 艾泽拉斯ICP20170921| 瓦罗兰工商行政管理 Copyright ©2008-2017 德玛西亚科技有限公司, All Rights Reserved.</span>
				<br/><span>版权所有@三个有趣的灵魂</span>
			</div>

		</div>
	</body>

</html>