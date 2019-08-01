package com.shxt.manager.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/***
 * �ֹ�Ȩ��admin,manager,employee
 */
public class InitDataListener implements ServletContextListener {

	@Override
	public void contextInitialized( ServletContextEvent sce ) {
		System.out.println("�������ݿ�ʼ");
		//�̶�������
		Map<String, String> roleMap=new HashMap<String, String>();
		roleMap.put("admin", "����Ա");
		roleMap.put("manager", "����");
		roleMap.put("employee", "��ͨԱ��");
		//WEB�򱣴浽application�ķ�Χ
		ServletContext application=sce.getServletContext();
		application.setAttribute("roles", "roleMap");

		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("url", "sys/user/list");
		map1.put("name", "�û���Ϣ����");

		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("url", "sys/loginlog/find");
		map2.put("name", "��¼��־����");

		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("url", "sys/title/list");
		map3.put("name", "��Ŀ����");

		Map<String, Object> map4=new HashMap<String, Object>();
		map4.put("url", "sys/title/myInfo");
		map4.put("name", "�ҵ�С��");

		Map<String, Object> map5=new HashMap<String, Object>();
		map5.put("url", "sys/student/list");
		map5.put("name", "ѧ����Ϣ����");

		Map<String, Object> map6=new HashMap<String, Object>();
		map6.put("url", "sys/student/myInfo");
		map6.put("name", "ѧ������ѡ��");

		Map<String, Object> map7=new HashMap<String, Object>();
		map7.put("url", "sys/user/password");
		map7.put("name", "�޸�����");

		List<Map<String, Object>> adminList=new ArrayList<Map<String, Object>>();
		adminList.add(map1);//�û���Ϣ
		adminList.add(map2);//��½��־��Ϣ
		
		adminList.add(map3);//��Ŀ��================��
		adminList.add(map5);//ѧ����Ϣ
		adminList.add(map7);//�޸�����

		List<Map<String, Object>> managerList=new ArrayList<Map<String, Object>>();
		managerList.add(map3);
		managerList.add(map4);//�ҵ�С��
		managerList.add(map7);

		List<Map<String, Object>> employeeList=new ArrayList<Map<String, Object>>();
		employeeList.add(map6);
		employeeList.add(map7);

		Map<String, Object> menuMap=new HashMap<String, Object>();
		menuMap.put("admin", adminList);
		menuMap.put("manager", managerList);
		menuMap.put("employee", employeeList);

		application.setAttribute("menus", menuMap);
		System.out.println("�������ݽڽ���");
	}

	@Override
	public void contextDestroyed( ServletContextEvent arg0 ) {
		// TODO Auto-generated method stub

	}
}
