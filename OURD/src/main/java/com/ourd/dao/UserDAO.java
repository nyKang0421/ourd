package com.ourd.dao;

import org.apache.ibatis.session.SqlSession;

import com.ourd.util.MybatisConfig;
import com.ourd.vo.User;

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

	public int checkValidNickname(String nickname) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.user.validnickname", nickname);
		session.close();
		return cnt;
	}

	public int insertUser(String name, String birth, String id, String pw, String email, String tel, String nickname) {
		User user = new User(name, nickname, birth, id, pw, email, tel);
		System.out.println(user);
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.selectOne("mapper.user.insertuser", user);
		int cnt = checkValidId(user.getId());
		session.close();
		return cnt;
	}

	public int checkLogin(String id, String pw) {
		User user = new User(id, pw);
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.user.checklogin", user);
		session.close();
		return cnt;
	}

	public User getUserInfo(String id) {
		User vo = null;
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		vo = session.selectOne("mapper.user.userinfo", id);
		session.close();
		return vo;
	}
}
