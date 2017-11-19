<%--
  Created by IntelliJ IDEA.
  User: 56855
  Date: 2017/10/19
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ page pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>用户管理</title>
    <base href="<%=basePath %>"/>
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet"
          type="text/css"/>
    <link href="css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <link rel="stylesheet" type="text/css" href="css/dataTables/dataTables.bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/dataTables/buttons.bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/dataTables/select.bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/dataTables/editor.bootstrap.min.css"/>
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="css/components.min.css" rel="stylesheet" id="style_components" type="text/css"/>
    <link href="css/layout.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link rel="shortcut icon" href="favicon.ico"/>

    <!-- END THEME GLOBAL STYLES -->
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
<div class="page-wrapper">
    <div class="page-header navbar navbar-fixed-top">
        <div class="page-header-inner ">
            <div class="page-logo">
                <a href="index.html">
                    <img src="" alt="logo" class="logo-default"/> </a>
                <div class="menu-toggler sidebar-toggler">
                    <span></span>
                </div>
            </div>
            <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse"
               data-target=".navbar-collapse">
                <span></span>
            </a>
            <div class="top-menu">
                <ul class="nav navbar-nav pull-right">
                    <li class="dropdown dropdown-user">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                           data-close-others="true">
                            <img alt="" class="img-circle" src="../assets/layouts/layout/img/avatar3_small.jpg"/>
                            <span class="username username-hide-on-mobile"> Nick </span>
                            <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-default">
                            <li>
                                <a href="page_user_profile_1.html">
                                    <i class="icon-user"></i> My Profile </a>
                            </li>
                            <li>
                                <a href="app_calendar.html">
                                    <i class="icon-calendar"></i> My Calendar </a>
                            </li>
                            <li>
                                <a href="app_inbox.html">
                                    <i class="icon-envelope-open"></i> My Inbox
                                    <span class="badge badge-danger"> 3 </span>
                                </a>
                            </li>
                            <li>
                                <a href="app_todo.html">
                                    <i class="icon-rocket"></i> My Tasks
                                    <span class="badge badge-success"> 7 </span>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="page_user_lock_1.html">
                                    <i class="icon-lock"></i> Lock Screen </a>
                            </li>
                            <li>
                                <a href="page_user_login_1.html">
                                    <i class="icon-key"></i> Log Out </a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown dropdown-quick-sidebar-toggler">
                        <a href="javascript:;" class="dropdown-toggle">
                            <i class="icon-logout"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="page-container">
        <div class="page-sidebar-wrapper">
            <div class="page-sidebar navbar-collapse collapse">
                <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true"
                    data-slide-speed="200" style="padding-top: 20px">
                    <li class="sidebar-toggler-wrapper hide">
                        <div class="sidebar-toggler">
                            <span></span>
                        </div>
                    </li>
                    <li class="nav-item  ">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-home"></i>
                            <span class="title">主页</span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item">
                                <a href="backManage/index" class="nav-link ">
                                    <i class="icon-bulb"></i>
                                    <span class="title">盈利概况</span>
                                    <span class="badge badge-success">1</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="heading">
                        <h3 class="uppercase">功能</h3>
                    </li>
                    <li class="nav-item  ">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-diamond"></i>
                            <span class="title">店铺管理</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  ">
                                <a href="backManage/foodType_index" class="nav-link ">
                                    <span class="title">分类管理</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="backManage/food_index" class="nav-link ">
                                    <span class="title">菜品管理</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item  ">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-puzzle"></i>
                            <span class="title">订单管理</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  ">
                                <a href="backManage/unfinishedOrder_index" class="nav-link ">
                                    <span class="title">未完成</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="backManage/finishedOrder_index" class="nav-link ">
                                    <span class="title">已完成</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item active open">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-bulb"></i>
                            <span class="title">消息通知</span>
                            <span class="selected"></span>
                            <span class="arrow open"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item">
                                <a href="backManage/shopMessage_index" class="nav-link ">
                                    <span class="title">公告通知</span>
                                </a>
                            </li>
                            <li class="nav-item active">
                                <a href="backManage/notice_index" class="nav-link ">
                                    <span class="title">商家公告</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="page-content-wrapper">
            <div class="page-content">
                <div class="page-bar">
                    <ul class="page-breadcrumb">
                        <li>
                            <a href="index.html">主页</a>
                            <i class="fa fa-circle"></i>
                        </li>
                        <li>
                            <span>商家公告</span>
                        </li>
                    </ul>
                    <div class="page-toolbar">

                    </div>
                </div>
                <h1 class="page-title"> 商家公告
                </h1>
                <div class="row">
                    <div class="col-md-12">
                        <div class="portlet light portlet-fit bordered">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="icon-settings font-red"></i>
                                    <span class="caption-subject font-red sbold uppercase">商家公告</span>
                                </div>
                            </div>
                            <div class="portlet-body">
                                <form class="mt-clipboard-container">
                                    <textarea id="mt-clipboard-paste" class="form-control" rows="3">${currentShop.shopInfo.content}</textarea>
                                    <a class="btn green-steel mt-clipboard"><i class="icon-note" id="change-message">发布</i></a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/js.cookie.min.js" type="text/javascript"></script>
<script src="js/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="js/jquery.blockui.min.js" type="text/javascript"></script>
<script src="js/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="js/app.min.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="js/dataTables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/dataTables/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="js/dataTables/buttons.bootstrap.min.js"></script>
<script type="text/javascript" src="js/dataTables/dataTables.select.min.js"></script>
<script type="text/javascript" src="js/dataTables/dataTables.editor.min.js"></script>
<script type="text/javascript" src="js/dataTables/editor.bootstrap.min.js"></script>
<script type="text/javascript" src="js/moment.js"></script>
<script type="text/javascript" src="js/jquery-validation/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery-validation/js/additional-methods.min.js"></script>
<script type="text/javascript" src="js/moment.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="../../js/layout.min.js" type="text/javascript"></script>
<!-- END THEME LAYOUT SCRIPTS -->
<script type="text/javascript">
    $(document).ready(function () {
        $("#change-message").click( function () {
                var content = $("#mt-clipboard-paste").val();
                if( content !== ""){
                    $.post("change_notice",{content:content},function (data) {
                        var result = data.result;
                        if(result === "success"){
                            alert("发送成功");
                            $("#mt-clipboard-paste").val(content);
                        } else {
                            alert("发送失败请重试");
                        }
                    })
                } else {
                    alert("请输入商家公告");
                }
            }
        )
    });
</script>
</body>
</html>

