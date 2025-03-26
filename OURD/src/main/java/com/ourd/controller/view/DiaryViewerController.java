package com.ourd.controller.view;

import java.io.IOException;

import com.ourd.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DiaryViewerController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("viewerpass") == null||!(boolean) session.getAttribute("viewerpass")) {
			session.removeAttribute("diarylist");;
		}
		session.setAttribute("viewerpass", false);
		return "view/diaryviewer";
	}

}
