package com.shxt.framework.user.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shxt.framework.user.dao.UserDao;
import com.shxt.framework.user.exception.LoginException;
import com.shxt.framework.user.model.User;
import com.shxt.framework.user.service.UserService;
import com.shxt.manager.model.Pager;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	// 登录
	@Override
	public User login(String account, String password) {
		// 调用方法
		User user = this.userDao.login(account, password);
		// 判断
		if (user == null) {
			// 自定义异常继承RuntimeException抛出错误信息
			throw new LoginException("用户名或密码错误,请重新输入！");
		}
		// 返回查询到的结果
		return user;
	}

	// 分页
	@Override
	public Pager find(Pager pager) {
		pager.setDatas(this.userDao.list(pager));
		pager.setTotalCount(this.userDao.countUsers(pager));
		return pager;
	}

	// 添加
	@Override
	public void add(User user) {
		try {
			this.userDao.add(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("新增用户信息失败");
		}
	}

	// 验证用户名是否重复
	@Override
	public void validAccount(String account) {
		int count = this.userDao.countAccount(account);
		if (count > 0) {
			throw new RuntimeException("该名称已经被使用,请重新设置!");
		}
	}

	// 更新
	@Override
	public void update(User user) {
		try {
			this.userDao.update(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("更新用户信息失败");
		}
	}

	// 根据id加载全部数据
	@Override
	public User load(Integer user_id) {
		return this.userDao.load(user_id);
	}

	// 查询全部数据
	@Override
	public List<User> loadAll() {
		return this.userDao.loadAll();
	}

	// 删除
	@Override
	public void delete(Integer user_id) {
		User user = this.load(user_id);
		if (user.getStatus() == 1) {
			user.setStatus(-1);
		} else {
			user.setStatus(1);
		}
		try {
			this.userDao.delete(user);// 更新时try{}catch{}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("删除用户信息失败!");
		}
	}

	// 查询密码
	@Override
	public String selPassword(Integer user_id) {
		return this.userDao.selPassword(user_id);
	}

	// 更新密码
	@Override
	public void updPassword(Integer user_id, String new_password) {
		User user = this.load(user_id);
		user.setPassword(new_password);
		System.out.println(user);
		try {
			this.userDao.updPassword(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("更新口令失败!");
		}
	}

	//加载全部老师
	@Override
	public List<User> loadAllTeacher() {
		return this.userDao.loadAllTeacher();
	}
	
}
