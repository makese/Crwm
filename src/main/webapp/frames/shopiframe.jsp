<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../css/common.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
			
			.shop{
				float: left;
				height: 15%;
				width: 25%;
				border: 1px solid #f5f5f5;
			}
			.shop:hover{
				background-color: #F2F3F5;
			}
			#continer{
				height: 100%;
				width: 100%;
			}
			.shopimage{
				height: 80%;
				width: 40%;
				margin-left: 5%;
				margin-top: 2.5%;
				float: left;
				margin-top: 26px;
			}
			.shopcontent{
				height: 80%;
				width: 50%;
					margin-left: 47.5%;
					margin-top: 2.5%;
					text-align:center;
			}
			a{
				text-decoration: none;
				color: black;
			}
			a:hover{
				text-decoration: none;
			}
		</style>
		<script type="text/javascript">
				function show(obj,id) {    
			    var objDiv = $("#"+id+"");
			    $(objDiv).css("display","block");
			    $(objDiv).css("left", event.clientX);
			    $(objDiv).css("top", event.clientY + 10);  
			}
			function hide(obj,id) {
			    var objDiv = $("#"+id+"");
			    $(objDiv).css("display", "none");
} 
		</script>
		<title></title>
	</head>
	<body>
		<div id="container" >
				<c:set scope="session" var="i" value="1" ></c:set>
				<c:choose>
					<c:when test="${empty shopList}">
								对不起，该分类暂无商家！！
					</c:when>
					<c:otherwise>
						<c:forEach items="${shopList }" var="shop">
						<div class="shop" >
							<div class="shopimage">
							<a href="pre_ShopFoodDetail_predo?shop.id=${shop.id }"  target="_top" ><img src="../${shop.shopLogo }" width="100%" height="100%" id="t1"  class="img-thumbnail" onMouseOver="javascript:show(this,'mydiv${i}');" onMouseOut="hide(this,'mydiv${i}')"/></a>	
							</div>
							<div class="shopcontent">
								<br />
							<b>${shop.shopInfo.shopName}</b><br /><br />
							星级：${shop.shopScore.totalScore/shop.shopScore.assessCount }<br /><br />
								月售：${shop.shopScore.assessCount}单
							</div>
							
					</div>
						<div id="mydiv${i}" style="position:absolute;display:none;border:1px solid lightblue;background:lightblue;height:20%;width:25%;">
								<br/>
								<b>${shop.shopInfo.shopName}</b><br/>
								${shop.shopInfo.content}	<br/><br/>
									月售：${shop.shopScore.assessCount}单
							</div>
							<c:set scope="session" var="i" value="${i=i+1}"></c:set>
						</c:forEach>					
					</c:otherwise>				
				</c:choose>
		</div>
	</body>
</html>