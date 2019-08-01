<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	//项目的发布路径，例如:  /rabc
	String path = request.getContextPath();
	/*
	全路径，形式如下: http://127.0.0.1:8001/rbac/
	request.getScheme()      ——> http 获取协议
	request.getServerName()  --> 127.0.0.1 获取服务名
	request.getServerPort()  --> 8001 获取端口号
	path                     --> /rbac 获取访问的路径 路
	*/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%-- 
    <base/>标签解决路径问题
    参考文章:http://www.cnblogs.com/muqianying/archive/2012/03/16/2400280.html
--%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>老师个人信息</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/echarts.min.js"></script>
</head>

<body data-type="index">


    <header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
            <a href="javascript:;" class="tpl-logo">
                <img src="assets/img/logo.png" alt="">
            </a>
        </div>
        <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

        </div>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-bell-o"></span> 提醒 <span class="am-badge tpl-badge-success am-round">5</span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3>你有 <span class="tpl-color-success">5</span> 条提醒</h3><a href="###">全部</a></li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span> 【预览模块】移动端 查看时 手机、电脑框隐藏。</a>
                            <span class="tpl-dropdown-list-fr">3小时前</span>
                        </li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-check tpl-dropdown-ico-btn-size tpl-badge-danger"></span> 移动端，导航条下边距处理</a>
                            <span class="tpl-dropdown-list-fr">15分钟前</span>
                        </li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span> 追加统计代码</a>
                            <span class="tpl-dropdown-list-fr">2天前</span>
                        </li>
                    </ul>
                </li>
                <!-- 用户名 -->
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="tpl-header-list-user-nick">${session_user.user_name }</span><span class="tpl-header-list-user-ico"> <img src="assets/img/user01.png"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li><a href="javascript:void(0)"><span class="am-icon-bell-o"></span> 资料</a></li>
                        <li><a href="javascript:void(0)"><span class="am-icon-cog"></span> 设置</a></li>
                        <li><a href="javascript:void(0)"><span class="am-icon-power-off"></span> 退出</a></li>
                    </ul>
                </li>
                <!-- 退出系统 -->
                <li><a href="javascript:void(0)" class="tpl-header-list-link" id="loginout"><span class="am-icon-sign-out tpl-header-list-ico-out-size">注销</span></a></li>
            </ul>
        </div>
    </header>
    
    <div class="tpl-page-container tpl-page-header-fixed">
		<!-- 左侧菜单 -->
        <div class="tpl-left-nav tpl-left-nav-hover">
            <div class="tpl-left-nav-title">菜单列表</div>
            <div class="tpl-left-nav-list">
            <!-- 遍历菜单 -->
                <ul class="tpl-left-nav-menu">
                <c:forEach items="${applicationScope.menus[sessionScope.session_user.role_name] }" var="menu">
                    <li class="tpl-left-nav-item">
                  		<a href="${menu.url }" class="nav-link tpl-left-nav-link-list">
                    		<i class="am-icon-wpforms"></i>
                    			<span>${menu.name }</span>
                    		<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    	</a>
                    </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
		<!-- 主页面 -->
        <div class="tpl-content-wrapper">
            <div class="tpl-content-page-title">
             	  建大毕业设计在线选题系统
            </div>
            <ol class="am-breadcrumb">
                <li><a href="sys/main" class="am-icon-home">首页</a></li>
                <li><a href="javascript:;">个人信息</a></li>
                <li class="am-active">信息</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span>信息
                    </div>
                    <div class="tpl-portlet-input tpl-fz-ml">
                        <div class="portlet-input input-small input-inline">
                            <div class="input-icon right">
                                <i class="am-icon-search"></i>
                                <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                        </div>
                    </div>
                </div>
                <div class="tpl-block ">
                    <div class="am-g tpl-amazeui-form">
                        <div class="am-u-sm-12 am-u-md-9">
                            <form class="am-form am-form-horizontal" action="sys/title/loadByUserAccount/${session_user.account}" method="post" >
                                
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">账号</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" name="account" id="account" value="${session_user.account}" placeholder="请输入新增用户账号" disabled="disabled">
                                        
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">老师姓名</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" name="student_name" id="student_name" value="${session_user.user_name }" placeholder="输入用户的真实姓名" disabled="disabled">
                                    	
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="submit" class="am-btn am-btn-primary">查看我的小组</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            </div>
    </div>
	<!-- 引入JavaScript -->
    <script src="assets/js/jquery.min.js"></script>
    <!-- 安全退出 -->
	<script type="text/javascript">
		$(function() {
			$("#loginout").on("click", function() {
				if (confirm("确定退出系统?")) {
					window.top.location = "index";
				}
			});
		});
	</script>
	
</body>

</html>