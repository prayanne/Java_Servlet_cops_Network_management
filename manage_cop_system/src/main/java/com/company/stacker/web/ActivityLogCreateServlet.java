package com.company.stacker.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.stacker.dao.ActivityLogDAO;
import com.company.stacker.model.ActivityLog;

/**
 * Servlet implementation class ActivityLogCreateServlet
 */
@WebServlet("/log/create")
public class ActivityLogCreateServlet extends HttpServlet {
    private final ActivityLogDAO dao = new ActivityLogDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        ActivityLog a = new ActivityLog();
        a.setNodeId(Long.parseLong(req.getParameter("nodeId")));
        a.setTitle(req.getParameter("title"));
        a.setContent(req.getParameter("content"));

        dao.insert(a);
        resp.sendRedirect(req.getContextPath() + "/node/history?nodeId=" + a.getNodeId());
    }
}
