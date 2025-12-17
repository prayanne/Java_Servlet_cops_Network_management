package com.company.stacker.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.company.stacker.dao.NetworkNodeDAO;
import com.company.stacker.model.NetworkNode;

/**
 * Servlet implementation class NetworkNodeEditServlet
 */
@WebServlet("/node/edit")
public class NetworkNodeEditServlet extends HttpServlet {
  private final NetworkNodeDAO dao = new NetworkNodeDAO();

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    long id = Long.parseLong(req.getParameter("id"));
    NetworkNode node = dao.findById(id);
    req.setAttribute("node", node);
    req.getRequestDispatcher("/WEB-INF/views/node_edit.jsp").forward(req, resp);
  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
