<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/personMain.css"></link>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="container">
	<div id="div1">
		
		<div id="div3">
			<img src="../${user.userInfo.headImg }" class="img-circle"/>
			
		</div>
		<div id="div4">
			<c:choose>
				<c:when test="${empty user.userInfo.nickName }">
					亲爱的用户${user.tel}，欢迎你的到来		
				</c:when>
				<c:otherwise>
				亲爱的${user.userInfo.nickName }，欢迎你的到来	
				</c:otherwise>
			</c:choose>
			
		</div>
			<div style="text-align: center; float: right;width:15%;margin-top:8%;border:0px solid red;">余额：${user.userInfo.balance}</div>
	</div>
	<div id="div0" style="text-align:center;margin-top:0;">
		<b><font size="6px">最&nbsp;近&nbsp;订&nbsp;单</font></b>
		<table class="table" border="0">
       <tr ><td style="width:13%">下单时间</td><td style="width:10%">购买店铺</td><td style="width:10%">支付金额</td><td style="width:10%">订单状态</td></tr>
			<c:choose>
				<c:when test="${empty orderList}">
					对不起，您最近还没有点过单哦！				
				</c:when>
				<c:otherwise>
					<c:forEach	items="${orderList }" var="order">
						<tr style="height:50px"><td><fmt:formatDate value="${order.orderTime }" type="both"/> </td><td>${order.shop.shopInfo.shopName}</td><td>￥${order.total }</td><td>${order.orderStatus.status }</td></tr>									
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
							window.location.href="../frames/personMain.jsp";
						}					
					});			
			});
		});
	
	
	
	</script>