package com.shxt.framework.student.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shxt.framework.student.model.Student;
import com.shxt.manager.model.Pager;

public interface StudentService {
	//ѧ���б��ʼ��
	Pager list(Pager pager);
	//���ѧ��
	void add(Student student);
	//��������ѧ������֤�˺��Ƿ��ظ�
	void validAccount(String account);
	//�������еİ༶
	List<Student> loadAllClass();
	// ͨ��������ѯѧ��
	Student load(@Param("student_id") Integer student_id);
	// ����ѧ��
	void update(Student student);
	// ɾ��ѧ��
	void delete(Integer student_id);
	// ͨ���˺Ų�ѯѧ��
	Student loadByAccount(String account);

}
