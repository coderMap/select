package com.shxt.framework.user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shxt.framework.student.model.Student;
import com.shxt.framework.user.model.User;
import com.shxt.manager.model.Pager;
@Repository
public interface UserDao {
	//使用注解方式指定对应mapper文件中接受属性名或自动为param1,param2,...
	User login(@Param("account") String account,@Param("password") String password);
	/**返回系统账号列表*/
	List<User> list(Pager pager);
	/**返回总记录条数*/
	int countUsers(Pager pager);

	/**新增用户信息*/
	void add(User user);
	/**用于新增用户信息验证User的名字是否重复--记数*/
	int countAccount(String account);
	/**获取用户信息*/
	User load(@Param("user_id") Integer user_id);
	/**获取用户全部信息*/
	List<User> loadAll();

	/**对用户表进行更新操作*/
	void update(User user);
	/**对用户表进行逻辑删除操作*/
	void delete(User user);
	/**查询用户口令*/
	String selPassword(Integer user_id);
	/**更新口令*/
	void updPassword(User user);
	
	//加载全部老师
	List<User> loadAllTeacher();
	//新增的学生也添加新用户列表中
	void addStudent(Student student);
}
