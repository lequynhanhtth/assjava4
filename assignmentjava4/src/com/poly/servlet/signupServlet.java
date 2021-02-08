package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.common.PageInfo;
import com.poly.common.PageType;
import com.poly.dao.UserDAO;
import com.poly.entity.User;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public signupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageInfo.prepareAndForward(request, response, PageType.SIGN_UP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doCheck(request, response);

	}

	protected void doCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		User entity = new User();
		UserDAO dao = new UserDAO();
		try {
			entity = dao.findById(id);
			if (entity == null) {
				String confirmpass = request.getParameter("cornfirmpassword");
				String password = request.getParameter("password");
				if (confirmpass.equals(password)) {
					try {
				
						entity= new User();
						BeanUtils.populate(entity, request.getParameterMap());
						entity.setAdmin(false);
						dao.create(entity);
						PageInfo.prepareAndForward(request, response, PageType.LOGIN);
					} catch (Exception ex) {
						ex.printStackTrace();
						throw new RuntimeException();
					}
				} else {
					request.setAttribute("message", "Mật khẩu xác nhận không đúng");
					PageInfo.prepareAndForward(request, response, PageType.SIGN_UP);
				}
			} else {
				request.setAttribute("message", "Tài khoản đã có người sử dụng");
				PageInfo.prepareAndForward(request, response, PageType.SIGN_UP);
			}
		} catch (Exception e) {

		}
	}
}
