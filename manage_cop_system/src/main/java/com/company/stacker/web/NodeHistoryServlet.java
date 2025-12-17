package com.company.stacker.web;

import com.company.stacker.dao.ActivityLogDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Servlet implementation class NodeHistoryServlet
 */
@WebServlet("/node/history")
public class NodeHistoryServlet extends HttpServlet {
	private final ActivityLogDAO dao = new ActivityLogDAO();
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long nodeId = Long.parseLong(request.getParameter("nodeId"));
		
		request.setAttribute("nodeId", nodeId);
		request.setAttribute("logs", dao.findByNode(nodeId));
		request.getRequestDispatcher("/WEB-INF/views/node_history.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
