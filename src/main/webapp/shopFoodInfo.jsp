<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
		<link href="https://cdn.bootcss.com/ionic/1.3.2/css/ionic.css" rel="stylesheet">
        <script src="https://cdn.bootcss.com/ionic/1.3.2/js/ionic.bundle.min.js"></script>
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery-1.6.2.min.js" ></script>
	<link rel="stylesheet" type="text/css" media="screen" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
		<link rel="stylesheet" href="css/nav.css" />
		<link rel="stylesheet" href="css/mian.css">
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
			var result="${result}";
				if(result=="" || result=="no"){
					$("#collect").addClass("glyphicon glyphicon-heart-empty");
				}else{
					$("#collect").addClass("glyphicon glyphicon-heart");
				}
				
					$("#collect").click(function(){
							$.ajax({
								type:"GET",
								url:"collect_addCollect",
								data:"currShop.id="+${currShop.id},
								dataType:"json",
								success:function(result){
									if(result=="login"){
										window.top.location.href="login.jsp";
									}
									if(result=="no"){
									$("#collect").text("收藏");
									$("#collect").removeClass("glyphicon glyphicon-heart");
										$("#collect").addClass("glyphicon glyphicon-heart-empty");
									}
									if(result=="yes"){
									$("#collect").text("取消收藏");
									$("#collect").removeClass("glyphicon glyphicon-heart-empty");
										$("#collect").addClass("glyphicon glyphicon-heart");
									}
								}
							});					
					});
				$("#jubao").click(function(){
						var textarea=$("#jubaocontent").val();	
						$.ajax({
							type:"GET",
							url:"reportShop_report",
							data:"report.comment="+textarea+"&shop.id="+${currShop.id},
							dataType:"json",
							success:function(result){
								if(result=="noUser"){
									window.top.location.href="login.jsp";
								}else{
									alert("举报成功！");
										window.top.location.href="pre_ShopFoodDetail_predo?shop.id="+'${currShop.id}';
								}
							}
						});
				});
				
					$("#personCenter1").click(function(){
					window.top.location.href="skip_skip?operate=1";
				
					});
					$("#personCenter2").click(function(){
					window.top.location.href="skip_skip?operate=2";
				
					});
					$("#personCenter3").click(function(){
					window.top.location.href="skip_skip?operate=3";
				
					});
					$("#personCenter4").click(function(){
					window.top.location.href="skip_skip?operate=4";
				
					});
					$("#personCenter5").click(function(){
					window.top.location.href="skip_skip?operate=5";
				
					});
				
			});
		
			
		</script>
		<style type="text/css">
			#collet:HOVER {
			
			cursor: pointer;
	
			}
		</style>
	</head>
	<body>
		<div id="continer">
			<div id="top">
					<div id="logo" >
					<a href="index.jsp"><img src="images/chaoren.jpg"  style="width:75%; height: 80%; margin-top:4%;"/></a>		
					</div>
					<div id="link" >
						<div style="margin-top: 2%;">
						<a href="main.jsp"> 首页</a>
						<c:choose>
							<c:when test="${user==null}">
								<a href="login.jsp">我的订单</a>												
							</c:when>
							<c:otherwise>
								<a  id="personCenter1">我的订单</a>	
							</c:otherwise>
						</c:choose>
							<a href="shopindex.jsp">加盟合作</a>
							</div>
					</div>
		<div id="login" >
			<c:choose>
					<c:when test="${empty user}">
						<div style="text-align: left;padding-top: 10%">
							<a href="login.jsp">登录</a><a href="register.jsp">注册</a>
						</div>
					</c:when>
				<c:otherwise>
					<div class="dropdown">
					<button type="button" class="btn dropdown-toggle" id="dropdownMenu1" 
						data-toggle="dropdown"> 
								<img src="${user.userInfo.headImg}" width="15%" />
									${user.tel}
					<span class="caret"></span>
					</button>
							<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="#" id="personCenter2"><i class="icon ion-happy-outline"></i>&nbsp;&nbsp;个人中心</a>
								</li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="#" id="personCenter3"><i class="icon ion-star"></i>&nbsp;&nbsp;我的收藏</a>
								</li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="#" id="personCenter4"><i class="icon ion-location"></i>&nbsp;&nbsp;我的地址</a>
								</li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="#" id="personCenter5"><i class="icon ion-paintbrush"></i>&nbsp;&nbsp;修改密码</a>
								</li>
								<li role="presentation" class="divider"></li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="loginOut_userLO"><i class="icon ion-power"></i>&nbsp;&nbsp;退出登录</a>
								</li>
							</ul>
						</div>
					</c:otherwise>
			</c:choose>	
					</div>
			</div>
			
			<div id="search" style="height:9%;background-image:url('images/meishibeijing.jpg');">
				<div style="float: left;margin-left:10%;border:0px solid red;">
					<img  src="${currShop.shopLogo}" class="img-circle" style="width:95%;height:95%;">
				</div>
				<div style="margin-left:2%;float:left;width:40%;height:99%;">
				<table  style="width:40%;height:99%;"border="0";>
				<tr><font color="#FFFFFF" size="5px">${currShop.shopInfo.shopName}</font></td>
				<td><i class="icon ion-star"></i>&nbsp;&nbsp;${currShop.shopScore.totalScore/currShop.shopScore.assessCount}&nbsp;
				<i class="icon ion-load-d"></i>&nbsp;&nbsp;${currShop.shopScore.assessCount}单</td></tr>
				</table>
				</div>
					<div  style="margin-left:34%;float: left;text-align: center;font-size: 20px;padding-top:2%;">
						<c:if test="${result=='yes' }">
							<span id="collect" >取消收藏</span>
						</c:if>
						<c:if test="${result=='no' || result==null }">
							<font size="4px;"><span id="collect" >收藏</span></font>
						</c:if>
					</div>
			</div>
			<div  style=" height:4%;width:60% ;float: left;text-align: center;margin-top:4px;" >
			<a  class="btn btn-link" role="button" href="searchFood_getall" target="shop">全部商品</a>
				<a  class="btn btn-link" role="button" href="searchFood_getpinjia" target="shop">客户评价</a>
				<a  class="btn btn-link" role="button" href="searchFood_getzizhi" target="shop">店铺资质</a> 
			</div>
		
			
			<div id="shop"  style="width: 80%;height:100%;float: left;">
				<iframe name="shop" src="frames/allshop.jsp" width="100%" height="90%" noresize="0" scrolling="yes" id="iframe"></iframe>
			</div>
		
			<div id="shop"  style="width:20%;height:30%;float: left;">
			 <div style="text-align:center;border:0px solid red; height:40px;background-color:#1E90FF;"><font size="5px;" color="#FFFFFF">商家公告</font></div> 
			
        <div class="card">
        <div class="item item-text-wrap" style="border:0px solid red;width:100%;height:100%;">
        ${currShop.shopInfo.content}
        </div>
      </div>
    </div>
    <div style="text-align: center;border:0px solid red; ">
			<button style="width:16%; margin-top:6%;"  class="button button-stable" data-toggle="modal" data-target="#myModal">举报商家</button>
			</div>
			<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				    <div class="modal-dialog">
				        <div class="modal-content">
				            <div class="modal-header">
				                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				                <h4 class="modal-title" id="myModalLabel">举报商家</h4>
				            </div>
				            <div class="modal-body"><textarea rows="5" cols="5" placeholder="请填写您的建议或意见" style="width: 100%" id="jubaocontent"></textarea> </div>
				            <div class="modal-footer">
				                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				                <button type="button" class="btn btn-primary" id="jubao">提交举报</button>
				            </div>
				        </div>
				    </div>
				</div>
