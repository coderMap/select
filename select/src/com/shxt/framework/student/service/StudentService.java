package com.shxt.framework.student.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shxt.framework.student.model.Student;
import com.shxt.manager.model.Pager;

public interface StudentService {
	//学生列表初始化
	Pager list(Pager pager);
	//添加学生
	void add(Student student);
	//用于新增学生，验证账号是否重复
	void validAccount(String account);
	//加载所有的班级
	List<Student> loadAllClass();
	// 通过主键查询学生
	Student load(@Param("student_id") Integer student_id);
	// 更新学生
	void update(Student student);
	// 删除学生
	void delete(Integer student_id);
	// 通过账号查询学生
	Student loadByAccount(String account);

}
