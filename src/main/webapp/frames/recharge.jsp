<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/recharge.css"></link>
		<script type="text/javascript" src="../js/recharge.js"></script>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
	
		<div id="div0">
			<div id="div1" style="display: none;" >优惠1%，实付49.5元</div>
				<div id="div2" style="display: none;" >优惠1%，实付99元</div>
					<div id="div3" style="display: none;" >优惠1%，实付198元</div>
					<div style="border:1px solid #F8F8F8;background-color:#F8F8F8">
			<form action="personCenter_addBalance" method="post">
				<table border="0"   id="tbl" class="table table-striped">
				<tr><th>账&nbsp;&nbsp;号:</th><td><input style="width:90%;height:90%;" type="text" name="user.tel" id="txt1" class="form-control" ></td></tr>
					<tr><th>充值面额:</th>
						<td><label ><input type="radio" value="50" checked="true"  name="money"  onmousemove="show()" onmouseout="hidd()" id="r1" >50元</label>
					     <label><input type="radio" value="100" name="money" id="r2" onmousemove="show1()" onmouseout="hidd1()">100元</label>
						<label><input type="radio" value="200" name="money"  id="r3"onmousemove="show2()" onmouseout="hidd2()">200元</label></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="充值"  id="sub"   class="btn btn-success" style="height:69%;width:21%;"/>
						<input type="reset" value="重置" id="res"  class="btn btn-success"  style="height:69%;width:21%;"></td></tr>
				</table>
		</form>			
			
			
		</div>	
		</div>
		
		
		
		
	</body>
</html>
