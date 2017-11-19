<%--
  Created by IntelliJ IDEA.
  User: makese
  Date: 2017/10/15
  Time: 19:14
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
    <base href="<%=basePath %>"/>
    <title>用户管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="#1 selling multi-purpose bootstrap admin theme sold in themeforest marketplace packed with angularjs, material design, rtl support with over thausands of templates and ui elements and plugins to power any type of web applications including saas and admin dashboards. Preview page of Theme #1 for statistics, charts, recent events and reports"
          name="description"/>
    <meta content="" name="author"/>
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
                            <span class="selected"></span>
                            <span class="arrow open"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item start ">
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
                                <a href="backManage/shop_index" class="nav-link ">
                                    <span class="title">所有店铺</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="backManage/uncheckShop_index" class="nav-link ">
                                    <span class="title">待审核店铺</span>
                                </a>
                            </li>

                        </ul>
                    </li>
                    <li class="nav-item open active">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-puzzle"></i>
                            <span class="title">用户管理</span>
                            <span class="selected"></span>
                            <span class="arrow open"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  active">
                                <a href="backManage/user_index" class="nav-link ">
                                    <span class="title">已注册用户</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="backManage/admin_index" class="nav-link ">
                                    <span class="title">管理员用户</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item  ">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-settings"></i>
                            <span class="title">举报管理</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  ">
                                <a href="backManage/untreatedReport_index" class="nav-link ">
                                    <span class="title">待处理</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="backManage/processedReport_index" class="nav-link ">
                                    <span class="title">已处理</span>
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
                                <a href="backManage/message_sendUserMessage" class="nav-link ">
                                    <span class="title">用户通知</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="backManage/message_sendShopMessage" class="nav-link ">
                                    <span class="title">商家通知</span>
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
                            <span>已注册的用户</span>
                        </li>
                    </ul>
                    <div class="page-toolbar">

                    </div>
                </div>
                <h1 class="page-title">已注册的用户
                </h1>
                <div class="row">
                    <div class="col-md-12">
                        <div class="portlet light portlet-fit bordered">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="icon-settings font-red"></i>
                                    <span class="caption-subject font-red sbold uppercase">用户列表</span>
                                </div>
                            </div>
                            <div class="portlet-body">
                                <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th>账号</th>
                                        <th>密码</th>
                                        <th>电话</th>
                                        <th>昵称</th>
                                        <th>姓名</th>
                                        <th>余额</th>
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
        editor = new $.fn.dataTable.Editor({
            ajax: function ( method, url, data, success, error ) {
                var count = new Array();
                for(var i in data.data){
                    count.push(data.data[i]);
                }
                url = data.action + '_user';
                $.ajax( {
                    type: "post",
                    url:url,
                    data: JSON.stringify(count),
                    contentType: "application/json",
                    success: function (json) {
                        alert(json.reason);
                        success(json);
                    },
                } );
            },
            table: "#example",
            idSrc: "id",
            fields: [{
                name: "id",
                type:"hidden"
            }, {
                label: "账号",
                name: "loginId"
            }, {
                label: "密码",
                name: "pwd"
            }, {
                label: "电话",
                name: "tel"
            }, {
                label: "昵称",
                name: "userInfo.nickName"
            }, {
                label: "姓名",
                name: "userInfo.realName"
            }, {
                label: "余额",
                name: "userInfo.balance"
            }
            ],
            i18n: {
                "create": {
                    "button": "新建",
                    "title": "新建一个新用户",
                    "submit": "新建"
                },

                "edit": {
                    "button": "修改",
                    "title": "修改用户信息",
                    "submit": "修改"
                },

                "remove": {
                    "button": "删除",
                    "title": "删除用户",
                    "submit": "删除",
                    "confirm": {
                        "_": "你确定删除这%d个用户?",
                        "1": "你确定删除这个用户?"
                    }
                },

                "error": {
                    "system": "操作异常请重试"
                },

                "multi": {
                    "title": "修改多个用户",
                    "info": "选择的用户此条信息不相同，如果不修改它们将保留各自的值，如果修改会设置为相同的值",
                    "restore": "复位",
                    "noMulti": "This input can be edited individually, but not part of a group."
                },

                "datetime": {
                    "previous": '前',
                    "next": '后',
                    "months": ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
                    "weekdays": ['星期天','星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
                    "amPm": ['上午', '下午'],
                    "unknown": '-'
                }
            }
        });
        editor.on( 'preSubmit', function ( e, o, action ) {
            if ( action !== 'remove' ) {
                var firstName = this.field( 'pwd' );
                if ( ! firstName.isMultiValue() ) {
                    if ( ! firstName.val() ) {
                        firstName.error( 'A first name must be given' );
                    }
                    if ( firstName.val().length >= 20 ) {
                        firstName.error( 'The first name length must be less that 20 characters' );
                    }
                }
                if ( this.inError() ) {
                    return false;
                }
            }
        } );
        var table = $('#example').DataTable({
            lengthChange: false,
            select: true,
            ajax: "backManage/load_user",
            columns: [
                {data: "loginId"},
                {data: "pwd"},
                {data: "tel"},
                {data: "userInfo.nickName"},
                {data: "userInfo.realName"},
                {data: "userInfo.balance"}
            ],
            "createdRow": function ( row, data, index ) {
                row;
            },
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        });

        // Display the buttons
        new $.fn.dataTable.Buttons(table, [
            {extend: "create", editor: editor},
            {extend: "edit", editor: editor},
            {extend: "remove", editor: editor}
        ]);

        table.buttons().container()
            .appendTo($('.col-sm-6:eq(0)', table.table().container()));
    });
</script>
</body>
</html>
