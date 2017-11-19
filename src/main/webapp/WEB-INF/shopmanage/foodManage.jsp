<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/25
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
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
                    <span style="margin: 8px;color: white" class="page-title">潮人外卖</span></a>
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
                            <span class="username username-hide-on-mobile"> 蒋鹏飞 </span>
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
                                <a href="shopManage/index" class="nav-link ">
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
                    <li class="nav-item open active">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-diamond"></i>
                            <span class="title">店铺管理</span>
                            <span class="selected"></span>
                            <span class="arrow open"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  ">
                                <a href="shopManage/foodType_index" class="nav-link ">
                                    <span class="title">分类管理</span>
                                </a>
                            </li>
                            <li class="nav-item active">
                                <a href="shopManage/food_index" class="nav-link ">
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
                                <a href="shopManage/unfinishedOrder_index" class="nav-link ">
                                    <span class="title">未完成</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="shopManage/finishedOrder_index" class="nav-link ">
                                    <span class="title">已完成</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item  ">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-bulb"></i>
                            <span class="title">消息通知</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  ">
                                <a href="shopManage/shopMessage_index" class="nav-link ">
                                    <span class="title">公告通知</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="shopManage/notice_index" class="nav-link ">
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
                            <span>菜品管理</span>
                        </li>
                    </ul>
                    <div class="page-toolbar">

                    </div>
                </div>
                <h1 class="page-title">菜品管理
                </h1>
                <div class="row">
                    <div class="col-md-12">
                        <div class="portlet light portlet-fit bordered">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="icon-settings font-red"></i>
                                    <span class="caption-subject font-red sbold uppercase">菜品列表</span>
                                </div>
                            </div>
                            <div class="portlet-body">
                                <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th>菜品名称</th>
                                        <th>所属分类</th>
                                        <th>价格</th>
                                        <th>菜品图片</th>
                                    </tr>
                                    </thead>
                                </table>
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
<script src="js/layout.min.js" type="text/javascript"></script>
<!-- END THEME LAYOUT SCRIPTS -->
<script type="text/javascript">
    $(document).ready(function () {
        a = function (data) {
            var count = new Array();
            for(var i in data.data){
                if(data.action == "create"){
                    data.data[i].id = 0;
                }
                count.push(data.data[i]);
            }
            return JSON.stringify(count);
        };
        editor = new $.fn.dataTable.Editor( {
            ajax: {
                create: {
                    type: 'POST',
                    url:  'shopManage/create_food',
                    contentType: 'application/json',
                    data: a
                },
                edit: {
                    type: 'POST',
                    url:  'shopManage/edit_food',
                    contentType: 'application/json',
                    data: a
                },
                remove: {
                    type: 'POST',
                    url:  'shopManage/delete_food',
                    contentType: 'application/json',
                    data: a
                },
                upload: {
                    url: "shopManage/upload_food",
                    type:"POST"
                }
            },
            table: "#example",
            idSrc: "id",
            fields: [
                {
                    name: "id",
                    type:"hidden"
                },{
                    label: "菜品名称",
                    name: "foodName"
                },
                {
                    label: "所属分类",
                    name: "foodType.id",
                    type:  "radio",
                    options: [
                        <s:iterator value="#request.foodTypeSet" var="foodType">
                            { label: "${foodType.foodTypeName}", value: ${foodType.id} },
                        </s:iterator>
                    ],
                },
                {
                    label: "价格",
                    name: "price"
                },
                {
                label: "菜品图片",
                name: "foodImg",
                type: "upload",
                display: function ( file_id ) {
                    return '<img src="'+ editor.file( 'files', file_id ).webPath+'"/>';
                },
                clearText: "清除",
                noImageText: '没有图片'
            }
            ]
        } );

        var table = $('#example').DataTable( {
            dom: "Bfrtip",
            ajax: "shopManage/load_food",
            columns: [
                { data: "foodName" },
                { data: "foodType.foodTypeName" },
                { data: "price" },
                {
                    data: "foodImg",
                    render: function ( file_id ) {
                        return file_id ?
                            '<img src="' + editor.file( 'files', file_id ).webPath+'"/>' :
                            null;
                    },
                    defaultContent: "No image",
                }
            ],
            select: true,
            buttons: [
                { extend: "create", editor: editor },
                { extend: "edit",   editor: editor },
                { extend: "remove", editor: editor }
            ]
        } );
    });
</script>
</body>
</html>