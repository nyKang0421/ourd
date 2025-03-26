package com.ourd.controller.view;

import java.io.IOException;
import java.util.ArrayList;

import com.ourd.dao.ClubDAO;
import com.ourd.dao.DiaryDAO;
import com.ourd.dao.UserDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetDiaryList implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int we = Integer.parseInt(request.getParameter("clubnum"));
		System.out.println(we);
		ArrayList<Diary> list = DiaryDAO.getInstance().getDiaryList(we);
		
		
		HttpSession session = request.getSession();
		session.removeAttribute("diarylist");
		
		if(list != null && list.size() != 0) {
			ArrayList<Diary> diarylist = new ArrayList<Diary>();
			int idx = list.size()>4? 4:list.size();
			for(int i = 0; i<idx; i++)
				diarylist.add(list.get(i));
			session.setAttribute("diarylist", diarylist);
			session.setAttribute("dlpage", 0);
			int lastpage = list.size()%4 == 0?list.size()/4-1:list.size()/4;
			session.setAttribute("dllastpage", lastpage);
			String clubname = ClubDAO.getInstance().getClubName(we);
			session.setAttribute("dlClubName", clubname);
			ArrayList<String> diarywriterlist = UserDAO.getInstance().getWriterList(diarylist);
			session.setAttribute("writerlist", diarywriterlist);
			System.out.println(diarylist);
			System.out.println(diarywriterlist);
			session.setAttribute("viewerpass", true);
			session.setAttribute("nowDiaryWe", we);
		}
		
		
		return null;
	}

}
