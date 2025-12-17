package com.company.stacker.web;

import com.company.stacker.dao.WorkplaceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/workplaces")
public class WorkplaceListServlet extends HttpServlet {
	private final WorkplaceDAO dao = new WorkplaceDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("workplaces", dao.findAll());
		req.getRequestDispatcher("/WEB-INF/views/workplaces.jsp").forward(req, resp);
	}
}
