package com.shxt.manager.interceptor;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * �Ƿ���¼Session������
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle( HttpServletRequest request , HttpServletResponse response , Object handler) throws Exception {
		HttpSession session=request.getSession();
		if(session.getAttribute("session_user")==null){
			//���ص�¼����
			//response.sendRedirect(request.getContextPath());//request.getContextPath()==>/
			//���ñ����ʽ
			response.setContentType("text/html;charset=UTF-8");
			//��ӡ���
			PrintWriter out=response.getWriter();
			//��ת��¼ҳ��
			out.write("<script>alert('ϵͳ��Ҫ��¼���ܷ���');window.top.location.href='"+request.getContextPath()+"/index';</script>");
			//ˢ��
			out.flush();
			out.close();
			return false;
		}
		return true;
	}

}
