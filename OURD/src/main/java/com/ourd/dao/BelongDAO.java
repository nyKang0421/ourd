package com.ourd.dao;

import org.apache.ibatis.session.SqlSession;

import com.ourd.util.MybatisConfig;
import com.ourd.vo.Belong;

public class BelongDAO {
	private BelongDAO() {}
	private static BelongDAO instance = new BelongDAO();
	public static BelongDAO getInstance() {
		return instance;
	}
	
	public int checkBelong(int club) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.belong.checkbelong", club);
		session.close();
		return cnt;
	}
	
	public int makeBelong(Belong belong) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.selectOne("mapper.belong.makebelong", belong);
		int cnt = checkBelong(belong.getClub());
		session.close();
		return cnt;
	}
	
}
