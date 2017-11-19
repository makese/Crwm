<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			 html,body,head{
				margin:0;
				padding:0;
				height: 100%;
				width: 100%;
			}
			#div1{
				
				border:0px solid red;
				width: 70%;
				height:70%;
				margin-top:5px;
			
				
				
			}
			.tbl{
				width:100%;
				height:100%;
				text-align: center;
			}
			.tbl th{
				width:10%;
				height:15%;
			}
			a{
				text-decoration:none;
				color: #000000;
				}
		
			td:hover{
      
       	color: white;
       	
       	background-color:#3366FF;
       }
		</style>
		
	</head>
	
	<body>
		<div id="div1">
			<table border="0" class="tbl">
				<tr><td><a  href="allshop.jsp"  target="main01">所有商品</a></td>
					<td><a  href="shoppingjia.jsp"  target="main01">评价</a></td>
					<td><a  href="shopzizhi.jsp"  target="main01">商家资质</td></tr>
				
				
			</table>
			
		</div>
	</body>
</html>

