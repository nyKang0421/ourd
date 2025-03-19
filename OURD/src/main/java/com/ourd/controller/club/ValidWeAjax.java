package com.ourd.controller.club;

import java.io.IOException;

import com.ourd.dao.ClubDAO;
import com.ourd.dao.UserDAO;
import com.ourd.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ValidWeAjax implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String we = request.getParameter("inputWe");
		String passData = ClubDAO.getInstance().checkValidWe(we) == 0? "valid":"notValid";
		
		response.getWriter().print(passData);
		
		return null;
	}

}
