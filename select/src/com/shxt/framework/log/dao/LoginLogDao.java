package com.shxt.framework.log.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.shxt.framework.log.model.LoginLog;
import com.shxt.manager.model.Pager;
@Repository
public interface LoginLogDao {
	/**
	 * 添加登陆日志
	 * @param loginLog
	 * @return 返回影响的行数
	 */
	void insert(LoginLog loginLog);
	/**
	 * 业务逻辑层-返回登录日志倒叙列表
	 * @return
	 */
	List<LoginLog> list(Pager pager);
	/***
	 * 数据访问层——返回总记录数
	 * @param pager
	 * @return
	 */
	int count(Pager pager);
	/**
	 * 删除
	 */
	void delete(String id);
}
