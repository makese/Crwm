<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


	<head>
	
		<meta charset="utf-8" />
		
		<title></title>
		
		<link rel="stylesheet" type="text/css" href="css/myOrder.css"></link>
		 <meta name="viewport" content="width=device-width, initial-scale=1">
		 <link rel="stylesheet" type="text/css" media="screen" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
         </head>
	<body>
		<div id="div0">
			<div id="div6">
				<table  class="tbl" border="0">	
					<tr><td><a href="userOrderList_setmax?operate=person" target="main"><b>&nbsp;个人中心</b></a></td></tr>	
					<tr><td><a href="userOrderList_setmax?operate=order" target="main"><b>我的订单</b></a></td></tr>
					<tr><td><a href="userOrderList_setmax?operate=evalute" target="main">待评价订单</a></td></tr>
					<tr><td><b>我的资产</b></td></tr>
					<tr><td><a href="frames/accountBalance.jsp" target="main">账户余额</a></td></tr>
					<tr><td><b>我的资料</b></td></tr>
					<tr><td><a href="frames/personDate.jsp" target="main">个人资料</a></td></tr>
					<tr><td><a href="frames/addressManager.jsp" target="main">地址管理</a></td></tr>
					<tr><td><a href="frames/modifyPwd.jsp" target="main">修改密码</a></td></tr>
					<tr><td><b><a href="frames/collect.jsp" target="main">我的收藏</b></a></td></tr>
										
					
				</table>
			</div>
			
			
			<div id="div7"><iframe frameborder="1"  width="100%" height="100%"  name="main" src="frames/personMain.jsp"></iframe></div>
			
		</div>
		
	</body>
</html>
