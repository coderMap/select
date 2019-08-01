<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <title>建大毕业设计在线选题系统</title>
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
                <li><a href="javascript:void(0)" class="am-icon-home">首页</a></li>
                <li><a href="javascript:void(0)">分类</a></li>
                <li class="am-active">内容</li>
            </ol>
            
            <div class="row">
                <div class="am-u-md-12 am-u-sm-12 row-mb">
	            	<div class="tpl-content-scope">
                		<div class="note note-info">
                    		<h3>建大毕业设计在线选题系统
                        		<span class="close" data-close="note"></span>
                    		</h3>
                    		<p>专注应届毕业生毕业设计在线选题，此平台公平！公正！公开！</p>
                    		<p><span class="label label-danger">提示:</span> 学生只能在登陆的状态下在线选题</p>
                		</div>
             		</div>
          		 </div>
            </div>

            <div class="row">
                <div class="am-u-md-12 am-u-sm-12 row-mb">
                    <div class="tpl-portlet">
                        <div class="tpl-portlet-title">
                            <div class="tpl-caption font-red ">
                                <i class="am-icon-bar-chart"></i>
                                <span> 建大Cloud 数据统计</span>
                            </div>
                            <div class="actions">
                                <ul class="actions-btn">
                                    <li class="green">当前时间</li>
                                </ul>
                            </div>
                        </div>
                        <div class="tpl-scrollable">
                            <div class="number-stats">
                                <div class="stat-number am-fl am-u-md-6">
                                    <div class="title am-text-right"> 学生总人数 </div>
                                    <div class="number am-text-right am-text-warning"> 2460 </div>
                                </div>
                                <div class="stat-number am-fr am-u-md-6">
                                    <div class="title"> 已经选题人数 </div>
                                    <div class="number am-text-success"> 2444 </div>
                                </div>

                            </div>

                            <table class="am-table tpl-table">
                                <thead>
                                    <tr class="tpl-table-uppercase">
                                        <th>班级</th>
                                        <th>班级总人数</th>
                                        <th>已选题人数</th>
                                        <th>选题率</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <img src="assets/img/user01.png" alt="" class="user-pic">
                                            <a class="user-name" href="###">禁言小张</a>
                                        </td>
                                        <td>￥3213</td>
                                        <td>65</td>
                                        <td class="font-green bold">26%</td>
                                    </tr>
                                    
                                    <tr>
                                        <td>
                                            <img src="assets/img/user03.png" alt="" class="user-pic">
                                            <a class="user-name" href="###">Tinker404</a>
                                        </td>
                                        <td>￥1267</td>
                                        <td>65</td>
                                        <td class="font-green bold">51%</td>
                                    </tr>
                                    
                                    
                                    <tr>
                                        <td>
                                            <img src="assets/img/user06.png" alt="" class="user-pic">
                                            <a class="user-name" href="###">小黄鸡</a>
                                        </td>
                                        <td>￥900</td>
                                        <td>65</td>
                                        <td class="font-green bold">10%</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>版权归 <a href="http://www.baidu.com/" target="_blank" title="吉林建筑大学">吉林建筑大学</a> ————— <a href="http://www.baidu.com/" title="吉林建大" target="_blank">关于我们</a>
	<!-- 引入javascript -->
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