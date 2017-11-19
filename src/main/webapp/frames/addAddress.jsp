<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/addAddress.css"></link>
			<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
	</head>
	<body>
		<div id="div0">	
		<div style="border:1px solid  #F8F8F8;background-color:#F8F8F8;">
			<form action="personCenter_addAddress">
			<table id="tbl" border="0" class="table table-hover">
			<tr><td colspan="2"><center><b>添加新地址</b></center></td></tr>
			<tr><th>姓&nbsp;名 ：</th><td><input type="text" value="" id="txt1" name="address.linkPersonName" /></td></tr>
			<tr><th>性&nbsp;别:</th><td><label><input type="radio" value=" " />男</label>
			<label><input type="radio" value=" "  name="sex"/>女</label>
			</td></tr>
			<tr><th>详细地址：</th><td><input type="text" value="" id="txt1" name="address.address" /></td></tr>
			<tr><th>手机号码：</th><td><input type="text" value="" id="txt1" name="address.phoneNumber" /></td></tr>
			<tr><td colspan="2"><center><input type="submit" value="确定" id="btn1"  class="btn btn-success" />&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取消" id="btn2" class="btn btn-success"/></center></td></tr>
			</table>
			</form>
			</div>
		</div>
	</body>
</html>
