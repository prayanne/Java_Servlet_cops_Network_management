package com.company.stacker.web;

import com.company.stacker.dao.*;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class WorkplaceDetailServlet
 */
@WebServlet("/workplace")
public class WorkplaceDetailServlet extends HttpServlet {
	private final WorkplaceDAO workplaceDAO = new WorkplaceDAO();
	private final NetworkNodeDAO nodeDAO = new NetworkNodeDAO();
	private final ReportDAO reportDAO = new ReportDAO();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long id = Long.parseLong(request.getParameter("id"));
		String tab = request.getParameter("tab");
		
		if (tab == null || tab.isBlank()) tab = "tree";
		
		request.setAttribute("workplace", workplaceDAO.findById(id));
		request.setAttribute("tab", tab);
		
		if("tree".equals(tab)) {
			request.setAttribute("nodes", nodeDAO.findFlatWithDepth(id));
		} else if ("reports".equals(tab)) {
			request.setAttribute("reports", reportDAO.findByWorkplace(id));
		} else {
			request.setAttribute("tab", "tree");
			request.setAttribute("nodes", nodeDAO.findFlatWithDepth(id));
		}
		
		request.getRequestDispatcher("/WEB-INF/views/workplace_detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
