package com.ourd.controller.user;

import java.io.IOException;

import com.ourd.dao.UserDAO;
import com.ourd.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ValidIdAjax implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("inpuId");
		
		String passData = UserDAO.getInstance().checkValidId(id) == 0? "valid":"notValid";
		
		response.getWriter().print(passData);
		
		return null;
	}

}
