package com.ourd.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import com.ourd.dao.UserDAO;
import com.ourd.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserJoinController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String tel = request.getParameter("telinit")+"-"+request.getParameter("telmiddle")+"-"+request.getParameter("tellast");
		String nickname =  request.getParameter("nickname");
		
		//System.out.println(name);
		
		int cnt = UserDAO.getInstance().insertUser(name, birth,id,pw,email,tel,nickname);
		
		request.setCharacterEncoding("utf-8");
		String ctx = request.getContextPath();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		if(cnt == 0) {
			writer.println("<script>alert('가입에 실패햐였습니다\\n다시 시도해주세요'); location.href='"+ctx+"/gojoin.do';</script>");
		}else {
			writer.println("<script>alert('가입 완료\\n로그인 후 이용해주세요'); location.href='\"+ctx+\"/main.do';</script>");
		}
		
		return null;
	}

}
