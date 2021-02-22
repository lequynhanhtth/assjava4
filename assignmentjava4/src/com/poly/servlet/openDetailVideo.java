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
 * Servlet implementation class openDetailVideo
 */
@WebServlet("/openDetailVideo")
public class openDetailVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		VideoDAO dao = new VideoDAO();
		Video entity = dao.findById(id);
		req.setAttribute("videodetail", entity);
		List<Video> list = dao.selectCountVideo(6, 1);
		req.setAttribute("videos", list);
		PageInfo.prepareAndForward(req, resp, PageType.VIDEO_DETAIL_PAGE);
	}
}
