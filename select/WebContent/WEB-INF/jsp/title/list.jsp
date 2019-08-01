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
<title>题目列表</title>
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
                <li><a href="javascript:;">题目信息管理</a></li>
                <li class="am-active">题目列表</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                    	题目列表
                    </div>
                    <div class="tpl-portlet-input tpl-fz-ml">
                        <div class="portlet-input input-small input-inline">
                            <div class="input-icon right">
                            	<form class="form-search" action="sys/title/list" method="get" id="titleForm">
									<!-- 隐藏域信息 -->
							    	<input type="hidden" name="pageNow" id="pageNow" value="${pager.pageNow }">
							    	<input type="hidden"  id="totalPages" value="${pager.totalPages }">
									<i class="icon-search nav-search-icon"></i>
								</form>
                            <i class="am-icon-search"></i>
                            <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                        </div>
                    </div>
                </div>
                <div class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12">
                            <form class="am-form">
                                <table class="am-table am-table-striped am-table-hover table-main">
                                    <thead >
                                        <tr>
                                            <th>序号</th>
                                            <th>题目名称</th>
                                            <th>题目描述</th>
                                            <th>导师</th>
                                            <th>题目状态</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${pager.datas }" var="datas" varStatus="vs">
                                    		<tr>
										    	<td align="center">${vs.count }</td>
										        <td>${datas.title_name }</td>
										        <td>${datas.title_desc }</td>
										        <td>${datas.user.user_name }</td>
										        <td><c:if test="${datas.student.student_id==null }" var="flag">
									                  <span style="color: green; font-weight: bold;">可选</span>
									                </c:if> 
									                <c:if test="${!flag }">
									                   <span style="color: red;">已被${datas.student.student_name }选择</span>
									                </c:if>
												</td>         
												<td>
                                                	<div class="am-btn-toolbar">
                                                   		<div class="am-btn-group am-btn-group-xs">
                                                    		<a href="sys/title/add/"><li class="am-btn am-btn-default am-btn-xs am-hide-sm-only"></li><span class="am-icon-copy"></span>新增 </a>
                                                        	<a href="sys/title/update/${datas.title_id}"><li class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o">编辑</span> </li></a>
                                                        	<a href="javascript:;" onclick="doDelete('${datas.title_id}')"><button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button></a>
                                                   		</div>
                                                	</div>
                                           		</td>
									         </tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
                                <hr>
                                <div class="am-cf">
                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                        	<li>共&nbsp;&nbsp;<i class="blue">${pager.totalCount }</i>&nbsp;&nbsp;条记录，当前显示第&nbsp;<i class="blue">${requestScope.pager.pageNow }&nbsp;&nbsp;/&nbsp;&nbsp;${requestScope.pager.totalPages }&nbsp;&nbsp;</i>页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                                        	<li><a href="javascript:;" id="start">首页</a></li>
                                            <li><a href="javascript:;" id="pre">«上一页</a></li>
                                            <li><a href="javascript:;" id="next">下一页»</a></li>
                                            <li><a href="javascript:;" id="end">尾页</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="tpl-alert"></div>
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
	<script type="text/javascript">
	       $(function(){
	    	   $("#start").click(function(){
	    		   $("#pageNow").val(1);
	    		   $("#titleForm").submit();
	    	   });
			  $("#pre").click(function(){
				  var pageNow = $("#pageNow").val();   
				  if(pageNow==1){
					  alert("没有上一页");
					  return false
				  }
				  $("#pageNow").val(pageNow-1);
		          $("#titleForm").submit();
			  });
	         $("#next").click(function(){
	        	 var pageNow = $("#pageNow").val();   
	        	 var totalPages=$("#totalPages").val();
	             if(pageNow==totalPages){
	                 alert("没有下一页");
	                 return false
	             }
	             $("#pageNow").val(parseInt(pageNow)+1);
	             $("#titleForm").submit();
	          });
			 $("#end").click(function(){
			    var totalPages=$("#totalPages").val();
			    $("#pageNow").val(totalPages);
			    $("#titleForm").submit();
			 });
			 
			 //查询
			 $("#searchBtn").click(function(){
				 $("#pageNow").val(1);
	             $("#titleForm").submit();
			 });
	       });
	    </script>
	    <!-- 引入弹出框插件 -->
	    <script src="assets/plugin/layer/layer.js" type="text/javascript"></script>
	    <script type="text/javascript">
		function doDelete(title_id) {
			if (window.confirm("你确定要执行该操作吗?")) {
				$.post("sys/title/delete", {
					title_id : title_id,
					_method : "delete"
				}, function(data) {
					if (data.flag == "success") {
						//刷新窗口
						window.location.reload();
						return;
					} else {
						alert(data.message);
						return;
					}
				});
			}
		}
	</script>
</body>

</html>