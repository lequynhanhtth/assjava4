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
 * Servlet implementation class changePasswordServlet
 */
@WebServlet("/changePasswordServlet")
public class changePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		UserDAO dao = new UserDAO();
		User entity = (User)SessionUtils.get(request, "username");
		
		if (password.equals(entity.getPassword())) {
			entity.setPassword(newpassword);
			dao.update(entity);
			request.setAttribute("message", "Thay đổi mật khẩu thành công !!!");
			PageInfo.prepareAndForward(request, response, PageType.CHANGE_PASSWORD);
		} else {
			request.setAttribute("message", "Mật khẩu cũ không đúng");
			PageInfo.prepareAndForward(request, response, PageType.CHANGE_PASSWORD);
		}
	}

}
