package com.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.common.PageInfo;
import com.poly.common.PageType;
import com.poly.dao.VideoDAO;
import com.poly.entity.Report;

/**
 * Servlet implementation class openFavorite
 */
@WebServlet("/openFavorite")
public class openFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		List<Report> list = dao.selectVideoFavorite();
		List<String> titles = dao.selectTitle();
		req.setAttribute("titles", titles);
		req.setAttribute("favorites", list);
		req.setAttribute("report1", "active");
		PageInfo.prepareAndForward(req, resp, PageType.REPORT_PAGE);
	}

}
