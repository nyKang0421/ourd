package com.ourd.dao;

public class MessageDAO {
	private MessageDAO() {}
	private static MessageDAO instance = new MessageDAO();
	public static MessageDAO getInstance() {
		return instance;
	}

}
