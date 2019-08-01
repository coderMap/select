package com.shxt.framework.user.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shxt.framework.user.model.User;
import com.shxt.manager.model.Pager;

public interface UserService {
	User login(String account,String password);
	/**获取系统账号列表和totalCount总记录数*/
	Pager find(Pager pager);

	/**新增用户信息*/
	void add(User user);
	/**用于新增用户信息验证User的名字是否重复--验证*/
	void validAccount(String account);//验证

	/**获取用户信息*/
	User load(@Param("user_id") Integer user_id);
	/**获取用户全部信息*/
	List<User> loadAll();

	/**对用户表进行更新操作*/
	void update(User user);
	/**对用户表进行逻辑删除操作*/
	void delete(Integer user_id);
	/**查询用户口令*/
	String selPassword(Integer user_id);
	/**更新口令*/
	void updPassword(Integer user_id,String new_password);
	
	//加载全部老师
	List<User> loadAllTeacher();

}
