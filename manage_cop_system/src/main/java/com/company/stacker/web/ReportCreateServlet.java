package com.company.stacker.web;

import com.company.stacker.dao.ReportDAO;
import com.company.stacker.model.Report;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/report/create")
public class ReportCreateServlet extends HttpServlet {
	private final ReportDAO dao = new ReportDAO();
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Report r = new Report();
		
		r.setWorkplaceId(Long.parseLong(req.getParameter("workplaceId")));
		r.setTitle(req.getParameter("title"));
		r.setContent(req.getParameter("content"));
		r.setAuthor(req.getParameter("author"));
		r.setTagsCsv(req.getParameter("tagsCsv"));
		
		String reportDate = req.getParameter("reportDate");
		if (reportDate != null && !reportDate.isBlank()) r.setReportDate(Date.valueOf(reportDate));
		
		long newId = dao.insert(r);
		
		res.sendRedirect(req.getContextPath() + "/report?id=" + newId);
	}

}
