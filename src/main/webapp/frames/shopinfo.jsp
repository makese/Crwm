<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../css/common.css" />
		
		<style type="text/css">
		#nextstep{
			
			background-color: #1E90FF;
			color: white;
			border: 0px;
			width: 30%;
		}
		#nextstep:hover{
			color: red;
			cursor: pointer;
		}
		#div1{
			width: 100%;
			height: 100%;
			text-align: center;
		}
		#img1,#img2{
			height: 40%;
			width: 100%;
			text-align: center;
		}
		</style>
		<script type="text/javascript">
			function next(){
				window.location.href='shopCommit_preDo';
				
			}
		</script>
		<title>商家材料</title>
	</head>
	<body>
		<div id="continer">
			<div id="img1">
				<img  src="../images/c1.jpg" width="60%" />
			</div>
			<div id="img2">
				<img  src="../images/c2.jpg" width="60%" />
			</div>
			<div id="div1">
				<p>
					
				</p>
			<input type="button" value="准备好了"  id="nextstep"  onclick="next()"/>
			</div>
		</div>
	</body>
</html>