package com.ourd.controller.user;

import java.io.IOException;

import com.ourd.dao.UserDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserInfoController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User vo = UserDAO.getInstance().getUserInfo((String)session.getAttribute("logid"));
		session.setAttribute("vo", vo);
		return "info/info";
	}

}
