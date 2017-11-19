<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>提交商户材料</title>
		<link rel="stylesheet" href="../css/common.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/area.js"></script>
		<link rel="stylesheet" href="../css/shopForm.css" />
			<style type="text/css">
			#nextstep{
			background-color: #1E90FF;
			color: white;
			border: 0px;
			width: 30%;
			height: 5%
		}
		b{
			color: red;
		}
		.warn{
			display: none;
		}
			</style>
			</head>
			<body>
			<div id="continer">
			<div id="text">1.基本信息</div>
			<div id="text1">2.身份信息</div>
			<div id="text2">3.资质信息</div>
			<div id="text3">4.完成</div><br />
			<div class="progress">
			<div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 25%;">
			<span class="sr-only">25% 完成</span>
			</div>
			</div>
			<div id="form">
			<font>带*号的为必填项</font><br />
			<div id="content">
			*门店名称&nbsp;&nbsp;<b id="b1">请填写门店名称</b><br />
			<input type="text" placeholder="例如：肥仔砂锅饭" id="shopName"/>
			<br /><br />*手机号&nbsp;&nbsp;<b id="b2">请填写手机号</b> &nbsp;&nbsp;<b id="b6">手机号已经被绑定</b><br />
			<c:choose>
					<c:when test="${currShop.tel eq null }">
			<input type="text"  id="shopTel" />		
					</c:when>
					<c:otherwise>
			<input type="text" value="${currShop.tel}*" readonly="readonly" style="background-color: lightgray; text-shadow: none;"id="shopTel" />		
					</c:otherwise>
			</c:choose>
			<br /><br>*门店分类&nbsp;&nbsp;<b id="b3">请选择门店分类</b> <br />
			<select id="shopType">
			<option selected="selected">请选择</option>
			<c:forEach items="${shopTypeSet}" var="shopType">
			<option>${shopType.typeName}</option>	
			</c:forEach>
			</select><br /><br />
			*配送能力&nbsp;&nbsp;<b id="b4">请选择是否有配送能力</b> <br /><input type="radio" name="peisong" />&nbsp;
			&nbsp;
			有 &nbsp;
			&nbsp;
			<input type="radio" name="peisong" />&nbsp;
			&nbsp;
			无<br/><br />*门店地址&nbsp;&nbsp;<b id="b5">请填写门店地址</b> <div><div class="info"><div><select id="s_province" name="s_province" class="addr"></select><br/><br/>
			<select id="s_city" name="s_city" class="addr"></select><br/><br/><select id="s_county" name="s_county" class="addr"></select><br/><br/>
			<script class="resources library" src="area.js" type="text/javascript">
			</script>
			<script type="text/javascript">_init_area();
			</script>
			<input type="text"  id="shopAddress" class="addr" placeholder="请输入具体地址（精确到门牌号码）"/><br/><br/>
	
						</div>
							<div id="show">
							</div>
						</div>
						</div>
						<input type="button" value="下一步"  id="nextstep"  onclick="next()"/> 		
					</div>
				</div>
				</div>
			</body>
			</html>
			<script src="/js/jquery-1.8.3.min.js" type="text/javascript"></script>
			<script type="text/javascript">
			$(document).ready(function(){
					$("b").addClass("warn");
					$("#nextstep").click(function(){
					var shopName=$("#shopName").val();
					var shopTel=$("#shopTel").val();
					var shopType=$("#shopType").val();
					var shopAddress=$("#shopAddress").val();
					var s_province=$("#s_province").val();
					var s_city=$("#s_city").val();
					var s_county=$("#s_county").val();
					
						$.ajax({
							type: "GET",
							url: "shopCommit_commit",
							data:"shopName="+shopName+"&shopTel="+shopTel+"&s_city="+s_city+"&shopType="+shopType+"&shopAddress="+shopAddress+"&s_province="+s_province+"&s_county="+s_county,
							dataType:"json",
							success:function(data){
								var d=eval(data);
								if(d=="noShopName"){
									$("#b1").removeClass("warn");
								}else if(d=="noShopTel"){
									$("#b2").removeClass("warn");
								}else if(d=="noShopType"){
									$("#b3").removeClass("warn");
								}else if(d=="nos_province"){
									$("#b5").removeClass("warn");
								}else if(d=="nos_city"){
									$("#b5").removeClass("warn");
								}else if(d=="nos_county"){
									$("#b5").removeClass("warn");
								}else if(d=="noShopAddress"){
									$("#b5").removeClass("warn");
								}else if(d=="existTel"){
									$("#b6").removeClass("warn");
								}else if(d=="ok"){
									window.location.href="shopUser.jsp";
								}else if(d=="nocurrShopObj"){
									alert("请先注册账号！");
									window.top.location.href="../shopindex.jsp";
								}else if(d=="operate"){
									alert("operate！");
									
								}
									
							}
						})
					});
					
					$("#shopName").change(function(){
						if($("#shopName").val()!=""){
							$("#b1").addClass("warn");
						}
					
					}); 
					$("#shopTel").change(function(){
						if($("#shopTel").val()!=""){
							$("#b2").addClass("warn");
							$("#b6").addClass("warn");
						}
					
					}); 
					$("#shopType").change(function(){
						if($("#shopType").val()!=""){
							$("#b3").addClass("warn");
						}
					
					}); 
					$(".addr").change(function(){
						if($("#s_province").val()!=""){
							$("#b5").addClass("warn");
						}
					
					}); 
					
					
				});
			
			
			
			var Gid=document.getElementById;
			var showArea=function() {
				Gid('show').innerHTML="<h3>省"+Gid('s_province').value+" - 市"+Gid('s_city').value+" - 县/区"+Gid('s_county').value+"</h3>";
			}
			Gid('s_county').setAttribute('onchange','showArea()');
			
			
			
				
			</script>