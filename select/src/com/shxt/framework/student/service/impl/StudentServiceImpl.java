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

	// ѧ���б��ʼ��
	@Override
	public Pager list(Pager pager) {
		// 1.��ȡ���������
		List<Student> dataList = this.studentDao.list(pager);
		// 2.��ȡ�ܼ�¼��
		int totalCount = this.studentDao.count(pager);
		// ��������
		pager.setDatas(dataList);
		pager.setTotalCount(totalCount);
		return pager;
	}

	// ���ѧ��
	@Override
	public void add(Student student) {
		try {
			this.studentDao.add(student);
			// ���ѧ����ͬʱ��ѧ����Ϣ��ӵ�user���У�����ѧ����½
			this.userDao.addStudent(student);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("�����û���Ϣʧ��");
		}
	}

	// ��������ѧ������֤�˺��Ƿ��ظ�
	@Override
	public void validAccount(String account) {
		int count = this.studentDao.countAccount(account);
		if (count > 0) {
			throw new RuntimeException("�������Ѿ���ʹ��,����������!");
		}
	}

	// �������еİ༶
	@Override
	public List<Student> loadAllClass() {
		return this.studentDao.loadAllClass();
	}

	// ����id����ȫ������
	@Override
	public Student load(Integer student_id) {
		return this.studentDao.load(student_id);
	}

	// ����
	@Override
	public void update(Student student) {
		try {
			this.studentDao.update(student);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("�����û���Ϣʧ��");
		}
	}

	// ɾ��
	@Override
	public void delete(Integer student_id) {
		Student student = this.load(student_id);
		if (student.getStatus() == 1) {
			student.setStatus(-1);
		} else {
			student.setStatus(1);
		}
		try {
			this.studentDao.delete(student);// ����ʱtry{}catch{}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("ɾ���û���Ϣʧ��!");
		}
	}
	// ͨ���˺Ų�ѯѧ��
	@Override
	public Student loadByAccount(String account) {
		return this.studentDao.loadByAccount(account);
	}

}
