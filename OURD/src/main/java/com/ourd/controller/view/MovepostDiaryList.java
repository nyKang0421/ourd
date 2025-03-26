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

public class MovepostDiaryList implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int we = (int) session.getAttribute("nowDiaryWe");
		ArrayList<Diary> list = DiaryDAO.getInstance().getDiaryList(we);
		
		int nextPage = (int)session.getAttribute("dlpage")+1;
		System.out.println("nextPage: "+nextPage);
		
		System.out.println("listSize: "+list.size());
		ArrayList<Diary> diarylist = new ArrayList<Diary>();
		int start = nextPage*4;
		int lastPage = (int)session.getAttribute("dllastpage");
		int end = lastPage==nextPage? start+(list.size()%4):start+4;
		System.out.println("start: "+start);
		System.out.println("end: "+end);
		end = end == start? end+4:end;
		for(int i = start; i<end; i++)
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
