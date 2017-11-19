<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/collect.css"></link>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	
	<body>
	<div class="container">
	<div style="margin-top:15px;">
			<b>我的收藏</b></div>
			<hr/>
			<div id="div0" style="width: 100%">
			<c:choose>
			
				<c:when test="${empty myCollect }">
				<h7>你还么有收藏哦！赶紧去添加你喜欢的商家吧</h7>	
				</c:when>			
				
				<c:otherwise>
		
				<c:forEach items="${ myCollect}" var="shop">
					<img  src="../${shop.shopLogo }" style="width: 10%;float: left" class="img-circle">
					<div style="width:30%;margin-left:12%;margin-top:2%;">
					<h6><b>${shop.shopInfo.shopName}</b></h6></div>
					<div style="width:30%;margin-left:12%;margin-top:2%;">
					${shop.shopInfo.content}</div>
					<div style="text-align:right;">
					<a type="button" class="btn btn-primary" id="btn" href="collect_delete?currShop.id=${shop.id }">取消关注</a>
					</div>
				</c:forEach>
					
			</c:otherwise>
				</c:choose>
				<hr/>
				</div>
				
	</body>
</html>
