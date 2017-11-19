<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>

	<head>
		<meta charset="UTF-8">
		<title>店铺入驻首页</title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="css/shopIndex.css" />
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/registerShop.js"></script>
		<link rel="stylesheet" href="css/common.css" />
	
	</head>

	<body>
		<div id="continer">
			<div id="div1">
				<div id="div11">
					<a href="index.jsp"><img src="images/chaoren.jpg" /></a>
				</div>
				<h3>客服电话 4008-123-456</h3>
				<div id="div12">
					<!--<input type="button" value="立即入驻" id="btn" onclick="myModal" />-->
					<button class="btn btn-primary btn-lg" id="btn" data-toggle="modal" data-target="#myModal">
	立即入驻
</button>
				</div>
			</div>
			<div id="myCarousel" class="carousel slide">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="images/lunbo1.png" alt="First slide" class="img">
					</div>
					<div class="item">
						<img src="images/lunbo2.png" alt="Second slide " class="img">
					</div>
					<div class="item">
						<img src="images/lunbo3.png" alt="Third slide" class="img">
					</div>
				</div>
				<!-- 轮播（Carousel）导航 -->
				<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
				<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
			<div>
				<img src="images/2.png" width="100%" class="img"  onclick="showproto()"/>
			</div>
		</div>

		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" id="myModalDialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
						<h4 class="modal-title" id="myModalLabel">
					申请入驻（商家注册）
				</h4>
					</div>
					<div class="modal-body" style="text-align: center;">

						<font onclick="registerByPhone()">手机注册</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font onclick="registerByPassword()">账号注册</font>

					</div>

					<div style="height: 300px;overflow: auto;">
						<div id="div4">
							<iframe src="frames/registerShopByPhone.jsp" scrolling="no" noresize="0" name="panel" id="if1" name="if1"></iframe>
						</div>
						<div id="div6">
							已经注册过！请点击
							<a href="">直接登录</a>
						</div>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

	</body>

</html>
	<script type="text/javascript">
			function showproto(){
				 
				window.location.href='proto.jsp';
			}
		</script>