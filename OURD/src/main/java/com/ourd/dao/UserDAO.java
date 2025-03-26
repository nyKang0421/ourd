package com.ourd.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.ourd.util.MybatisConfig;
import com.ourd.vo.Club;
import com.ourd.vo.Diary;
import com.ourd.vo.Message;
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

	public int checkValidUser(String we) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.user.validuser", we);
		session.close();
		return cnt;
	}

	public User getUserinfo(String we) {
		String nickname = we;
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		User user = session.selectOne("mapper.user.userinfobynickname", nickname);
		session.close();
		return user;
	}

	public ArrayList<String> getSendGet(ArrayList<Message> sendlist) {
		ArrayList<String> sendget = new ArrayList<String>();
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		for(int i = 0; i<sendlist.size(); i++) {
			int num = sendlist.get(i).getSend();
			String name = session.selectOne("mapper.user.username", num);
			sendget.add(name);
		}
		session.close();
		return sendget;
	}

	public ArrayList<String> getNameList(ArrayList<Message> list) {
		ArrayList<String> nameList = new ArrayList<String>();
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		for(Message m : list) {
			int num = m.getState() == 0? m.getSend():m.getTake();
			nameList.add(session.selectOne("mapper.user.username", num));
		}
		session.close();
		return nameList;
	}

	public ArrayList<String> getWriterList(ArrayList<Diary> diarylist) {
		ArrayList<String> nameList = new ArrayList<String>();
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		for(Diary d : diarylist) {
			int num = d.getWriter();
			nameList.add(session.selectOne("mapper.user.username", num));
		}
		session.close();
		return nameList;
	}
}
