package com.ourd.frontController;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do")
@MultipartConfig(
			maxFileSize = 1024*1024*1,
			maxRequestSize = 1024*1024*10
		)
public class OurdFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		System.out.println("url: " +url);
		String ctx = request.getContextPath();
		System.out.println("ctx: "+ctx);
		String command = url.substring(ctx.length());
		System.out.println("command: "+command);
		
		String nextPage = null;
		Controller controller = null;
		
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		
		nextPage = controller.requestHandler(request, response);
		
		if(nextPage != null) {
			if(nextPage.indexOf("redirect:") != -1) {
				response.sendRedirect(ctx+nextPage.split(":")[1]);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(request, response);
			}
		}
		
	}
}
