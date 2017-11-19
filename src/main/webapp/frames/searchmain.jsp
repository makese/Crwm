<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		<link rel="stylesheet" type="text/css" href="../css/searchmain.css"></link>
		<script type="text/javascript">
	
		</script>
		<style type="text/css">
		a{
		text-decoration: none;
		}
		</style>
	</head>
	<body>
		<div class="container">
		<c:choose>
			<c:when test="${empty shopList}">
			<h1>对不起，还么有这个商家！</h1>
			</c:when>
			<c:otherwise>
			<div class="shop" style="width:90%;height: 10%;">
				<c:forEach items="${shopList}" var="shop">
		
			<div>
				<div style="float: left;height: 100%" >
					<img alt="商家logo" src="../${shop.shopLogo }" width="100%"> 
				</div>
				<div class="shopcontent">
								<br />
							<b>${shop.shopInfo.shopName}</b><br />
							星级：${shop.shopScore.totalScore/shop.shopScore.assessCount }	<br />
								月售：${shop.shopScore.assessCount}单
							<a href="pre_ShopFoodDetail_predo?shop.id=${shop.id }" style="float: right;" target="_top">点击查看详情>></a>
				</div>
		
				<hr />
			</div>	
				
				
				</c:forEach>
			</c:otherwise>
		</c:choose>
	
	
	</div>
	</body>
</html>
