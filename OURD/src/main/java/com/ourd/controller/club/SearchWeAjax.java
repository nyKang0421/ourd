package com.ourd.controller.club;

import java.io.IOException;

import com.ourd.dao.ClubDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Club;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SearchWeAjax implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String we = request.getParameter("findValue");
		String checkData = ClubDAO.getInstance().checkValidWe(we) == 0? "notexist":"exist";
		Club club = ClubDAO.getInstance().getWeinfo(we);
		System.out.println(checkData);
		System.out.println(club);
		HttpSession session = request.getSession();
		if(club == null) {
			System.out.println("검색 결과 가져오기 실패");
			session.removeAttribute("resultClub");
		}else{
			session.setAttribute("resultClub", club);
		}
				
		response.getWriter().print(checkData);
		
		return null;
	}

}
