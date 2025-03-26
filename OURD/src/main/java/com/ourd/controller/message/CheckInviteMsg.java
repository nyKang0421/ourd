package com.ourd.controller.message;

import java.io.IOException;

import com.google.gson.Gson;
import com.ourd.dao.BelongDAO;
import com.ourd.dao.ClubDAO;
import com.ourd.dao.MessageDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Belong;
import com.ourd.vo.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckInviteMsg implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String jsonData = request.getReader().readLine();
		System.out.println("jsonData : "+jsonData);
		Gson gson = new Gson();
		Message msg = gson.fromJson(jsonData, com.ourd.vo.Message.class);
		System.out.println("msg : " + msg);
		
		int cnt = MessageDAO.getInstance().checkValidMsg(msg);
		System.out.println("msgcnt : "+cnt );
		if(cnt != 0) {
			Belong info = new Belong(msg.getClub(),msg.getTake());
			int num = BelongDAO.getInstance().alreadyJoin(info);
			if(num != 0) {
				cnt = -1;
			}
		}
		response.getWriter().print(cnt);
		
		
		return null;
	}

}
