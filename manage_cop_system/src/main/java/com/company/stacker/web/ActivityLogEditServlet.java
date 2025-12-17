package com.company.stacker.web;

import com.company.stacker.dao.ActivityLogDAO;
import com.company.stacker.model.ActivityLog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



/**
 * Servlet implementation class ActivityLogEditServlet
 */
@WebServlet("/log/edit")
public class ActivityLogEditServlet extends HttpServlet {
    private final ActivityLogDAO dao = new ActivityLogDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        ActivityLog log = dao.findById(id);
        req.setAttribute("log", log);
        req.getRequestDispatcher("/WEB-INF/views/log_edit.jsp").forward(req, resp);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
