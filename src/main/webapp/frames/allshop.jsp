<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			 
			
			.tbl{
				width:100%;
				text-align: center;
				
				
			}
			input{
				width:40%;
				height:30px;
				background-color: #3366FF;
				}
				.linklist{
				text-align: center;
				width: 10%;
				height: 30%;
				 float:left;
				 margin-top: 1%;
			}
			.linklist:hover{
				background-color: orange;
			}
			a{
				text-decoration: none;
			}
			.modal fade{
			width:80%;
			height:100%;
			
			}
		 </style>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	</head>
	<body>
		<div id="div1" class="container" >
		<div id="shoptype" style="height:6%; width:100%;margin-left:5%;border:0px solid black;">
		<!-- <font style="color:grey;  float: left;">商品分类:</font> -->
		<div id="linklist" style="height:80%; width:100%; background-color:lightblue;border:0px solid red;">
		<div class="linklist">
		<a href="searchFood_getall">全部商品</a>
							</div>
						<c:choose>
							<c:when test="${empty foodTypeSet}">
								
							</c:when>
							<c:otherwise>
							<c:forEach	items="${foodTypeSet}" var="foodType">
							<div class="linklist" style="border:1px sloid red;">
								<a href="searchFood_byType?foodType.id=${foodType.id}">${foodType.foodTypeName}</a>
							</div>
							</c:forEach>
							</c:otherwise>						
						</c:choose>
						
						
						
					</div>
				
			</div>
		
			<table   class="tbl" >
				<c:choose>
					<c:when test="${empty foodList}">
					
					
					</c:when>
					<c:otherwise>
					<hr/>
						<c:forEach items="${foodList}" var="food">
							<tr><td style="width:20%;height:15%;"><img src="../${food.foodImg}"  data-toggle="modal" data-target="#myModal${food.id}"/></td><td style="width:20%;">${food.foodName }</td><td style="width:20%;">￥${food.price }</td>
							
								<td style="text-align:right;">
							    <a target="_top" href="cartDo_addCart?food.id=${food.id}" type="button" class="btn btn-info" id="btn" name="${food.id}">加入购物车</a>
						         </td> 
								
							</tr>
						
				<!-- 模态框（Modal） -->
              <div class="modal fade" id="myModal${food.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	           <div class="modal-dialog">
		      <div class="modal-content">
			   <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					<font size="5px">${food.foodName}</font>
				</h4>
			</div>
			<div class="modal-body">
			
         <img src="../${food.foodImg}"/>
           <font size="4px">爆款价：&nbsp;￥${food.price}</font>&nbsp;&nbsp;&nbsp;
         <font size="2px"> ${food.introduction}</font>
        </div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
			   <a target="_top" href="cartDo_addCart?food.id=${food.id}" type="button" class="btn btn-info">加入购物车</a>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div></c:forEach>
</c:otherwise>
	</c:choose></table></div>
</body>
</html>
