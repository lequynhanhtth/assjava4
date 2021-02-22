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
import com.poly.entity.Video;

/**
 * Servlet implementation class openVideoServlet
 */
@WebServlet("/openVideoServlet")
public class openVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		List<Video> list = dao.selectAll();
		req.setAttribute("listvideos", list);
		req.setAttribute("newcr", "new");
		req.setAttribute("active", "active");
		PageInfo.prepareAndForward(req, resp, PageType.VIDEO_LIST_PAGE);
	}

}
