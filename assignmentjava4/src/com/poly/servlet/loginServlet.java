package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.UserDAO;
import com.poly.entity.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("actions");
		UserDAO dao = new UserDAO();
		User entity = new User();
		if (action == null || action.equals("")) {
			req.getRequestDispatcher("views/login.jsp").forward(req, resp);
		} else if (action.equals("check")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			try {
				entity = dao.findById(username);
				if (!entity.getPassword().equals(password)) {
					req.setAttribute("message", "Sai mật khẩu");	
					req.getRequestDispatcher("views/login.jsp").forward(req, resp);
				} else {
					req.setAttribute("message", "Đăng nhập thành công");
					req.getSession().setAttribute("user", entity);
					req.getRequestDispatcher("views/login.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				req.setAttribute("message", "Sai tên đăng nhập");
				req.getRequestDispatcher("views/login.jsp").forward(req, resp);
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
