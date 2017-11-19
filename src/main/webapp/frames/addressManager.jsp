<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
				<link rel="stylesheet" type="text/css" href="../css/addressManager.css"></link>
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
			<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="container">
	<div style="margin-top:15px;">
		<b>地址管理</b></div>
		
		<div>
			<table id="tbl" border="0" class="table">
      		<tr ><td style="width:13%">地址</td><td style="width:10%">联系人手机</td><td style="width:10%">联系人姓名</td><td style="width:10%">地址状态</td><td style="width: 7%;"></td></tr>
			<c:choose>
				<c:when test="${empty addressSet}">
					对不起，您还没有地址哦！				
				</c:when>
				<c:otherwise>
					<c:forEach	items="${addressSet }" var="address">
						<tr style="height:50px"><td>${address.address }</td><td>${address.phoneNumber}</td><td>${address.linkPersonName }</td>
						<td>
						<c:if test="${address.defaultAddress==true }">
							默认地址
						</c:if>
						<c:if test="${address.defaultAddress==false }">
							<a type="button" class="btn btn-success" href="personCenter_setDefaultAddress?address.id=${address.id }">设为默认地址</a>
						</c:if>
						</td>
						<td style="width: 7%;">
					
								<a type="button" class="btn btn-success"  href="personCenter_deleteAddress?address.id=${address.id }" style="height:4%;">删除</a>
					
						</td></tr>									
					</c:forEach>
				</c:otherwise>			
			</c:choose>
			
		</table>
		
		</div>
		<div id="div0">
			<a href="addAddress.jsp"><font size="20px">+</font>添加新地址</a>
		</div>
		
		</div>
	</body>
</html>
