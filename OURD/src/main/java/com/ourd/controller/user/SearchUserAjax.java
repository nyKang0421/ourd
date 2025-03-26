package com.ourd.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import com.ourd.dao.ClubDAO;
import com.ourd.dao.UserDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Club;
import com.ourd.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SearchUserAjax implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String infodata = request.getParameter("infodata");
		String we = infodata.split("/")[0];
		String checkData = UserDAO.getInstance().checkValidUser(we) == 0? "notexist":"exist";
		User user = UserDAO.getInstance().getUserinfo(we);
		System.out.println("checkData:"+checkData);
		System.out.println("user:"+user);
		HttpSession session = request.getSession();
		if(user == null) {
			System.out.println("검색 결과 가져오기 실패");
			session.removeAttribute("resultUser");
		}else{
			session.setAttribute("resultUser", user);
			System.out.println("clubNum:"+Integer.parseInt(infodata.split("/")[1]));
			session.setAttribute("inviteClubNum", Integer.parseInt(infodata.split("/")[1]));
		}
				
		response.getWriter().print(checkData);
		
		return null;
	}

}
