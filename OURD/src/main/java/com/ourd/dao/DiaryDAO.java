package com.ourd.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ourd.util.MybatisConfig;
import com.ourd.vo.Diary;

public class DiaryDAO {
	private DiaryDAO() {}
	private static DiaryDAO instance = new DiaryDAO();
	public static DiaryDAO getInstance() {
		return instance;
	}
	
	public void insertDiary(Diary diary) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.selectOne("mapper.diary.insertdiary", diary);
		session.close();
	}

	public int checkInsertResult(Diary diary) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int cnt = session.selectOne("mapper.diary.checkdiary", diary);
		session.close();
		return cnt;
	}

	public ArrayList<Diary> getDiaryList(int we) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<Diary> list = session.selectList("mapper.diary.diarylist", we);
		session.close();
		return (ArrayList<Diary>) list;
	}

	public int removeDiary(int num) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.selectOne("mapper.diary.removediary", num);
		int cnt = session.selectOne("mapper.diary.delcheckdiary", num);
		session.close();
		return cnt;
	}
	
}
