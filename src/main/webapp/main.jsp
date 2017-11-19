<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/jquery-1.6.2.min.js" ></script>
		<link rel="stylesheet" href="css/nav.css" />
		<link rel="stylesheet" href="css/mian.css">
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
			var operate=${operate};
			if(operate==0){
				
				$("#personCenter").attr("hidden",true);
				$(".shopHidden").attr("hidden",false);
			
			}else{
				$("#personCenter").attr("hidden",false);
				$(".shopHidden").attr("hidden",true);
			
			}
			if(operate==1){
				
				window.personCenter.location.href="frames/order.jsp";
				
			}
			if(operate==2){
			
				window.personCenter.location.href="frames/personMain.jsp";
				
			}
			if(operate==3){
				
				window.personCenter.location.href="frames/collect.jsp";
				
			}if(operate==4){
				
				window.personCenter.location.href="frames/addressManager.jsp.jsp";
				
			}
			if(operate==5){
				
				window.personCenter.location.href="frames/modifyPwd.jsp";
				
			}
				$("#searchbtn").click(function(){
				var searchName=$("#searchtext").val();		
					window.shop.location.href="searchShop_byName?searchName="+searchName;
				});
				
				$(".personCenter").click(function(){
				
					$("#personCenter").attr("hidden",false);
					$(".shopHidden").attr("hidden",true);
				
				});
				
			});
		
		</script>
	</head>
	<body>
		<div id="continer">
			<div id="top">
					<div id="logo"  style="margin-left:5%;">
					<a href="index.jsp"><img src="images/chaoren.jpg"  style="width:80%; height:80%; margin-top:4%;"/></a>		
					</div>
					<div id="link" >
						<div style="margin-top: 2%;">
						<a href="pre_main_setAddr"> 首页</a>
						<c:choose>
							<c:when test="${user==null}">
								<a href="login.jsp">我的订单</a>												
							</c:when>
							<c:otherwise>
								<a class="personCenter" href="frames/order.jsp" target="personCenter">我的订单</a>	
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
								<img src="${user.userInfo.headImg }" width="15%" />
									${user.tel}
					<span class="caret"></span>
					</button>
							<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="myOrder.jsp" class="personCenter" target="personCenter"><i class="icon ion-happy-outline"></i>&nbsp;&nbsp;个人中心</a>
								</li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="frames/collect.jsp" class="personCenter" target="personCenter"><i class="icon ion-star"></i>&nbsp;&nbsp;我的收藏</a>
								</li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="frames/addressManager.jsp" class="personCenter" target="personCenter"><i class="icon ion-location"></i>&nbsp;&nbsp;我的地址</a>
								</li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="frames/modifyPwd.jsp" class="personCenter" target="personCenter"><i class="icon ion-paintbrush"></i>&nbsp;&nbsp;修改密码</a>
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
			
			<div id="search">
				<div id="text">
				<i  class="icon ion-android-pin"></i>&nbsp;当前位置:&nbsp;${addr }<a href="index.jsp">[切换地址]</a>
				</div>
				<div style="margin-left: 75%; height: 100%;width: 20%;margin-top: 0.5%;" class="shopHidden">
					<input type="text"   id="searchtext" placeholder="搜索商家/美食"/>
					<input type="button" value="搜索" id="searchbtn"  style="border: 0px; background-color:#1E90FF;"/>
				</div>
			</div>
				<hr  />
			<div id="shoptype" style="height: 8%; width: 80%;margin-left: 15%;" class="shopHidden" >
						<font style="color: grey;  float: left;margin-top:8px;margin-left:-3px;">商家分类:</font>	

					<div id="linklist" style="height: 100%; width: 80%;margin-left: 5%; background-color:lightblue;">
						<div class="linklist" >
								<a href="searchShop_byType?type=all" target="shop">全部商家</a>
							</div>
						<c:choose>
							<c:when test="${empty shopTypeSet}">
								
							</c:when>
							<c:otherwise>
							<c:forEach	items="${shopTypeSet}" var="shopType">
							<div class="linklist" >
								<a href="searchShop_byType?shopType.id=${shopType.id}" target="shop">${shopType.typeName}</a>
							</div>
							</c:forEach>
							</c:otherwise>						
						</c:choose>
						
						
						
					</div>
				
			</div>
			
			<div id="shop"  style="width: 60%;height:100%;margin-left: 20%;" class="shopHidden" style="margin-top:1%;">
				<iframe name="shop" src="frames/shopiframe.jsp" width="100%" height="90%" noresize="0" frameborder="0" id="iframe"></iframe>
			</div>
			
			<div id="personCenter" style="width: 94%;height:100%;margin-left: 3%;border:0px solid red;"  >
			
			
				<iframe name="personCenter" src="myOrder.jsp" width="100%" height="90%" noresize="0" frameborder="0" id="iframe"></iframe>
			
			</div>
			
			
			<hr />
			<div style="background-color: whitesmoke; height: 30%; width:100%;" id="bottom">
					<div class="row clearfix" id="div2" style="text-align: center;">
				<span>我要开店|联系我们|服务条款和协议|加入我们</span><br />
				<span>增值MAIMENG业务许可证 :艾泽拉斯 PKQ-20170921 | 艾泽拉斯ICP20170921| 瓦罗兰工商行政管理 Copyright ©2008-2017 德玛西亚科技有限公司, All Rights Reserved.</span>
				<br/><span>版权所有@三个有趣的灵魂</span>
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
							<a class="jtc-btn J-btn personCenter" target="personCenter" href="cartDo_makeOrder?shop.id=${currShop.id }"  >立即下单</a>
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