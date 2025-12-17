package com.company.stacker.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.company.stacker.dao.NetworkNodeDAO;
import com.company.stacker.model.NetworkNode;

/**
 * Servlet implementation class NetworkNodeCreateServlet
 */
@WebServlet("/node/create")
public class NetworkNodeCreateServlet extends HttpServlet {
  private final NetworkNodeDAO dao = new NetworkNodeDAO();

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");

    NetworkNode n = new NetworkNode();
    n.setWorkplaceId(Long.parseLong(req.getParameter("workplaceId")));

    String parentId = req.getParameter("parentId");
    if (parentId == null || parentId.isBlank()) n.setParentId(null);
    else n.setParentId(Long.parseLong(parentId));

    n.setNodeType(req.getParameter("nodeType"));
    n.setDisplayName(req.getParameter("displayName"));
    n.setMetaJson(req.getParameter("metaJson"));
    String sort = req.getParameter("sortOrder");
    n.setSortOrder(sort == null || sort.isBlank() ? 0 : Integer.parseInt(sort));

    dao.insert(n);
    resp.sendRedirect(req.getContextPath() + "/workplace?id=" + n.getWorkplaceId() + "&tab=tree");
  }
}
