package com.shxt.manager.interceptor;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 非法登录Session拦截器
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle( HttpServletRequest request , HttpServletResponse response , Object handler) throws Exception {
		HttpSession session=request.getSession();
		if(session.getAttribute("session_user")==null){
			//跳回登录界面
			//response.sendRedirect(request.getContextPath());//request.getContextPath()==>/
			//设置编码格式
			response.setContentType("text/html;charset=UTF-8");
			//打印输出
			PrintWriter out=response.getWriter();
			//跳转登录页面
			out.write("<script>alert('系统需要登录才能访问');window.top.location.href='"+request.getContextPath()+"/index';</script>");
			//刷新
			out.flush();
			out.close();
			return false;
		}
		return true;
	}

}
