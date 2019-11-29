package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.bean.Moms;
import com.javatpoint.dao.BabyDao;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("header.html").include(request, response);
		out.println("<h1>Home</h1>");
		
		out.print(" <div> Hello </div> ");
		out.print(" <a href='addbabyname.jsp' class='btn btn-primary' role='button'>Add Baby </a> ");
		out.print(" <a href='Payment' class='btn btn-primary' role='button'>Payment</a> ");
		out.print(" <a href='Logout' class='btn btn-primary' role='button'>Logout</a> ");
				
		request.getRequestDispatcher("footer.html").include(request, response);
		
	}


}
