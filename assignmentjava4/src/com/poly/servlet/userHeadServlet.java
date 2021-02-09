package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.common.PageInfo;
import com.poly.common.PageType;
import com.poly.common.SessionUtils;
import com.poly.dao.UserDAO;
import com.poly.entity.User;

/**
 * Servlet implementation class userHeadServlet
 */
@WebServlet("/userHeadServlet")
public class userHeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("actions");
		switch (action) {
		case "edit_profile": {
			UserDAO dao = new UserDAO();
			User entity = (User)SessionUtils.get(req, "username");
			req.setAttribute("user", entity);
			PageInfo.prepareAndForward(req, resp, PageType.EDIT_PROFILE);
			break;
		}
		case "change_password": {
			PageInfo.prepareAndForward(req, resp, PageType.CHANGE_PASSWORD);
			break;
		}
		}
	}
}
