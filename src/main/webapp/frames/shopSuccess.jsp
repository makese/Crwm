<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>店铺信息</title>
			<link rel="stylesheet" href="../css/common.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="../css/shopSuccess.css" />
		<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#nextstep").click(function(){
				
					window.top.location.href="shopCommit_commitSuccess";
				
				});
			});
		</script>
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
			<div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
			<span class="sr-only">100% 完成</span>
			</div>
			</div>
			</div>
				<h1>你的信息已经提交完成，请等待审核！</h1>
				<div id="div1">
						<input type="button" value="完成"  id="nextstep"  />
		</div>
	</body>
</html>