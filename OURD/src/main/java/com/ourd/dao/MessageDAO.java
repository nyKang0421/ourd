package com.ourd.dao;

import java.util.ArrayList;
import java.util.List;

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

	public int getSendCnt(int log) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.message.sendcnt", log);
		session.close();
		return cnt;
	}

	public int getTakeCnt(int log) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.message.takecnt", log);
		session.close();
		return cnt;
	}

	public ArrayList<Message> getTakeList(int log, int take) {
		ArrayList<Message> list = new ArrayList<Message>();
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<Message> all = session.selectList("mapper.message.gettakelist", log);
		System.out.println("allpre:"+all.size());
		for(int i = 0; i<all.size();i++) {
			if(all.get(i).getState()>4) {
				all.remove(i);
				i--;
			}
		}
		System.out.println("allpost:"+all.size());
		int base = take*3;
		int total = all.size()%3 == 0? all.size()/3-1:all.size()/3;
		int limit = total == take? all.size()%3 : 3;
		limit = limit == 0? 3:limit;
		System.out.println("limit:"+limit);
		int idx = -1;
		for(int i = base ; i<base+limit;i++) {
			idx++;
			if(all.get(idx).getState()>2) {
				i--;
				continue;
			}
			list.add(all.get(i));
		}
		session.close();
		System.out.println("in tDAO : "+list);
		return list;
	}

	public ArrayList<Message> getSendList(int log, int send) {
		ArrayList<Message> list = new ArrayList<Message>();
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<Message> all = session.selectList("mapper.message.getsendlist", log);
		int base = send*3;
		int total = all.size()%3 == 0? all.size()/3-1:all.size()/3;
		int limit = total == send? all.size()%3 : 3;
		limit = limit == 0? 3:limit;
		for(int i = base ; i<base+limit;i++)
			list.add(all.get(i));
		session.close();
		System.out.println("in sDAO : "+list);
		return list;
	}

	public void stateAgree(int num) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.selectOne("mapper.message.stateagree", num);
		session.close();
		return;
	}

	public void stateDisagree(int num) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.selectOne("mapper.message.statedisagree", num);
		session.close();
	}

	public Message msgInfo(int num) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		Message msg = session.selectOne("mapper.message.msginfo", num);
		session.close();
		return msg;
	}

	public void removeMsg(int num) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.selectOne("mapper.message.removemsg", num);
		session.close();
	}

	
	
}
