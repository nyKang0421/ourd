package com.ourd.dao;

import org.apache.ibatis.session.SqlSession;

import com.ourd.util.MybatisConfig;

public class UserDAO {
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	
	public int checkValidId(String id) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.user.validid", id);
		session.close();
		return cnt;
	}
}
