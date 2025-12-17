package com.company.stacker.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.stacker.dao.ActivityLogDAO;

/**
 * Servlet implementation class ActivityLogUpdateServlet
 */
@WebServlet("/log/update")
public class ActivityLogUpdateServlet extends HttpServlet {
    private final ActivityLogDAO dao = new ActivityLogDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        long id = Long.parseLong(req.getParameter("id"));
        long nodeId = Long.parseLong(req.getParameter("nodeId"));

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        dao.update(id, title, content);
        resp.sendRedirect(req.getContextPath() + "/node/history?nodeId=" + nodeId);
    }
}

