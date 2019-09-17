package com.bv.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
//@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("Logged in successfully");

		out.print("Welcome "+(request.getParameter("userName")));
		
		ServletConfig config = getServletConfig();
		out.print("Config value = "+ config.getInitParameter("x"));
		 
		ServletContext context = getServletContext();
		out.print("Context value = "+ context.getInitParameter("contextParam"));
		
		out.print("<a href='ThirdServlet'>ThirdServlet</a>");
/*		response.getWriter().append("Served at: ").append(request.getContextPath());
*/	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
