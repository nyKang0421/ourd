package com.ourd.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ourd.util.MybatisConfig;
import com.ourd.vo.Belong;

public class BelongDAO {
	private BelongDAO() {}
	private static BelongDAO instance = new BelongDAO();
	public static BelongDAO getInstance() {
		return instance;
	}
	
	public int checkBelong(Belong belong) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.belong.checkbelong", belong);
		session.close();
		return cnt;
	}
	
	public int makeBelong(Belong belong) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.selectOne("mapper.belong.makebelong", belong);
		int cnt = checkBelong(belong);
		session.close();
		return cnt;
	}

	public List<Integer> getClubNum(int num) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<Integer> list = session.selectList("mapper.belong.getclubnum", num);
		session.close();
		return list;
	}

	public int alreadyJoin(Belong info) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.belong.alreadyjoin", info);
		session.close();
		return cnt;
	}
	
}
