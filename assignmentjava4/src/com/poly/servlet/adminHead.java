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
import com.poly.dao.ShareDAO;
import com.poly.dao.UserDAO;
import com.poly.dao.VideoDAO;
import com.poly.entity.Report;
import com.poly.entity.User;
import com.poly.entity.Video;

/**
 * Servlet implementation class adminHead
 */
@WebServlet("/adminHead")
public class adminHead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("actions");

		switch (action) {
		case "user_list": {
			UserDAO dao = new UserDAO();
			User entity = new User();
			List<User> list = dao.findAll();
			req.setAttribute("listusers", list);
			req.setAttribute("active", "active");

			PageInfo.prepareAndForward(req, resp, PageType.USER_LIST_PAGE);
		}
		case "video_list": {
			VideoDAO dao = new VideoDAO();
			List<Video> list = dao.selectAll();
			req.setAttribute("listvideos", list);
			req.setAttribute("newcr", "new");
			req.setAttribute("active", "active");
			PageInfo.prepareAndForward(req, resp, PageType.VIDEO_LIST_PAGE);
		}
		case "report": {
			VideoDAO dao = new VideoDAO();
			List<Report> list =dao.selectVideoFavorite();		
			req.setAttribute("favorites", list);
			req.setAttribute("report1", "active");
			PageInfo.prepareAndForward(req, resp, PageType.REPORT_PAGE);
		}
		}
	}

}
