package com.shxt.framework.student.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shxt.framework.student.model.Student;
import com.shxt.manager.model.Pager;
@Repository
public interface StudentDao {
	//ѧ���б�
	List<Student> list(Pager pager);
	//ѧ������
	int count(Pager pager);
	//����ѧ��
	void add(Student student);
	//�������ظ�����֤
	int countAccount(String account);
	//�������еİ༶
	List<Student> loadAllClass();
	// ����id����ȫ������
	Student load(Integer student_id);
	// ����
	void update(Student student);
	// ɾ��
	void delete(Student student);
	// ͨ���˺Ų�ѯѧ��
	Student loadByAccount(String account);

}
