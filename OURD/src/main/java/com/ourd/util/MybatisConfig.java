package com.ourd.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tomcat.util.file.ConfigurationSource.Resource;

public class MybatisConfig {
	
	private static SqlSessionFactory squlSessionFactory;
	
	static {
		try {
			String resource = "com/ourd/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			squlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getInstance() {
		return squlSessionFactory;
	}

}
