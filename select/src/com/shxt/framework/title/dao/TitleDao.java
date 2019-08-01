package com.shxt.framework.title.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shxt.framework.title.model.Title;
import com.shxt.manager.model.Pager;
@Repository
public interface TitleDao {
	//题目列表初始化
	List<Title> list(Pager pager);
	//题目个数
	int count(Pager pager);
	//添加题目
	void add(Title title);
	//用于新增题目重复性验证
	int countTitleName(String title_name);
	//根据id获取题目信息
	Title load(Integer title_id);
	//修改
	void update(Title title);
	//删除
	void delete(Integer title_id);
	//加载所有未选择的题目
	List<Title> loadAllTitle();
	// 通过老师账号查询题目
	List<Title> loadByUserAccount(String account);

	

}
