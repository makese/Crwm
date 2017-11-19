<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/bottom.css" />
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<style type="text/css">
			body{
			
			/*overflow:hidden;*/
			overflow-y: hidden;
		}
	
		</style>
		<title>商户中心</title>
	
	</head>

	<body>
		<div id="continer">
			<div id="bottom">
				<a href="index.jsp"><img src="images/chaoren.jpg" id="chaoren" /></a>
				<div id="account">
					<img src="images/user-photo.png" width="20px" height="20px">
						<c:choose>
							<c:when test="${currShop.tel !=null }">
								${currShop.tel}
							</c:when>
							<c:otherwise>
								${currShop.loginId}							
							</c:otherwise>
						</c:choose> 
					<input value="退出账号" type="button" id="btn" />
				</div>
			</div>
			<div id="myfrmae">
				<iframe src="frames/shopinfo.jsp" frameborder="0" scrolling="auto" noresize="0"></iframe>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
				$("#btn").click(function(){
				var a=window.confirm("是否确认退出登录？");
					if(a){
						 window.location.href="loginOut_shopLO"; 
					}
				});
		});
		
</script>