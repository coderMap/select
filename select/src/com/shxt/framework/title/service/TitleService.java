package com.shxt.framework.title.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shxt.framework.title.model.Title;
import com.shxt.manager.model.Pager;

public interface TitleService {
	//�û��б��ʼ��
	Pager list(Pager pager);
	//�����Ŀ
	void add(Title title);
	//����������Ŀ�ظ�����֤
	void validTitleName(String title_name);
	//����id��ȡ��Ŀ��Ϣ
	Title load(@Param("title_id") Integer title_id);
	//�޸�
	void update(Title title);
	//ɾ��
	void delete(Integer title_id);
	//��������δѡ�����Ŀ
	List<Title> loadAllTitle();
	// ͨ����ʦ�˺Ų�ѯ��Ŀ
	List<Title> loadByUserAccount(String account);

}
