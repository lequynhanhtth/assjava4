package com.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.common.CookieUtils;
import com.poly.common.PageInfo;
import com.poly.common.PageType;
import com.poly.common.SessionUtils;
import com.poly.dao.UserDAO;
import com.poly.dao.VideoDAO;
import com.poly.domain.LoginForm;
import com.poly.entity.User;
import com.poly.entity.Video;

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

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String action = req.getParameter("actions");
//		UserDAO dao = new UserDAO();
//		User entity = new User();
//		if (action == null || action.equals("")) {
//			req.getRequestDispatcher("views/login.jsp").forward(req, resp);
//		} else if (action.equals("check")) {
//			String username = req.getParameter("username");
//			String password = req.getParameter("password");
//			try {
//				entity = dao.findById(username);
//				if (!entity.getPassword().equals(password)) {
//					req.setAttribute("message", "Sai mật khẩu");	
//					req.getRequestDispatcher("views/login.jsp").forward(req, resp);
//				} else {
//					req.setAttribute("message", "Đăng nhập thành công");
//					req.getSession().setAttribute("user", entity);
//					req.getRequestDispatcher("views/login.jsp").forward(req, resp);
//				}
//			} catch (Exception e) {
//				req.setAttribute("message", "Sai tên đăng nhập");
//				req.getRequestDispatcher("views/login.jsp").forward(req, resp);
//			}
//		}
//	}

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
		try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, request.getParameterMap());
			UserDAO dao = new UserDAO();
			User user = dao.findById(form.getUsername());
			if (user != null & user.getPassword().equals(form.getPassword())) {
				SessionUtils.add(request, "username", user);
				if (form.isRemember()) {
					CookieUtils.add("username", form.getUsername(), 24, response);
				} else {
					CookieUtils.add("username", form.getUsername(), 0, response);
				}
				SessionUtils.add(request, "name", user.getFullname());
				if (user.getAdmin()) {
					PageInfo.prepareAndForward(request, response, PageType.INDEX_ADMIN);
				} else {
					SessionUtils.add(request, "name", user.getFullname());
					VideoDAO Vdao = new VideoDAO();
					List<Video> list = Vdao.selectCountVideo(12, 1);
					List<Video> list1 = Vdao.selectInRow(1, list);
					List<Video> list2 = Vdao.selectInRow(2, list);
					List<Video> list3 = Vdao.selectInRow(3, list);
					request.setAttribute("listvideo1", list1);
					request.setAttribute("listvideo2", list2);
					request.setAttribute("listvideo3", list3);
					PageInfo.prepareAndForward(request, response, PageType.INDEX_USER);
				}
			} else {
				request.setAttribute("message", "Sai tên đăng nhập hoặc mật khẩu !!!");
				PageInfo.prepareAndForward(request, response, PageType.LOGIN);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
