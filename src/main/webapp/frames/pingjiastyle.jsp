<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../css/admin.css" />
		<link rel="stylesheet" href="../css/pintuer.css" />
		<style type="text/css">
			.tttt{
			
			text-align: center;
			}
			
		</style>
	</head>
	<body>
		<div>
		<div class="panel-body bg-green-light">
			<form id="tableForm">
				<table class="table table-striped table-hover">
									<tr  class="tttt" >
										<th style="text-align: center;">下单时间</th>
										<th style="text-align: center;">用户</th>
										<th style="text-align: center;">用户评分</th>
									</tr>
						<c:choose>
							<c:when test="${empty orderList}">
								<h1>对不起，该商家暂无订单</h1>
							</c:when>
							<c:otherwise>
									<c:forEach items="${orderList }" var="order">
									<tr class="tttt" >
										<td><fmt:formatDate value="${order.orderTime }" type="both"/> </td>
										<td>${order.user.userInfo.nickName }</td>
										<td>${order.shopGrade}</td>
								</tr>
									</c:forEach>
							</c:otherwise>
						</c:choose>
				</table>
			</form>
		</div>
		</div>
	</body>
</html>

