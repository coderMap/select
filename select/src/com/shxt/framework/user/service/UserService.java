package com.shxt.framework.user.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shxt.framework.user.model.User;
import com.shxt.manager.model.Pager;

public interface UserService {
	User login(String account,String password);
	/**��ȡϵͳ�˺��б��totalCount�ܼ�¼��*/
	Pager find(Pager pager);

	/**�����û���Ϣ*/
	void add(User user);
	/**���������û���Ϣ��֤User�������Ƿ��ظ�--��֤*/
	void validAccount(String account);//��֤

	/**��ȡ�û���Ϣ*/
	User load(@Param("user_id") Integer user_id);
	/**��ȡ�û�ȫ����Ϣ*/
	List<User> loadAll();

	/**���û�����и��²���*/
	void update(User user);
	/**���û�������߼�ɾ������*/
	void delete(Integer user_id);
	/**��ѯ�û�����*/
	String selPassword(Integer user_id);
	/**���¿���*/
	void updPassword(Integer user_id,String new_password);
	
	//����ȫ����ʦ
	List<User> loadAllTeacher();

}
