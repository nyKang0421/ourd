package com.ourd.dao;

public class BelongDAO {
	private BelongDAO() {}
	private static BelongDAO instance = new BelongDAO();
	public static BelongDAO getInstance() {
		return instance;
	}
	
}
