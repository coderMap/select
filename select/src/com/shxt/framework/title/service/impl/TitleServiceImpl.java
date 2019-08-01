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
		// 1.��ȡ���������
		List<Title> dataList = this.titleDao.list(pager);
		// 2.��ȡ�ܼ�¼��
		int totalCount = this.titleDao.count(pager);
		// ��������
		pager.setDatas(dataList);
		pager.setTotalCount(totalCount);
		return pager;
	}
	//�����Ŀ
	@Override
	public void add(Title title) {
		try {
			this.titleDao.add(title);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("������Ŀ��Ϣʧ��");
		}
	}
	//����������Ŀ�ظ�����֤
	@Override
	public void validTitleName(String title_name) {
		int count = this.titleDao.countTitleName(title_name);
		if (count > 0) {
			throw new RuntimeException("�������Ѿ���ʹ��,����������!");
		}
	}
	//����id��ȡ��Ŀ��Ϣ
	@Override
	public Title load(Integer title_id) {
		return this.titleDao.load(title_id);
	}
	//�޸�
	@Override
	public void update(Title title) {
		try {
			this.titleDao.update(title);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("������Ŀ��Ϣʧ��");
		}
	}
	//ɾ��
	@Override
	public void delete(Integer title_id) {
		this.titleDao.delete(title_id);
	}
	//��������δѡ�����Ŀ
	@Override
	public List<Title> loadAllTitle() {
		return this.titleDao.loadAllTitle();
	}
	// ͨ����ʦ�˺Ų�ѯ��Ŀ
	@Override
	public List<Title> loadByUserAccount(String account) {
		return this.titleDao.loadByUserAccount(account);
	}
	
	
}
