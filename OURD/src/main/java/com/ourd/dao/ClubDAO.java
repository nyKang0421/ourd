package com.ourd.dao;

import org.apache.ibatis.session.SqlSession;

import com.ourd.util.MybatisConfig;
import com.ourd.vo.Club;

public class ClubDAO {
	private ClubDAO() {}
	private static ClubDAO instance = new ClubDAO();
	public static ClubDAO getInstance() {
		return instance;
	}
	
	public int checkValidWe(String name) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.club.validwe", name);
		session.close();
		return cnt;
	}

	public Club insertClub(Club club) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.selectOne("mapper.club.insertclub", club);
		String name = club.getName();
		Club vo = session.selectOne("mapper.club.clubinfo", name);
		session.close();
		return vo;
	}
	
	

}
