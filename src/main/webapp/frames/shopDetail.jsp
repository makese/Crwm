<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>店铺信息</title>
			<link rel="stylesheet" href="../css/common.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../css/shopDetail.css" />
	<script type="text/javascript" src="../js/shopDetail.js" ></script>
	<style type="text/css">
	#nextstep{
			background-color: #1E90FF;
			color: white;
			border: 0px;
			height: 5%;
			width: 40%;
		}
	</style>
	</head>
	<body>
		<div id="continer">
			<div id="div4">
				<div id="text">1.基本信息</div>
			<div id="text1">2.身份信息</div>
			<div id="text2">3.资质信息</div>
			<div id="text3">4.完成</div><br />
			<div class="progress">
			<div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 75%;">
			<span class="sr-only">75% 完成</span>
			</div>
			</div>
			</div>
			<h2>店铺信息照片</h2>
			<form enctype="multipart/form-data" method="post" action="shopCommit_commitAptitude">
				<div id="div3">
						<div id="img1">
							<img src="../images/sfz.jpg" width="40%" height="100%"  id="preview"/>
						</div>
						<div id="img2">
							<img src="../images/sfz.jpg" width="40%" height="100%" id="preview1"/>
						</div>
					<div id="img3">
						<img src="../images/sfz.jpg" width="40%" height="100%" id="preview2"/>
					</div>
			</div>
			<div id="div2">
			<div class="file">
				<h2>门头照</h2>
				<input type="file" name="shopImg" style="float: right;"   onChange="imgPreview(this)"  />
				
			</div>
			<div class="file">
			<h2>店面照</h2>
				<input type="file" name="businessLicenseImg" style="float: right;" onChange="imgPreview1(this)"/>
			</div>
			<div class="file">
			<h2>餐饮许可证照</h2>
				<input type="file" name="foodLicense" style="float: right;" onChange="imgPreview2(this)"/>
			</div>
			</div>
				<div id="div1">
						<input type="submit" value="下一步"  id="nextstep" />
				</div>
			</form>
		</div>
	</body>
</html>