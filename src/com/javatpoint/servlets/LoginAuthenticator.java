package com.javatpoint.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javatpoint.dao.BabyDao;



/**
 * Servlet implementation class LoginAuthenticator
 */
@WebServlet("/LoginAuthenticator")
public class LoginAuthenticator extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
	        if(email == null){
	                RequestDispatcher rd = request.getRequestDispatcher("logIn.jsp");
	                rd.forward(request, response);
	            }
	        String password = request.getParameter("password");
	        
	        boolean exist =  BabyDao.existUser(email, password);
	        if(exist)
	        {
	            //globalemail = email;
	            HttpSession session = request.getSession();
	            session.setAttribute("email", email);
	            RequestDispatcher rd = request.getRequestDispatcher("Home");
	            rd.forward(request, response);
	        }
	        else
	        {
	            RequestDispatcher rd = request.getRequestDispatcher("InvalidLogIn");
	            rd.forward(request, response);
	        }
	        
	}

}
