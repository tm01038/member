package com.member.lib.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX="/WEB-INF";
	private static final String SUFFIX=".jsp";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter pw = response.getWriter();
		String rootPath = request.getContextPath();
		String uri = request.getRequestURI();
		RequestDispatcher rd = request.getRequestDispatcher(rootPath+PREFIX+uri+SUFFIX);
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
