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
 * Servlet implementation class openFavoriteVideoIndex
 */
@WebServlet("/openFavoriteVideoIndex")
public class openFavoriteVideoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		String id = req.getParameter("id");
		List<Video> list = dao.selectCountFavoritesVideo(12, 1, id);
		List<Video> list1 = dao.selectInRow(1, list);
		List<Video> list2 = dao.selectInRow(2, list);
		List<Video> list3 = dao.selectInRow(3, list);
		req.setAttribute("listvideo1", list1);
		req.setAttribute("listvideo2", list2);
		req.setAttribute("listvideo3", list3);
		PageInfo.prepareAndForward(req, resp, PageType.INDEX_USER);
	}

}
