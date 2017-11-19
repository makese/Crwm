<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html lang="en">  
<head>  
    <meta charset="UTF-8" />  
    <title>评价</title>  
    <link rel="stylesheet" href="http://v3.bootcss.com/dist/css/bootstrap.min.css" />  
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>  
    <style>  
        /* 向左的箭头 */    
        .glyphicon{  
            cursor: pointer;  
        }  
        .dot-left {    
            font-size: 0;    
            line-height: 0;    
            border-width: 5px;    
            border-color: #f37a0e;    
            border-left-width: 0;    
            border-style: dashed;    
            border-right-style: solid;    
            border-top-color: transparent;    
            border-bottom-color: transparent;    
            display: inline-block;  
        }   
        /* 文字提示框 */  
        .tip{  
            background: #f37a0e;  
            padding: 0 5px;  
            display: inline-block;  
            border-radius: 5px;  
        }  
        *{
        
        font-size:7px;
        }
    </style>  
</head>  
<body>  
    <div class="container">  
        <table class="table table-bordered table-hover table-striped table-condensed" style="width:50%;height:35%;margin-top:15%;margin-left:26%;">  
            <tr>  
                <td colspan='3'>  
                   <center><h5><b>潮人外卖，潮出你的style</b></h5></center>   
                </td>  
            </tr>  
            <tr>  
                <th width="33%">评价项目</th>  
                <th width="33%">星星</th>  
                <th width="33%">分数</th>  
            </tr>  
            <tr class="tr">  
                <td>商 &nbsp;品</td>  
                <td>  
                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>  
                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>  
                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>  
                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>  
                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>  
                </td>  
                <td class="score"></td>  
            </tr>  
            <tr>  
                <td colspan="3" style="text-align: center;">  
                    <button type="button" class="btn btn-success" >提交</button>   
                    <button type="button" class="btn btn-info" onclick="javascript:location.reload();">重选</button>  
                </td>  
            </tr>  
        </table>  
    </div>  
  
    <script>  
        $(function(){  
            /**  
             * 整体思路:该评价案例主要分为两种情况，1、当某行的星星还没有被选中时，此时鼠标移到哪颗星星时，就显示该星星对应的文字提示，前面的星星包括自己都变成实心星，如果该行后面还有星星，那后面的依然是空心星，鼠标离开时文字提示消失，该行星星全部变回原来的空心星；2、当某行有星星被选中，即鼠标点中某颗星，该星星以及前面的星星都变成实心星，如果该行后面还有星星，则依然还是空心星，分数和文字内容显示在该行的后面一列。鼠标移到某颗星星时，还是显示该星星对应的文字提示，前面的星星包括自己依然变成实心星，如果该行后面还有星星，那后面的依然是空心星，鼠标离开时，继续显示原来选中时星星状态。如果重新选中星星，则此时是新的评分分数，新的星星状态了。   
            为所有的span标签绑定mouseout和mouseover事件。bind({事件名：function(){},事件名：function(){}})的方法绑定多个事件  
            */  
            var tip_text = '',$parent = {};  
            $(".glyphicon").bind({  
                mouseout: function () {  
                    $parent.children('.extra').remove();  
                    var score = $parent.siblings('.score').html();  
                    if(score){//有星星选中时  
                        $parent.children(":lt("+ parseInt(score) +")").removeClass('glyphicon-star-empty').addClass('glyphicon-star');//PS:此处应该加上parseInt进行整型转换，否则会没有效果  
                        $parent.children(":gt("+ eval(parseInt(score)-1) + ")").removeClass('glyphicon-star').addClass('glyphicon-star-empty');//PS:此处要记得加eval，进行js计算，不然会报“jquery.min.js:2 Uncaught Error: Syntax error, unrecognized expression: NaN)”的错误  
                    }else{  
                        $(this).prevAll().andSelf().removeClass('glyphicon-star').addClass('glyphicon-star-empty');  
                    }  
                },  
                mouseover: function () {  
                    $parent = $(this).parent();//把父节点存放起来  
                    var score = $parent.siblings('.score').html();  
                    $parent.append('<span class="extra dot-left"></span><span class="extra tip"></span>');//添加提示框  
                    tip_text = indexText($(this).index());//得到相应的文字提示  
                    $(this).siblings('.tip').html(tip_text);//显示文字提示  
                    $(this).prevAll().andSelf().removeClass('glyphicon-star-empty').addClass('glyphicon-star');  
                    if(score){//当有星星选中时，为了解决鼠标移到选中星星的的前面星星时的小bug，此时会出现前面星星鼠标滑动时，星星颜色不变化现象  
                        $(this).nextAll().not('.extra').removeClass('glyphicon-star').addClass('glyphicon-star-empty');     
                    }  
                },  
                click: function(){  
                    var score = $(this).index() + 1;  
                    $parent.siblings('.score').html(score);  
                    $(this).prevAll().andSelf().removeClass('glyphicon-star-empty').addClass('glyphicon-star');  
                }  
            });  
  
            $('.btn-success').click(function(){  
                var allScore = '';  
                var orderId=<%=request.getParameter("orderId")%>;
                $('.score').each(function(){  
                    var text = $(this).html();  
                    if(text == ''){  
                        alert('请完成每项的评分后再提交!');  
                        throw "请完成每项的评分后再提交!";//向浏览器抛出异常，终止程序运行，用了return false试了下，还是会继续执行下面的弹窗，这里用throw刚好恰到好处,如果想继续用return false则可以改成if...else...进行判断处理也可以。  
                        //return false;  
                    }  
                   /*  allScore += $(this).siblings(":first").html() + ':' + text + '\n';   */
                   allScore+=text;
                })
                alert(allScore);
                
               
           $.ajax({
				type: "POST",
				url: "personCenter_report",
				data:"allScore="+allScore+"&orderId="+orderId,
				dataType:"json",
				success: function(result){
				
				if(result=="ok"){
				alert("主人你已经评价成功！");
				}
				if(result=="no"){
				alert("该订单评价过");
				}
				
				window.location.href="evaluteOrder.jsp";
				
				}
				
			});	 
                
            })
           
            
        })  
  
        //封装文字提示函数  
       function indexText(i){  
            switch(i){  
                case 0:  
                    return '非常不满意';  
                case 1:  
                    return '不满意';  
                case 2:  
                    return '一般';  
                case 3:  
                    return '满意';  
                case 4:  
                    return '非常满意';  
            }  
        }   
    </script>  
</body>  
</html>