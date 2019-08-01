package com.shxt.framework.user.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shxt.framework.user.dao.UserDao;
import com.shxt.framework.user.exception.LoginException;
import com.shxt.framework.user.model.User;
import com.shxt.framework.user.service.UserService;
import com.shxt.manager.model.Pager;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	// ��¼
	@Override
	public User login(String account, String password) {
		// ���÷���
		User user = this.userDao.login(account, password);
		// �ж�
		if (user == null) {
			// �Զ����쳣�̳�RuntimeException�׳�������Ϣ
			throw new LoginException("�û������������,���������룡");
		}
		// ���ز�ѯ���Ľ��
		return user;
	}

	// ��ҳ
	@Override
	public Pager find(Pager pager) {
		pager.setDatas(this.userDao.list(pager));
		pager.setTotalCount(this.userDao.countUsers(pager));
		return pager;
	}

	// ���
	@Override
	public void add(User user) {
		try {
			this.userDao.add(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("�����û���Ϣʧ��");
		}
	}

	// ��֤�û����Ƿ��ظ�
	@Override
	public void validAccount(String account) {
		int count = this.userDao.countAccount(account);
		if (count > 0) {
			throw new RuntimeException("�������Ѿ���ʹ��,����������!");
		}
	}

	// ����
	@Override
	public void update(User user) {
		try {
			this.userDao.update(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("�����û���Ϣʧ��");
		}
	}

	// ����id����ȫ������
	@Override
	public User load(Integer user_id) {
		return this.userDao.load(user_id);
	}

	// ��ѯȫ������
	@Override
	public List<User> loadAll() {
		return this.userDao.loadAll();
	}

	// ɾ��
	@Override
	public void delete(Integer user_id) {
		User user = this.load(user_id);
		if (user.getStatus() == 1) {
			user.setStatus(-1);
		} else {
			user.setStatus(1);
		}
		try {
			this.userDao.delete(user);// ����ʱtry{}catch{}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("ɾ���û���Ϣʧ��!");
		}
	}

	// ��ѯ����
	@Override
	public String selPassword(Integer user_id) {
		return this.userDao.selPassword(user_id);
	}

	// ��������
	@Override
	public void updPassword(Integer user_id, String new_password) {
		User user = this.load(user_id);
		user.setPassword(new_password);
		System.out.println(user);
		try {
			this.userDao.updPassword(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("���¿���ʧ��!");
		}
	}

	//����ȫ����ʦ
	@Override
	public List<User> loadAllTeacher() {
		return this.userDao.loadAllTeacher();
	}
	
}
