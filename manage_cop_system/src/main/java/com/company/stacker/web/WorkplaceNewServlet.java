package com.company.stacker.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class WorkplaceNewServlet
 */
@WebServlet("/workplace/new")
public class WorkplaceNewServlet extends HttpServlet {
  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/views/workplace_form.jsp").forward(req, resp);
  }
}

