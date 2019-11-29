package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.bean.Moms;
import com.javatpoint.dao.BabyDao;

/**
 * Servlet implementation class SignUpMoms
 */
@WebServlet("/SignUpMoms")
public class SignUpMoms extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Sign Up</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navigation.html").include(request, response);
		out.print(" <a href='momsloginform.jsp' class='btn btn-primary' role='button'>Login</a> ");
		
		String fullname=request.getParameter("fullname");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		int phone=Integer.parseInt(request.getParameter("phone"));
		
		Moms m=new Moms();
		m.setFullname(fullname);
		m.setUsername(username);
		m.setEmail(email);
		m.setPassword(password);
		m.setPhone(phone);
		int status=BabyDao.save(m);
		if(status>0){
			
			out.print("<h3>Mom signed up successfully</h3>");
			request.getRequestDispatcher("signupmomsform.html").include(request, response);
			
		}else{
			out.print("Unable to sign up!");
		}
		
		request.getRequestDispatcher("footer.html").include(request, response);
		
		out.close();
	}

}