<div id="gouwuche">
<div class="J-global-toolbar">
	<div class="toolbar-wrap J-wrap">
		<div class="toolbar">
			<div class="toolbar-panels J-panel">
				<div style="visibility: hidden;" class="J-content toolbar-panel tbar-panel-cart toolbar-animate-out">
					<h3 class="tbar-panel-header J-panel-header">
						<a href="" class="title"><i></i><em class="title">购物车</em></a>
						<span class="close-panel J-close"></span>
					</h3>
					<div class="tbar-panel-main">
						<div class="tbar-panel-content J-panel-content">
							<div id="J-cart-tips" class="tbar-tipbox hide">
								<div class="tip-inner">
									<span class="tip-text">还没有登录，登录后商品将被保存</span>
									<a href="#none" class="tip-btn J-login">登录</a>
								</div>
							</div>
							<div id="J-cart-render">
								<div class="tbar-cart-list">
									<div class="tbar-cart-item" >
										<c:choose>
											<c:when test="${empty cartSet }">
												你还没有添加商品到购物车哦！
											
											</c:when>
											<c:otherwise>
											<c:forEach items="${cartSet }" var="cart">
													<div class="jtc-item-goods">
											<span class="p-img"><a href="#" target="_blank"><img src="${cart.food.foodImg }" height="50" width="50" /></a></span>
											<div class="p-name">
												<a href="#">${cart.food.foodName }</a>
												${cart.food.introduction}
											</div>
											<div class="p-price"><strong>${cart.food.price }</strong>&nbsp;&nbsp;&nbsp;x${cart.count } </div>
											<a href="cartDo_deleteCart?cart.id=${cart.id }" class="p-del J-del">删除</a>
										</div>
											</c:forEach>
											</c:otherwise>
										</c:choose>
									</div>
							
							
									
								</div>
							</div>
						</div>
					</div>
					<div class="tbar-panel-footer J-panel-footer">
						<div class="tbar-checkout">
							<div class="jtc-number"> <strong class="J-count">${fn:length(cartSet)} </strong>件商品 </div>
							<!-- <div class="jtc-sum"> 共计：<strong class="J-total">¥113</strong> </div> -->
						</div>
					</div>
				</div>

				<div style="visibility: hidden;" data-name="follow" class="J-content toolbar-panel tbar-panel-follow">
					<h3 class="tbar-panel-header J-panel-header">
						<a  class="title"> <i></i> <em class="title">我的订单</em> </a>
						<span class="close-panel J-close"></span>
					</h3>
					<div class="tbar-panel-main">
						<div class="tbar-panel-content J-panel-content">
							<div class="tbar-tipbox2">
								<div class="tip-inner">
								<c:choose>
									<c:when test="${empty orderList }">
										你还没有订单！！									
									</c:when>
									<c:otherwise>
										<c:forEach items="${orderList }" var="order">
										<p style="background-color: white;">
										时间：${ order.orderTime}<br>
										地址：${ order.address.address}<br>
										商家：${order.shop.shopInfo.shopName}
										订单状态:${order.orderStatus.status}
										</c:forEach>
									</c:otherwise>
								</c:choose>
									<div>
									
									<a  class="personCenter" href="frames/order.jsp" target="personCenter">查看更多订单 &gt;&gt;</a>
									</div>
								 </div>
							</div>
						</div>
					</div>
					<div class="tbar-panel-footer J-panel-footer"></div>
				</div>
				
				<div style="visibility: hidden;" class="J-content toolbar-panel tbar-panel-history toolbar-animate-in">
					<h3 class="tbar-panel-header J-panel-header">
						<a  class="title"> <i></i> <em class="title">我的消息</em> </a>
						<span class="close-panel J-close"></span>
					</h3>
					<div class="tbar-panel-main">
						<div class="tbar-panel-content J-panel-content">
							<div class="jt-history-wrap">
								<c:choose>
									<c:when test="${empty userMessageSet }">
										你还没有订单！！									
									</c:when>
									<c:otherwise>
										<c:forEach items="${userMessageSet }" var="message">
										<p style="background-color: white;">
										内容：${ message.message}<br>
										时间：${ message.date}<br>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
					<div class="tbar-panel-footer J-panel-footer"></div>
				</div>
			</div>
			
			<div class="toolbar-header"></div>
			
			<div class="toolbar-tabs J-tab">
				<div class="toolbar-tab tbar-tab-cart">
					<i class="tab-ico"></i>
					<em class="tab-text ">购物车</em>
					<span class="tab-sub J-count ">${fn:length(cartSet)} </span>
				</div>
				<div class=" toolbar-tab tbar-tab-follow">
					<i class="tab-ico"></i>
					<em class="tab-text">我的订单</em>
					<span class="tab-sub J-count ">${fn:length(orderList)}</span> 
				</div>
				<div class=" toolbar-tab tbar-tab-history ">
					<i class="tab-ico"></i>
					<em class="tab-text">我的消息</em>
					<span class="tab-sub J-count ">${fn:length(userMessageSet)}</span>
				</div>
				
			</div>
			
		
			<div class="toolbar-mini"></div>
			
		</div>
		
		<div id="J-toolbar-load-hook"></div>
		
			</div>
		</div>
	</div>
		</div>
		<script src="js/nav.js"></script>
	</body>
	
</html>