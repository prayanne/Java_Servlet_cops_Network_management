package com.company.stacker.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.company.stacker.dao.NetworkNodeDAO;

/**
 * Servlet implementation class NetworkNodeNewServlet
 */
@WebServlet("/node/new")
public class NetworkNodeNewServlet extends HttpServlet {
  private final NetworkNodeDAO nodeDAO = new NetworkNodeDAO();

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    long workplaceId = Long.parseLong(req.getParameter("workplaceId"));
    
    String parentId = req.getParameter("parentId");
    if (parentId != null && !parentId.isBlank()) {
        req.setAttribute("presetParentId", Long.parseLong(parentId));
    }

    req.setAttribute("workplaceId", workplaceId);
    // parent 선택용: 전체 노드 목록(최소)
    req.setAttribute("allNodes", nodeDAO.findAllByWorkplace(workplaceId));
    req.getRequestDispatcher("/WEB-INF/views/node_form.jsp").forward(req, resp);
  }
}

