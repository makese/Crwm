<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
	<head>
	<meta charset="UTF-8">
	<title></title>
	<style type="text/css">
	*{
	font-size:14px;
	
	
	}
	</style>
	<link rel="stylesheet" type="text/css" href="../css/orderItem.css"></link>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		
			$("#addrBtn").click(function(){
				var addr=$("input[name=selAddr]").val();			
				alert(addr);
				window.location.href="cartDo_selAddr?address.id="+addr;
			
			});
		});
	
	
	</script>
	</head>
	<body>
	<div class="container">
	<div style="height:70%;width:80%;border:0px solid red;float:left;margin-top:2%;margin-left:6%;">
	<h5 style="text-align:center;">我的订单详情</h5>
	
			
         <table class="table">
       
		<tr class="success">
			<td>商品</td>
			<td>下单时间</td>
			<td>数量</td>
			<td>小计</td>
		</tr>
	
	     <tbody>
		
		  <c:choose>
		  <c:when test="${empty currOrder.orderItemSet }">
					</c:when>
					<c:otherwise>
		  <c:forEach items="${currOrder.orderItemSet }" var="orderItem">
		  <tr class="success">
			<td>${orderItem.food.foodName }</td>
			<td>${orderItem.order.orderTime}</td>
			<td>${orderItem.count}</td>
			<td>${orderItem.total}</td>
		  </tr>
		  </c:forEach>
		  </c:otherwise>
		  </c:choose>
		   <tr class="success">
		    <td>总计</td>
			<td colspan="3" style="text-align:left;">￥ &nbsp;${currOrder.total}元</td>
			</tr>
			  <tbody>
		       <tr class="success">
			<td>收货人：</td><td colspan="3" style="text-align:left;">${currOrder.address.linkPersonName}</td>
			</tr>
			<tr class="success">
			<td>收货地址：</td><td colspan="3" style="text-align:left;">${currOrder.address.address}</td>
			</tr>
			<tr class="success">
			<td>联系电话：</td><td colspan="3" style="text-align:left;">${currOrder.address.phoneNumber}</td>
			</tr>
		</tbody>
			<c:if test="${currOrder.orderStatus.id!=4 }">
			 <tr class="success"><td colspan="4" style="text-align:center;"><input type="submit" value="结账"/></td></tr>
				</c:if>
				 </tbody>
		
</table>
</form>
</div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					选择地址
				</h4>
			</div>
			<div class="modal-body">
				<table class="table table-hover">
					<caption>地址表</caption>
				
					<c:choose>
						<c:when test="${empty addressSet }">
							暂时没有地址，<a>去添加>></a>						
						</c:when>
						<c:otherwise>
							<thead>
						<tr>
							<th>地址</th>
							<th>电话</th>
							<th>联系人</th>
							<th>选择</th>
							
						</tr>
					</thead>
					<tbody>
							<c:forEach items="${addressSet }" var="address">
						<tr>
							<td>${address.address }</td>
							<td>${address.phoneNumber }</td>
							<td>${address.linkPersonName }</td>
							<td>
							<c:if test="${address.defaultAddress==true }">
								<input type="radio" checked="checked" name="selAddr" value="${address.id }"  /> 
							</c:if>
							<c:if test="${address.defaultAddress==false }">
								<input type="radio" name="selAddr" value="${address.id }" /> 
							</c:if>	
							</td>
						</tr>			
							</c:forEach>
						</c:otherwise>
					</c:choose>
					
					</tbody>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" id="addrBtn">
					提交
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
		
	</body>

</html>
