package com.ourd.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.ourd.dao.BelongDAO;
import com.ourd.dao.ClubDAO;
import com.ourd.dao.UserDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Club;
import com.ourd.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		request.setCharacterEncoding("utf-8");
		String ctx = request.getContextPath();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		
		int cnt = UserDAO.getInstance().checkLogin(id,pw);
		if(cnt == 0) {
			writer.println("<script>alert('아이디 또는 비밀번호를 확인해주세요'); location.href='"+ctx+"/gologin.do';</script>");
		}else if(cnt == 1) {
			User vo = UserDAO.getInstance().getUserInfo(id);
			ArrayList<Integer> memberNum = (ArrayList<Integer>)BelongDAO.getInstance().getClubNum(vo.getNum());
			System.out.println(memberNum);
			ArrayList<Club> clubKeeper = (ArrayList<Club>)ClubDAO.getInstance().getKeeperList(vo.getNum());
			ArrayList<Club> clubMember = ClubDAO.getInstance().getMemberList(memberNum);
			System.out.println("vo : "+vo);
			writer.println("<script>alert('"+vo.getNickname()+"님 어서오세요'); location.href='"+ctx+"/main.do';</script>");
			if(vo == null) {
				writer.println("<script>alert('처리과정중 오류가 발생했습니다\\n다시 시도해 주세요'); location.href='"+ctx+"/gologin.do';</script>");
			}
			HttpSession session = request.getSession();
			session.setAttribute("lognum", vo.getNum());
			session.setAttribute("logid", vo.getId());
			session.setAttribute("lognickname", vo.getNickname());
			if(clubKeeper != null && clubKeeper.size() != 0) {
				session.setAttribute("keeperclublist", clubKeeper);
			}
			if(clubMember != null && clubMember.size() != 0 ) {
				session.setAttribute("memberclublist", clubMember);
			}
			System.out.println(vo.getNum()+"/"+vo.getId()+"/"+vo.getNickname());
		}else {
			writer.println("<script>alert('처리과정중 오류가 발생했습니다\\n다시 시도해 주세요'); location.href='"+ctx+"/gologin.do';</script>");
		}
		
		return null;
	}

}
