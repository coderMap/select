package com.shxt.framework.user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shxt.framework.student.model.Student;
import com.shxt.framework.user.model.User;
import com.shxt.manager.model.Pager;
@Repository
public interface UserDao {
	//ʹ��ע�ⷽʽָ����Ӧmapper�ļ��н������������Զ�Ϊparam1,param2,...
	User login(@Param("account") String account,@Param("password") String password);
	/**����ϵͳ�˺��б�*/
	List<User> list(Pager pager);
	/**�����ܼ�¼����*/
	int countUsers(Pager pager);

	/**�����û���Ϣ*/
	void add(User user);
	/**���������û���Ϣ��֤User�������Ƿ��ظ�--����*/
	int countAccount(String account);
	/**��ȡ�û���Ϣ*/
	User load(@Param("user_id") Integer user_id);
	/**��ȡ�û�ȫ����Ϣ*/
	List<User> loadAll();

	/**���û�����и��²���*/
	void update(User user);
	/**���û�������߼�ɾ������*/
	void delete(User user);
	/**��ѯ�û�����*/
	String selPassword(Integer user_id);
	/**���¿���*/
	void updPassword(User user);
	
	//����ȫ����ʦ
	List<User> loadAllTeacher();
	//������ѧ��Ҳ������û��б���
	void addStudent(Student student);
}
