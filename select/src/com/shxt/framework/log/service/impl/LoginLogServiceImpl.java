package com.shxt.framework.log.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shxt.framework.log.dao.LoginLogDao;
import com.shxt.framework.log.model.LoginLog;
import com.shxt.framework.log.service.LoginLogService;
import com.shxt.manager.model.Pager;
@Service
public class LoginLogServiceImpl implements LoginLogService {

	@Autowired
	private LoginLogDao loginLogDao;

	@Override
	public void insert( LoginLog loginLog ) {
		try {
			//调用inser方法
			this.loginLogDao.insert(loginLog);
		} catch (Exception ex) {
			ex.printStackTrace();
			//处理异常
			throw new RuntimeException("保存登录日志失败");
		}
	}

	@Override
	public Pager find(Pager pager) {
		Map<String, Object> tempMap = pager.getQuery();
		if(tempMap.get("startDate")!=null&&tempMap.get("endDate")!=null&&!"".equals(tempMap.get("startDate").toString())&&!"".equals(tempMap.get("endDate").toString())){
			pager.getQuery().put("flag", 3);
		}else {
			if(tempMap.get("startDate")!=null&&!"".equals(tempMap.get("startDate").toString())){
				pager.getQuery().put("flag", 1);
			}
			if(tempMap.get("endDate")!=null&&!"".equals(tempMap.get("endDate").toString())){
				pager.getQuery().put("flag", 2);
			}
		}

		//1.获取结果集数据
		List<LoginLog> dataList=this.loginLogDao.list(pager);
		System.out.println(dataList.size());
		//2.获取总记录数
		int totalCount=this.loginLogDao.count(pager);
		//保存数据
		pager.setDatas(dataList);
		pager.setTotalCount(totalCount);
		return pager;
	}

	@Override
	public void delete( String id ) {
		try {
			System.out.println(id+"service");
			this.loginLogDao.delete(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("删除日志信息失败");
		}
	}
}
