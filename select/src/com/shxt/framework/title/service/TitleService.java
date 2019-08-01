package com.shxt.framework.title.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shxt.framework.title.model.Title;
import com.shxt.manager.model.Pager;

public interface TitleService {
	//用户列表初始化
	Pager list(Pager pager);
	//添加题目
	void add(Title title);
	//用于新增题目重复性验证
	void validTitleName(String title_name);
	//根据id获取题目信息
	Title load(@Param("title_id") Integer title_id);
	//修改
	void update(Title title);
	//删除
	void delete(Integer title_id);
	//加载所有未选择的题目
	List<Title> loadAllTitle();
	// 通过老师账号查询题目
	List<Title> loadByUserAccount(String account);

}
