package com.shxt.framework.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shxt.framework.student.dao.StudentDao;
import com.shxt.framework.student.model.Student;
import com.shxt.framework.student.service.StudentService;
import com.shxt.framework.user.dao.UserDao;
import com.shxt.manager.model.Pager;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Autowired
	private UserDao userDao;

	// 学生列表初始化
	@Override
	public Pager list(Pager pager) {
		// 1.获取结果集数据
		List<Student> dataList = this.studentDao.list(pager);
		// 2.获取总记录数
		int totalCount = this.studentDao.count(pager);
		// 保存数据
		pager.setDatas(dataList);
		pager.setTotalCount(totalCount);
		return pager;
	}

	// 添加学生
	@Override
	public void add(Student student) {
		try {
			this.studentDao.add(student);
			// 添加学生的同时将学生信息添加到user表中，用于学生登陆
			this.userDao.addStudent(student);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("新增用户信息失败");
		}
	}

	// 用于新增学生，验证账号是否重复
	@Override
	public void validAccount(String account) {
		int count = this.studentDao.countAccount(account);
		if (count > 0) {
			throw new RuntimeException("该名称已经被使用,请重新设置!");
		}
	}

	// 加载所有的班级
	@Override
	public List<Student> loadAllClass() {
		return this.studentDao.loadAllClass();
	}

	// 根据id加载全部数据
	@Override
	public Student load(Integer student_id) {
		return this.studentDao.load(student_id);
	}

	// 更新
	@Override
	public void update(Student student) {
		try {
			this.studentDao.update(student);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("更新用户信息失败");
		}
	}

	// 删除
	@Override
	public void delete(Integer student_id) {
		Student student = this.load(student_id);
		if (student.getStatus() == 1) {
			student.setStatus(-1);
		} else {
			student.setStatus(1);
		}
		try {
			this.studentDao.delete(student);// 更新时try{}catch{}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("删除用户信息失败!");
		}
	}
	// 通过账号查询学生
	@Override
	public Student loadByAccount(String account) {
		return this.studentDao.loadByAccount(account);
	}

}
