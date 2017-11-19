<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/order.css"></link>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
	*{
	
	font-size: 14px;
	}	
	
	</style>
	</head>
	<div class="container">
	<div id="div0" style="text-align: center;margin-top:15px;">
		<b><font size="5px">我&nbsp;的&nbsp;订&nbsp;单</font></b>
		<table class="table" border="0">
      		<tr ><td style="width:13%">下单时间</td><td style="width:10%">购买店铺</td><td style="width:10%">支付金额</td><td style="width:10%">订单状态</td><td style="width: 7%;"></td></tr>
			<c:choose>
				<c:when test="${empty orderList}">
					对不起，您最近还没有点过单哦！				
				</c:when>
				<c:otherwise>
					<c:forEach	items="${orderList }" var="order">
						<tr style="height:50px"><td><fmt:formatDate value="${order.orderTime }" type="both"/> </td><td>${order.shop.shopInfo.shopName}</td><td>￥${order.total }</td><td>${order.orderStatus.status }</td><td style="width: 7%;">
							<c:choose>
								<c:when test="${order.orderStatus.id!=4 }">
								
									<a type="button" class="btn btn-success" href="personCenter_orderPay?order.id=${order.id }" >去结账>></a>
								
								</c:when>
							
								<c:otherwise>
								<c:if test="${order.id==1}">
									<a type="button" class="btn btn-success" href="personCenter_orderItem?order.id=${order.id}" >查看详情>></a>
								
								</c:if>
								<c:if test="${order.id==2}">
									<a type="button" class="btn btn-success" href="personCenter_confirm?order.id=${order.id}" >确认收货</a>
								
								</c:if>
								<c:if test="${order.id==2}">
									<a type="button" class="btn btn-success" href="personCenter_orderItem?order.id=${order.id}" >查看详情>></a>
								
								</c:if>
								
								
								</c:otherwise>
							</c:choose>
						
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
