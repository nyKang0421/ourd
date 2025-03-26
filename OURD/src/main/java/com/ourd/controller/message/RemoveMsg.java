package com.ourd.controller.message;

import java.io.IOException;

import com.ourd.dao.MessageDAO;
import com.ourd.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveMsg implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("num"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		MessageDAO.getInstance().removeMsg(num);
		
		return "redirect:/gomessage.do";
	}

}
