package com.javatpoint.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.dao.BabyDao;

/**
 * Servlet implementation class DeleteMoms
 */
@WebServlet("/DeleteMoms")
public class DeleteMoms extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String sid=request.getParameter("id");
			int id=Integer.parseInt(sid);
			BabyDao.deletemoms(id);
			
			response.sendRedirect("ViewMoms");
	}

}
