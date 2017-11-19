<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/evaluteOrder.css"></link>
			<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	
	<body>
	<div class="container">
	<div id="div0" style="text-align: center;">
		<b><font size="5px">待&nbsp;评&nbsp;价&nbsp;订&nbsp;单</font></b>
		<table class="table" border="0">
       <tr ><td style="width:20%">下单时间</td><td style="width:20%">订单内容</td><td style="width:20%">支付金额</td><td style="height:20%;">状态</td><td style="width:20%;">&nbsp;&nbsp;评价</td></tr>
			<c:choose>
				<c:when test="${empty evaluteOrderList}">
					对不起，您最近还没有点过单哦！				
				</c:when>
				<c:otherwise>
					<c:forEach	items="${evaluteOrderList }" var="order">
						<tr style="height:50px"><td><fmt:formatDate value="${order.orderTime }" type="both"/> </td><td>${order.shop.shopInfo.shopName}</td><td>￥${order.total }</td><td>${order.orderStatus.status }</td><td style="width:18%;">
					
					<a type="button"  class="btn btn-success"  href="evalute.jsp?orderId=${order.id}">店铺</a>
					<a type="button" class="btn btn-success"  href="evaluteFood.jsp?orderId=${order.id}">商品</a>
					</td></tr>					
					</c:forEach>
				</c:otherwise>			
			</c:choose>
			
		</table>
		<button type="button" class="btn btn-primary" id="btn">点击加载更多</button>
	</div>
	</div>
	</body>
</html>
<script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
					$.ajax({
						type: "POST",
						url: "userOrderList_showMore",
						dataType:"json",
						success:function(result){
							if(result=="noMore"){
								alert("没有更多了");
							}
							window.location.href="../frames/order.jsp";
						}					
					});			
			});
		});
	
	
	
	</script>
