package com.shxt.framework.log.service;

import com.shxt.framework.log.model.LoginLog;
import com.shxt.manager.model.Pager;

public interface LoginLogService {
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
	Pager find(Pager pager);
	/**
	 * 删除
	 */
	void delete(String id);
}
