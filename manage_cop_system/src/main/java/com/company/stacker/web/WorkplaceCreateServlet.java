package com.company.stacker.web;

import com.company.stacker.model.Workplace;
import com.company.stacker.dao.WorkplaceDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



/**
 * Servlet implementation class WorkplaceCreateServlet
 */
@WebServlet("/workplace/create")
public class WorkplaceCreateServlet extends HttpServlet {
  private final WorkplaceDAO dao = new WorkplaceDAO();

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");

    Workplace w = new Workplace();
    w.setName(req.getParameter("name"));
    w.setIconKey(req.getParameter("iconKey"));
    w.setLocation(req.getParameter("location"));
    w.setSummary(req.getParameter("summary"));

    long newId = dao.insert(w);
    resp.sendRedirect(req.getContextPath() + "/workplace?id=" + newId + "&tab=tree");
  }
}

