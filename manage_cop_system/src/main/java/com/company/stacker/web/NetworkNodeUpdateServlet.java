package com.company.stacker.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.company.stacker.dao.NetworkNodeDAO;

/**
 * Servlet implementation class NetworkNodeUpdateServlet
 */
@WebServlet("/node/update")
public class NetworkNodeUpdateServlet extends HttpServlet {
  private final NetworkNodeDAO dao = new NetworkNodeDAO();

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");

    long id = Long.parseLong(req.getParameter("id"));
    long workplaceId = Long.parseLong(req.getParameter("workplaceId"));

    String displayName = req.getParameter("displayName");
    String metaJson = req.getParameter("metaJson");
    Integer sortOrder = null;
    String s = req.getParameter("sortOrder");
    if (s != null && !s.isBlank()) sortOrder = Integer.parseInt(s);

    dao.updateMeta(id, metaJson, displayName, sortOrder);
    resp.sendRedirect(req.getContextPath() + "/workplace?id=" + workplaceId + "&tab=tree");
  }

}
