package com.ourd.dao;

public class ClubDAO {
	private ClubDAO() {}
	private static ClubDAO instance = new ClubDAO();
	public static ClubDAO getInstance() {
		return instance;
	}

}
