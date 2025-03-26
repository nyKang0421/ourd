package com.ourd.controller.message;

import java.io.IOException;

import com.ourd.dao.BelongDAO;
import com.ourd.dao.MessageDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Belong;
import com.ourd.vo.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AgreeMsg implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("num"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		
		Message msg = MessageDAO.getInstance().msgInfo(num);
		System.out.println(msg);
		int BelongCnt = 0;
		if(msg.getState()==0) {
			// 가입 요청, take keeper
			System.out.println("가입 성공");
			Belong belong = new Belong(msg.getClub(),msg.getTake(),msg.getSend());
			BelongCnt = BelongDAO.getInstance().makeBelong(belong);
		}else if(msg.getState()==1) {
			// 가입 권유, send keeper
			System.out.println("초대 성공");
			Belong belong = new Belong(msg.getClub(),msg.getSend(),msg.getTake());
			BelongCnt = BelongDAO.getInstance().makeBelong(belong);
		}
		
		if(BelongCnt != 0) {
			System.out.println("메세지 가입 처리 성공");
			MessageDAO.getInstance().stateAgree(num);
		}
		
		return "redirect:/gomessage.do";
	}

}
