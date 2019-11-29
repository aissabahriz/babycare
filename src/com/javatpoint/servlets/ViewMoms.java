package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javatpoint.bean.Baby;
import com.javatpoint.bean.Moms;
import com.javatpoint.dao.BabyDao;

/**
 * Servlet implementation class ViewMoms
 */
@WebServlet("/ViewMoms")
public class ViewMoms extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>View Moms</title>");
			out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
			out.println("</head>");
			out.println("<body>");
			request.getRequestDispatcher("navigation.html").include(request, response);
			
			
			HttpSession session=request.getSession(false);
			if(session==null||session.getAttribute("adminlogin")==null){
				
			}else{
				out.print(" <a href='AddBabySitterForm' class='btn btn-primary' role='button'>Add Babysitter</a> ");
				out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a> ");
			}
			
			request.getRequestDispatcher("atoz.html").include(request, response);
			
			out.println("<h1>View Moms</h1>");
			List<Moms> list=BabyDao.getMomsAllRecords();
			out.print("<table class='table table-bordered table-striped'>");
			out.println("<tr><th>Id</th><th>Full Name</th><th>Username</th><th>Email</th><th>phone</th><th>Delete</th></tr>");
			for(Moms m:list){
				out.println("<tr><td>"+m.getId()+"</td><td>"+m.getFullname()+"</td><td>"+m.getUsername()+"</td><td>"+m.getEmail()+"</td><td>"+m.getPhone()+"</td>");
				
				if(session==null||session.getAttribute("adminlogin")==null){
					out.println("<td>Delete</td>");
					
				}else{
				out.println("<td><a href='DeleteMoms?id="+m.getId()+"'>Delete</a></td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
			request.getRequestDispatcher("footer.html").include(request, response);
			out.close();
		}
	}


