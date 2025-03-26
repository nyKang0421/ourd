package com.ourd.controller.message;

import java.io.IOException;

import com.ourd.dao.MessageDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SendJoinMsg implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int club = Integer.parseInt(request.getParameter("joinClubNum"));
		int send = Integer.parseInt(request.getParameter("joinSender"));
		int take = Integer.parseInt(request.getParameter("joinTaker"));
		int state = Integer.parseInt(request.getParameter("state"));
		Message msg = new Message(club,send,take,state);
		int cnt = MessageDAO.getInstance().sendMsg(msg);
		System.out.println("메세지 추가 됨");
		
		if(cnt == 1 ) {
			return "main";
		}else {
			return "we/joinwe";
		}
		
	}

}
