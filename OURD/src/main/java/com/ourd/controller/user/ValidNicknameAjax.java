package com.ourd.controller.user;

import java.io.IOException;

import com.ourd.dao.UserDAO;
import com.ourd.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ValidNicknameAjax implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nickname = request.getParameter("inputNickname");
		System.out.println(nickname);
		String passData = UserDAO.getInstance().checkValidNickname(nickname) == 0? "valid":"notValid";
		
		response.getWriter().print(passData);
		
		return null;
	}

}
