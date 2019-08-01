package com.shxt.framework.title.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shxt.framework.title.model.Title;
import com.shxt.manager.model.Pager;
@Repository
public interface TitleDao {
	//��Ŀ�б��ʼ��
	List<Title> list(Pager pager);
	//��Ŀ����
	int count(Pager pager);
	//�����Ŀ
	void add(Title title);
	//����������Ŀ�ظ�����֤
	int countTitleName(String title_name);
	//����id��ȡ��Ŀ��Ϣ
	Title load(Integer title_id);
	//�޸�
	void update(Title title);
	//ɾ��
	void delete(Integer title_id);
	//��������δѡ�����Ŀ
	List<Title> loadAllTitle();
	// ͨ����ʦ�˺Ų�ѯ��Ŀ
	List<Title> loadByUserAccount(String account);

	

}
