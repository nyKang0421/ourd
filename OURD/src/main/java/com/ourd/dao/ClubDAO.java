package com.ourd.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ourd.util.MybatisConfig;
import com.ourd.vo.Club;
import com.ourd.vo.Message;

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

	public Club getWeinfo(String we) {
		String name = we;
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		Club club = session.selectOne("mapper.club.clubinfo", name);
		session.close();
		return club;
	}

	public List<Club> getKeeperList(int num) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<Club> list = session.selectList("mapper.club.getKeeperClub", num);
		session.close();
		return list;
	}

	public ArrayList<Club> getMemberList(ArrayList<Integer> memberNum) {
		ArrayList<Club> list = null;
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		if(memberNum != null && memberNum.size() != 0) {
			list = new ArrayList<Club>();
			for(int i : memberNum) {
				list.add(session.selectOne("mapper.club.getAclub", i));
			}
		}
		session.close();
		return list;
	}

	public ArrayList<String> getSendWd(ArrayList<Message> sendlist) {
		ArrayList<String> sendWe = new ArrayList<String>();
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		for(int i = 0; i<sendlist.size(); i++) {
			int num = sendlist.get(i).getClub();
			String name = session.selectOne("mapper.club.clubname", num);
			sendWe.add(name);
		}
		session.close();
		return sendWe;
	}

	public ArrayList<String> getTakeWd(ArrayList<Message> takelist) {
		ArrayList<String> takeWe = new ArrayList<String>();
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		for(int i = 0; i<takelist.size(); i++) {
			int num = takelist.get(i).getClub();
			String name = session.selectOne("mapper.club.clubname", num);
			takeWe.add(name);
		}
		session.close();
		return takeWe;
	}

	public String getClubName(int we) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int num = we;
		String name = session.selectOne("mapper.club.clubname", num);
		session.close();
		return name;
	}


}
