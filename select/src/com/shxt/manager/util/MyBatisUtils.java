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
	private static SqlSessionFactory	sqlSessionFactory;//成员变量，隐形赋值，引用数据类型默认null
	//this和super关键字的使用规则
	static {
		try {
			InputStream is = Resources.getResourceAsStream(MyBatisUtils.PATH);
			MyBatisUtils.sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();// 打印详细的错误信息
			throw new RuntimeException("加载核心配置文件出错");
		}
	}

	// 获取sqlSession
	public static SqlSession getSqlSession() {
		return MyBatisUtils.sqlSessionFactory.openSession();
	}

	// 关闭资源
	public static void closeSqlSession( SqlSession sqlSession ) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}
