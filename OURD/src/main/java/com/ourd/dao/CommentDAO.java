package com.ourd.dao;

public class CommentDAO {
	private CommentDAO() {}
	private static CommentDAO instance = new CommentDAO();
	public static CommentDAO getInstance() {
		return instance;
	}
	
}
