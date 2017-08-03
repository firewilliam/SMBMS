package com.jbit.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	
	static{
		
		try {
			
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			factory=new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static SqlSession creatSqlSession(){
		return factory.openSession(true);
	}
	
	public static void closeSqlSession(SqlSession sqlSession){
		
		if(sqlSession!=null){
			sqlSession.close();
		}
	}
	
	
	
}
