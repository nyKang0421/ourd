package com.ourd.controller.message;

import java.io.IOException;

import com.ourd.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MoveTakePage implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getAttribute("move"));
		String move = request.getParameter("move");
		
		HttpSession session = request.getSession();
		int num = -1;
		if(move.equals("post")) {
			num = (int) session.getAttribute("takePage") +1;
			System.out.println("nextPage:"+num);
		}else if(move.equals("pre")) {
			num = (int) session.getAttribute("takePage") -1;
			System.out.println("nextPage:"+num);
		}
		session.setAttribute("takePage", num);
		
		return "redirect:/gomessage.do";
	}

}
