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
  <title>学生在线选题系统登陆界面</title>
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
</head>

<body data-type="login">

  <div class="am-g myapp-login">
	<div class="myapp-login-logo-block  tpl-login-max">
		<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
				吉林建大<span> 毕业设计在线选题系统</span> <i class="am-icon-skyatlas"></i>
			</div>
		</div>

		<div class="login-font">
			<i>登陆 </i> 或者 <span> 注册</span>
		</div>
		<div class="am-u-sm-10 login-am-center">
			<form class="am-form" action="sys/login" method="post">
				<fieldset>
					<div class="am-form-group" >
						<input id="account" name="account" value="${account }" type="text" placeholder="输入用户账号">
					</div>
					<br>
					<div class="am-form-group">
						<input id="password" name="password" type="password" placeholder="输入密码">
					</div>
					
					<p><button type="button" class="am-btn am-btn-default" >登录</button></p>
					<div class="am-form-group">
						<label style="color: red;">${message }</label>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</div>

  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/amazeui.min.js"></script>
  <script src="assets/js/app.js"></script>
  <script type="text/javascript">
		$(function() {
			$("button").on("click", function() {
				//var a="wukong,bajie";
				//var b=false;
				//var c=a||b; 
				//1.当结果不为false时结果c为a的值
				//2.表示false得值有"",0 ,null ,undefined,false

				//去空格
				var account = $.trim($("#account").val());
				var password = $.trim($("#password").val());

				//判断是否为空
				//===等价于typeof(A)==typeof(B)&&A==B
				//!==等价于typeof(A)==typeof(B)||A==B
				if (account === "") {
					$("form label").html("请输入账号");
					$("#account").focus();
					return false;
				}
				if (password === "") {
					$("form label").html("请输入密码");
					$("#password").focus();
					return false;
				}
				//重新赋值
				$("#account").val(account);
				$("#password").val(password);
				//表单提交
				$("form").submit();
			});
		});
	</script>
</body>

</html>