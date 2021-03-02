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


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		User entity = new User();
		UserDAO dao = new UserDAO();
		try {
			entity = dao.findById(id);
			if (entity == null) {
				String confirmpass = req.getParameter("confirmpassword");
				String password = req.getParameter("password");
				if (confirmpass.equals(password)) {
					try {

						entity = new User();
						BeanUtils.populate(entity, req.getParameterMap());
						entity.setAdmin(false);
						dao.create(entity);
						PageInfo.prepareAndForward(req, resp, PageType.LOGIN);
					} catch (Exception ex) {
						ex.printStackTrace();
						throw new RuntimeException();
					}
				} else {
					req.setAttribute("message", "Mật khẩu xác nhận không đúng");
					PageInfo.prepareAndForward(req, resp, PageType.SIGN_UP);
				}
			} else {
				req.setAttribute("message", "Tài khoản đã có người sử dụng");
				PageInfo.prepareAndForward(req, resp, PageType.SIGN_UP);
			}
		} catch (Exception e) {
e.printStackTrace();
		}
	}

}
