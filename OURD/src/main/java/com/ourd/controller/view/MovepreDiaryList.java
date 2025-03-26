package com.ourd.controller.view;

import java.io.IOException;
import java.util.ArrayList;

import com.ourd.dao.DiaryDAO;
import com.ourd.dao.UserDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MovepreDiaryList implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int we = (int) session.getAttribute("nowDiaryWe");
		ArrayList<Diary> list = DiaryDAO.getInstance().getDiaryList(we);
		
		int nextPage = (int)session.getAttribute("dlpage")-1;
		System.out.println("nextPage: "+nextPage);
		
		ArrayList<Diary> diarylist = new ArrayList<Diary>();
		int start = nextPage*4;
		for(int i = start; i<start+4; i++)
			diarylist.add(list.get(i));
		session.setAttribute("diarylist", diarylist);
		session.setAttribute("dlpage", nextPage);
		ArrayList<String> diarywriterlist = UserDAO.getInstance().getWriterList(diarylist);
		session.setAttribute("writerlist", diarywriterlist);
		System.out.println(diarylist);
		System.out.println(diarywriterlist);
		session.setAttribute("viewerpass", true);
		
		return null;
	}

}
