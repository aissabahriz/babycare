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
 * Servlet implementation class AddMoms
 */
@WebServlet("/AddMoms")
public class AddMoms extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Mom</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navigation.html").include(request, response);
		out.print(" <a href='ViewMoms' class='btn btn-primary' role='button'>View Mom</a> ");
		out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a> ");
		
		String fullname=request.getParameter("fullname");
		int phone=Integer.parseInt(request.getParameter("phone"));
		int payment=Integer.parseInt(request.getParameter("payment"));
		
		Moms m=new Moms();
		m.setFullname(fullname);
		m.setPhone(phone);
		m.setPayment(payment);
		
		int status=BabyDao.save(m);
		if(status>0){
			
			out.print("<h3>Mom added successfully</h3>");
			request.getRequestDispatcher("addmomsform.jsp").include(request, response);
			
		}else{
			out.print("Unable to add mom!");
		}
		
		request.getRequestDispatcher("footer.html").include(request, response);
		
		out.close();
	}

}
