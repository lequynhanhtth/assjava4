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
import com.poly.dao.UserDAO;
import com.poly.entity.User;

/**
 * Servlet implementation class openUserServlet
 */
@WebServlet("/openUserServlet")
public class openUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		User entity = new User();
		List<User> list = dao.findAll();
		req.setAttribute("listusers", list);
		req.setAttribute("active", "active");
		PageInfo.prepareAndForward(req, resp, PageType.USER_LIST_PAGE);
	}

}
