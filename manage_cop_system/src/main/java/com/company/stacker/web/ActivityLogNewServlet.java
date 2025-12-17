package com.company.stacker.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActivityLogNewServlet
 */
@WebServlet("/log/new")
public class ActivityLogNewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long nodeId = Long.parseLong(req.getParameter("nodeId"));
        req.setAttribute("nodeId", nodeId);
        req.getRequestDispatcher("/WEB-INF/views/log_form.jsp").forward(req, resp);
    }
}

