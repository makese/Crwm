<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/personDate.css"></link>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
	</head>
	<body>
	<div class="container">
	<div style="margin-top:10px;">
		<b>个&nbsp;人&nbsp;资&nbsp;料</b></div>
		
		<hr/>
		<div id="div0"><img src="../${user.userInfo.headImg }"  data-toggle="modal" data-target="#myModal" ></div>
		<div id="div1">
			<table border="0" cellspacing="" cellpadding="" id="tbl" class="table">
				<tr><th>用户名：</th><td>${user.userInfo.nickName }</td><td><a href="modifyUserName.jsp"><input type="button" id="btn1" value="【修改】"  class="btn btn-success"></a></td></tr>
				<tr><th>手机号码：</th><td>${user.tel }</td><td><a href="modifyPhon.jsp"><input type="button" id="btn2" value="【修改】"   class="btn btn-success"></a></td></tr>
				<tr><th>我的账号：</th><td>
				<c:choose>
					<c:when test="${empty user.loginId }">
						暂未绑定账号
					</c:when>
					<c:otherwise>
						${user.loginId }
					</c:otherwise>
				</c:choose>


				</td><td></td></tr>
			</table>
			<hr/>
			
		</div>
		<!-- 模态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					修改头像
				</h4>
			</div>
			<div class="modal-body">
				<form action="personCenter_modifyHeadImg" enctype="multipart/form-data" method="post">
				
					<input type="file" name="headImg">
					<input type="submit" class="btn btn-primary" value="提交头像">
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</div>
		
		
	</body>
	
</html>

