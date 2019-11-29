package com.javatpoint.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddMomsForm
 */
@WebServlet("/SignUpMomsForm")
public class SignUpMomsForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("momslogin")==null){
			request.getRequestDispatcher("signupmoms.jsp").include(request, response);
		}else{
			request.getRequestDispatcher("momsloginform.jsp").include(request, response);
		}
	}

}
