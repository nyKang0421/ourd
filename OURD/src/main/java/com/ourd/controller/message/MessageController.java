package com.ourd.controller.message;

import java.io.IOException;
import java.util.ArrayList;

import com.ourd.dao.ClubDAO;
import com.ourd.dao.MessageDAO;
import com.ourd.dao.UserDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MessageController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("sendPage").getClass().getSimpleName());
		int send = (int) session.getAttribute("sendPage");
		int take = (int) session.getAttribute("takePage");
		int log = (int) session.getAttribute("lognum");
		
		int sendcnt = MessageDAO.getInstance().getSendCnt(log);
		int takecnt = MessageDAO.getInstance().getTakeCnt(log);
		
		if(sendcnt !=0) {
			int sendlast = sendcnt%3 == 0? sendcnt/3-1 : sendcnt/3;
			session.setAttribute("sendLast", sendlast);
			System.out.println("slPage : "+sendlast);
			ArrayList<Message> sendlist = MessageDAO.getInstance().getSendList(log, send);
			request.setAttribute("logSendMsg", sendlist);
			ArrayList<String> sendWe = ClubDAO.getInstance().getSendWd(sendlist);
			request.setAttribute("sendWe", sendWe);
			// state 1이면 take 0이면 send
			ArrayList<String> sendName = UserDAO.getInstance().getNameList(sendlist);
			request.setAttribute("sendName", sendName);
			ArrayList<String> sendText = new ArrayList<String>();
			for(int i = 0; i<sendlist.size();i++) {
				String data ="";
				if(sendlist.get(i).getState() <2) {
					data = sendName.get(i)+"님이 "+sendWe.get(i)+"에서 우리 확인중";
				}else if(sendlist.get(i).getState() == 5) {
					data = sendName.get(i)+"님과 "+sendWe.get(i)+"에서 우리 성공";
				}else if(sendlist.get(i).getState() == 6) {
					data = sendName.get(i)+"님과 "+sendWe.get(i)+"에서 우리 실패";
				}else {
					data = "예상 하지 못한 결과를 출력합니다";
				}
				sendText.add(data);
			}
			request.setAttribute("sendText", sendText);
		}
		if(takecnt != 0) {
			int takelast = takecnt%3 == 0? takecnt/3-1 : takecnt/3;
			session.setAttribute("takeLast", takelast);
			System.out.println("tlPage : "+takelast);
			ArrayList<Message> takelist = MessageDAO.getInstance().getTakeList(log, take);
			request.setAttribute("logTakeMsg", takelist);
			ArrayList<String> takeWe = ClubDAO.getInstance().getTakeWd(takelist);
			request.setAttribute("takeWe", takeWe);
			ArrayList<String> takeName = UserDAO.getInstance().getNameList(takelist);
			request.setAttribute("takeName", takeName);
			ArrayList<String> takeText = new ArrayList<String>();
			for(int i = 0; i<takelist.size();i++) {
				String data =takeName.get(i)+"님 "+takeWe.get(i)+"에서 우리 할까요?";
				takeText.add(data);
			}
			request.setAttribute("takeText", takeText);
		}

		return "message/messageview";
	}

}
