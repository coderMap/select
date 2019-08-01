package com.shxt.manager.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/***
 * 分管权限admin,manager,employee
 */
public class InitDataListener implements ServletContextListener {

	@Override
	public void contextInitialized( ServletContextEvent sce ) {
		System.out.println("加载数据开始");
		//固定的数据
		Map<String, String> roleMap=new HashMap<String, String>();
		roleMap.put("admin", "管理员");
		roleMap.put("manager", "经理");
		roleMap.put("employee", "普通员工");
		//WEB域保存到application的范围
		ServletContext application=sce.getServletContext();
		application.setAttribute("roles", "roleMap");

		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("url", "sys/user/list");
		map1.put("name", "用户信息管理");

		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("url", "sys/loginlog/find");
		map2.put("name", "登录日志管理");

		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("url", "sys/title/list");
		map3.put("name", "题目管理");

		Map<String, Object> map4=new HashMap<String, Object>();
		map4.put("url", "sys/title/myInfo");
		map4.put("name", "我的小组");

		Map<String, Object> map5=new HashMap<String, Object>();
		map5.put("url", "sys/student/list");
		map5.put("name", "学生信息管理");

		Map<String, Object> map6=new HashMap<String, Object>();
		map6.put("url", "sys/student/myInfo");
		map6.put("name", "学生在线选题");

		Map<String, Object> map7=new HashMap<String, Object>();
		map7.put("url", "sys/user/password");
		map7.put("name", "修改密码");

		List<Map<String, Object>> adminList=new ArrayList<Map<String, Object>>();
		adminList.add(map1);//用户信息
		adminList.add(map2);//登陆日志信息
		
		adminList.add(map3);//题目（================）
		adminList.add(map5);//学生信息
		adminList.add(map7);//修改密码

		List<Map<String, Object>> managerList=new ArrayList<Map<String, Object>>();
		managerList.add(map3);
		managerList.add(map4);//我的小组
		managerList.add(map7);

		List<Map<String, Object>> employeeList=new ArrayList<Map<String, Object>>();
		employeeList.add(map6);
		employeeList.add(map7);

		Map<String, Object> menuMap=new HashMap<String, Object>();
		menuMap.put("admin", adminList);
		menuMap.put("manager", managerList);
		menuMap.put("employee", employeeList);

		application.setAttribute("menus", menuMap);
		System.out.println("加载数据节结束");
	}

	@Override
	public void contextDestroyed( ServletContextEvent arg0 ) {
		// TODO Auto-generated method stub

	}
}
