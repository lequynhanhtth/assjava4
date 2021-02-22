package com.poly.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.common.PageInfo;
import com.poly.common.PageType;
import com.poly.common.SessionUtils;
import com.poly.dao.ShareDAO;
import com.poly.dao.VideoDAO;
import com.poly.entity.Report;
import com.poly.entity.ReportShare;
import com.poly.entity.ReportUser;

/**
 * Servlet implementation class reportVideoServlet
 */
@WebServlet("/reportVideoServlet")
public class reportVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String actions = req.getParameter("actions");
		VideoDAO videoDAO = new VideoDAO();
		ShareDAO shareDAO = new ShareDAO();
		List<ReportUser> reportusers = new ArrayList<ReportUser>();
		List<ReportShare> reportshare = new ArrayList<ReportShare>();
		List<Report> reports = videoDAO.selectVideoFavorite();
		req.setAttribute("titles", videoDAO.selectTitle());
		req.setAttribute("favorites", reports);
		String title2 = req.getParameter("cbshare");
		if (SessionUtils.get(req, "title") != null) {
			String title = (String) SessionUtils.get(req, "title");
			reportusers = videoDAO.selectUserFavorite(title);
			req.setAttribute("reportusersTitle", title);
			req.setAttribute("ReportUsers", reportusers);
		}
		reportshare = shareDAO.selectReportShare(title2);
		req.setAttribute("reportshares", reportshare);
		req.setAttribute("reportshareTitle", title2);
		SessionUtils.add(req, "title2", title2);
		req.setAttribute("report3", "active");
		PageInfo.prepareAndForward(req, resp, PageType.REPORT_PAGE);

	}
}
