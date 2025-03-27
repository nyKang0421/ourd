package com.ourd.controller.view;

import java.io.IOException;

import com.ourd.dao.ClubDAO;
import com.ourd.dao.DiaryDAO;
import com.ourd.dao.UserDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewDiary implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("diarynum"));
		System.out.println("diarynum:"+num);
		
		Diary diary = DiaryDAO.getInstance().getADiary(num);
		System.out.println("getDiary:"+diary);
		
		if(diary != null) {
			HttpSession session = request.getSession();
			String clubname = ClubDAO.getInstance().getClubName(diary.getClub());
			String writer = UserDAO.getInstance().getUserName(diary.getWriter());
			System.out.println("club/writer:"+clubname+"/"+writer);
			session.setAttribute("viewdiary", diary);
			session.setAttribute("viewdiaryclub", clubname);
			session.setAttribute("viewdiarywriter", writer);
		}
		
		return null;
	}

}
