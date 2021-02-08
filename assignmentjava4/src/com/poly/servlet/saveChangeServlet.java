package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.common.SessionUtils;
import com.poly.dao.UserDAO;
import com.poly.entity.User;

/**
 * Servlet implementation class saveChangeServlet
 */
@WebServlet("/saveChangeServlet")
public class saveChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User entity = new User();
		UserDAO dao = new UserDAO();
		try {
			entity = dao.findById(SessionUtils.getLoginedUsername(req));
			dao.update(entity);
			req.setAttribute("message", "Thay đổi thành công");
			req.setAttribute("user", entity);
			
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}

}
