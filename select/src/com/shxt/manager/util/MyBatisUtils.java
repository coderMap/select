package com.shxt.manager.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public final class MyBatisUtils {
	private MyBatisUtils() {

	}

	private final static String			PATH	= "mybatis-config.xml";
	private static SqlSessionFactory	sqlSessionFactory;//��Ա���������θ�ֵ��������������Ĭ��null
	//this��super�ؼ��ֵ�ʹ�ù���
	static {
		try {
			InputStream is = Resources.getResourceAsStream(MyBatisUtils.PATH);
			MyBatisUtils.sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();// ��ӡ��ϸ�Ĵ�����Ϣ
			throw new RuntimeException("���غ��������ļ�����");
		}
	}

	// ��ȡsqlSession
	public static SqlSession getSqlSession() {
		return MyBatisUtils.sqlSessionFactory.openSession();
	}

	// �ر���Դ
	public static void closeSqlSession( SqlSession sqlSession ) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}
