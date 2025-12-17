package com.company.stacker.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Servlet implementation class ReportNewServlet
 */
@WebServlet("/report/new")
public class ReportNewServlet extends HttpServlet {
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long workplaceId = Long.parseLong(request.getParameter("workplaceId"));
		request.setAttribute("workplaceId", workplaceId);
		request.getRequestDispatcher("/WEB-INF/views/report_form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
