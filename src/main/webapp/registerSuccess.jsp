<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style type="text/css">
			a {
				text-decoration: none;
			}
		</style>
		<title>JavaScript控制页面5秒后自动跳转的代码</title>
		<script type="text/javascript">
			function countDown(secs, surl) {  //alert(surl); 
				 
				var jumpTo = document.getElementById('jumpTo'); 
				jumpTo.innerHTML = secs; 
				if(--secs > 0) {  
					setTimeout("countDown(" + secs + ",'" + surl + "')", 1000); 
				} 
				else  {   
					location.href = surl; 
				}
			}
		</script>
	</head>

	<body>
		<h1>恭喜您注册成功！，页面将在</h1>
		<span id="jumpTo">10</span>秒后自动跳转到登录页面<br /> 如没有跳转,请点击
		<a href="login.jsp">登录页面</a>进行登录
		<script type="text/javascript">
			countDown(10, 'login.jsp');
		</script>
	</body>
	