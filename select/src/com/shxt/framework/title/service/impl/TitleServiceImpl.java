package com.shxt.framework.title.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shxt.framework.title.dao.TitleDao;
import com.shxt.framework.title.model.Title;
import com.shxt.framework.title.service.TitleService;
import com.shxt.manager.model.Pager;

@Service
public class TitleServiceImpl implements TitleService {
	@Autowired
	private TitleDao titleDao;

	@Override
	public Pager list(Pager pager) {
		// 1.获取结果集数据
		List<Title> dataList = this.titleDao.list(pager);
		// 2.获取总记录数
		int totalCount = this.titleDao.count(pager);
		// 保存数据
		pager.setDatas(dataList);
		pager.setTotalCount(totalCount);
		return pager;
	}
	//添加题目
	@Override
	public void add(Title title) {
		try {
			this.titleDao.add(title);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("新增题目信息失败");
		}
	}
	//用于新增题目重复性验证
	@Override
	public void validTitleName(String title_name) {
		int count = this.titleDao.countTitleName(title_name);
		if (count > 0) {
			throw new RuntimeException("该名称已经被使用,请重新设置!");
		}
	}
	//根据id获取题目信息
	@Override
	public Title load(Integer title_id) {
		return this.titleDao.load(title_id);
	}
	//修改
	@Override
	public void update(Title title) {
		try {
			this.titleDao.update(title);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("更新题目信息失败");
		}
	}
	//删除
	@Override
	public void delete(Integer title_id) {
		this.titleDao.delete(title_id);
	}
	//加载所有未选择的题目
	@Override
	public List<Title> loadAllTitle() {
		return this.titleDao.loadAllTitle();
	}
	// 通过老师账号查询题目
	@Override
	public List<Title> loadByUserAccount(String account) {
		return this.titleDao.loadByUserAccount(account);
	}
	
	
}
