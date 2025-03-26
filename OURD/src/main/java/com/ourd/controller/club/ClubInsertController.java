package com.ourd.controller.club;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ourd.dao.BelongDAO;
import com.ourd.dao.ClubDAO;
import com.ourd.frontController.Controller;
import com.ourd.vo.Club;
import com.ourd.vo.Belong;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ClubInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("we");
		int keeper = Integer.parseInt(request.getParameter("keeperNum"));
		Club club = new Club(name, keeper);
		Club vo = ClubDAO.getInstance().insertClub(club);
		
		request.setCharacterEncoding("utf-8");
		String ctx = request.getContextPath();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		if(vo != null) {
			Belong belong = new Belong(vo.getNum(),keeper,vo.getKeeper());
			int BelongCnt = BelongDAO.getInstance().makeBelong(belong);
			if(BelongCnt == 0) {
				writer.println("<script>alert('우리를 만드는데 실패했어요\\n다시 시도해주세요'); location.href='"+ctx+"/makewe.do';</script>");
			}
			writer.println("<script>alert('우리를 만드는데 성공했습니다'); location.href='"+ctx+"/main.do';</script>");
			HttpSession session = request.getSession();
			ArrayList<Integer> memberNum = (ArrayList<Integer>)BelongDAO.getInstance().getClubNum((int)session.getAttribute("lognum"));
			ArrayList<Club> clubKeeper = (ArrayList<Club>)ClubDAO.getInstance().getKeeperList((int)session.getAttribute("lognum"));
			ArrayList<Club> clubMember = ClubDAO.getInstance().getMemberList(memberNum);
			if(clubKeeper != null && clubKeeper.size() != 0) {
				session.setAttribute("keeperclublist", clubKeeper);
			}
			if(clubMember != null && clubMember.size() != 0 ) {
				session.setAttribute("memberclublist", clubMember);
			}
		}else {
			writer.println("<script>alert('우리를 만드는데 실패했어요\\n다시 시도해주세요'); location.href='"+ctx+"/makewe.do';</script>");
		}
		
		return null;
	}

}
