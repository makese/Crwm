<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
	<head>
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>潮人外卖首页</title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=GAQnhI2XWaPD6k4KuHOdihE9mFseMcFn"></script>
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/index.css" />
		<style type="text/css">
			font{
			
			font-family:华文隶书;
			font-size: 70px;
			color: white;
			float: left;
			margin-left: 45%;
		}
		h3{
				float: left;
				color: white;
				font-size: 30px;
				font-family:华文宋体;
				margin-top: 40px;
	}
		
		</style>
		<script type="text/javascript">
		$(document).ready(function(){
			$("#imgcl").click(function(){
				var city=$("#cityName").val();
		var location=$("#suggestId").val();
					if(location==""){
			
				var addr=location+city;
			}else{
				var addr=location;
				
			}
		
			window.location.href='pre_main_setAddr?addr='+addr;	
			
			});
			
			$("#loginSetAddr").click(function(){
				var city=$("#cityName").val();
		var location=$("#suggestId").val();
					if(location==""){
			
				var addr=location+city;
			}else{
				var addr=location;
				
			}
			window.location.href='login_setAddr?addr='+addr;
			
			
		});
		})
		</script>
	</head>

	<body scroll="no">
		<div class="container">
			<div class="row clearfix" id="div1">
				<div class="col-md-12 column" id="icon">
					<a id="imgcl"><img src="images/chaoren.jpg" /></a>
				</div>
				<c:choose>
					<c:when test="${user==null}" >
							<div id="login">
								<a id="loginSetAddr">登录</a>/
								<a href="register.jsp">注册</a>&nbsp;
								<a id="wannaopenshop" href="shopindex.jsp">我要开店</a>
							</div>
					
					</c:when>
					<c:otherwise>
						<div id="login">
					<a href="pre_main_setAddr">	<img src="${user.userInfo.headImg }" width="5%"></a>
						<a href="pre_main_setAddr">${user.tel }</a>&nbsp;
								<a href="shopindex.jsp">我要开店</a>
							</div>
					</c:otherwise>
				</c:choose>
			
				<div id="word">
					<font>潮</font>
					<h3>人外卖</h3>
				</div>
				<div id="allmap"></div>

				<div id="r-result1" class="result0">

					当前定位到您的城市为: <input id="cityName" type="text" />

				</div>
				<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
				<div id="l-map"></div>
				<div id="r-result2" class="result0">
					<input type="text" id="suggestId" size="20" value="百度" style="width:250px; color: gray;" placeholder="请输入位置" />
					<input type="button" value="搜索" onclick="theLocation()" id="search" />
				</div>

				<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
			</div>

			<div class="row clearfix" id="div2">
				<span>我要开店|联系我们|服务条款和协议|加入我们</span><br />
				<span>增值MAIMENG业务许可证 :艾泽拉斯 PKQ-20170921 | 艾泽拉斯ICP20170921| 瓦罗兰工商行政管理 Copyright ©2008-2017 德玛西亚科技有限公司, All Rights Reserved.</span>
				<br/><span>版权所有@三个有趣的灵魂</span>
			</div>
		</div>
	</body>

</html>
<script type="text/javascript" src="js/index.js"></script>