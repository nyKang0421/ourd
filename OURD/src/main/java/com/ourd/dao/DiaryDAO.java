package com.ourd.dao;

public class DiaryDAO {
	private DiaryDAO() {}
	private static DiaryDAO instance = new DiaryDAO();
	public static DiaryDAO getInstance() {
		return instance;
	}
	
}
