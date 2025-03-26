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

public class RemoveDiary implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("diarynum"));
		int cnt = DiaryDAO.getInstance().removeDiary(num);
		
		HttpSession session = request.getSession();
		
		if(cnt != 0) {
			System.out.println("일기 삭제에 실패했어요...");
			session.setAttribute("viewerpass", true);
			return null;
		}
		
		int we = (int) session.getAttribute("nowDiaryWe");
		ArrayList<Diary> list = DiaryDAO.getInstance().getDiaryList(we);
		System.out.println("dellistsize: "+list.size());
		if(list.size() == 0) {
			session.setAttribute("viewerpass", false);
		}
		
		int nextPage = (int)session.getAttribute("dlpage");
		if(list.size()%4==0) {
			nextPage = nextPage <= 0? 0: nextPage-1;
			session.setAttribute("dlpage", nextPage);
			int lastPage = (int)session.getAttribute("dllastpage")-1;
			session.setAttribute("dllastpage", lastPage);
		}
		
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
		ArrayList<String> diarywriterlist = UserDAO.getInstance().getWriterList(diarylist);
		session.setAttribute("writerlist", diarywriterlist);
		System.out.println(diarylist);
		System.out.println(diarywriterlist);
		
		session.setAttribute("viewerpass", true);
		
		return null;
	}

}
