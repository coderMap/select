package com.shxt.framework.student.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shxt.framework.student.model.Student;
import com.shxt.manager.model.Pager;
@Repository
public interface StudentDao {
	//学生列表
	List<Student> list(Pager pager);
	//学生总数
	int count(Pager pager);
	//新增学生
	void add(Student student);
	//新增的重复性验证
	int countAccount(String account);
	//加载所有的班级
	List<Student> loadAllClass();
	// 根据id加载全部数据
	Student load(Integer student_id);
	// 更新
	void update(Student student);
	// 删除
	void delete(Student student);
	// 通过账号查询学生
	Student loadByAccount(String account);

}
