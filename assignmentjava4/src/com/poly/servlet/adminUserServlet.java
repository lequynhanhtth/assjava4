package com.poly.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.UserDAO;
import com.poly.entity.User;


/**
 * Servlet implementation class adminUserServlet
 */
@WebServlet("/adminUserServlet")
public class adminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getParameter("actions");
		List<User> list = new ArrayList<User>();
		User entity = new User();
		UserDAO dao = new UserDAO();
		list = dao.findAll();
		if (action == null || action.equals("")) {
			req.setAttribute("Users", list);
			req.getRequestDispatcher("views/list_user.jsp").forward(req, resp);
		}
		switch (action) {
		case "edit": {
			String keyWord = req.getParameter("id");
			if(keyWord == null) {
				req.setAttribute("User", entity);
				req.getRequestDispatcher("views/edit_user.jsp").forward(req, resp);
			}
				
			 entity = dao.findById(keyWord);
			req.setAttribute("User", entity);
			req.getRequestDispatcher("views/edit_user.jsp").forward(req, resp);
			break;
		}
		case "Update" :{
			 entity = new User();
			try {
				BeanUtils.populate(entity, req.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
			dao.update(entity);
			req.setAttribute("User", entity);
			req.getRequestDispatcher("views/edit_user.jsp").forward(req, resp);
			break;
		}
		case "Delete" :{
			String keyWord = req.getParameter("id");
			dao.delete(keyWord);
			req.setAttribute("message", "Xóa thành công");
			req.getRequestDispatcher("views/list_user.jsp").forward(req, resp);
			break;
		}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
