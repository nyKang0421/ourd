package com.ourd.dao;

import org.apache.ibatis.session.SqlSession;

import com.ourd.util.MybatisConfig;
import com.ourd.vo.Message;

public class MessageDAO {
	private MessageDAO() {}
	private static MessageDAO instance = new MessageDAO();
	public static MessageDAO getInstance() {
		return instance;
	}
	
	public int checkValidMsg(Message msg) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.message.validmsg", msg);
		session.close();
		return cnt;
	}
	
	public int sendMsg(Message msg) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.selectOne("mapper.message.sendmsg", msg);
		int cnt = checkValidMsg(msg);
		return cnt;
	}

}
