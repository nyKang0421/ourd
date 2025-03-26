package com.ourd.controller.write;

import java.io.IOException;
import java.io.PrintWriter;

import com.ourd.dao.DiaryDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class InsertDiary implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int writer = (int) session.getAttribute("lognum");
		int club = Integer.parseInt(request.getParameter("choiceClub"));
		String title = request.getParameter("inputtitle");
		String content = request.getParameter("info");
		String feel = request.getParameter("inputfeel");
		String weather = request.getParameter("weatherresult");
		String img = request.getParameter("img");
		if(img.isEmpty()) {
			img = "emptyImg.jpg";
		}
		String date = request.getParameter("diarydate");
		Diary diary = new Diary(writer,club,title,content,feel,weather,img,date);
		
		System.out.println(diary);
		
		int cnt = DiaryDAO.getInstance().checkInsertResult(diary);
		
		request.setCharacterEncoding("utf-8");
		String ctx = request.getContextPath();
		PrintWriter printwriter = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		if(cnt == 0) {
			DiaryDAO.getInstance().insertDiary(diary);
			printwriter.println("<script>alert('일기 등록 성공!'); location.href='"+ctx+"/main.do';</script>");
		}else {
			printwriter.println("<script>alert('이미 같은 글을 등록했어요'); history.back();</script>");
		}
		
		
		return null;
	}

}
