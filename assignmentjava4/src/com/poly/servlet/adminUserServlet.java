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

import com.poly.common.PageInfo;
import com.poly.common.PageType;
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
		switch (action) {
		case "edit": {	
			String keyWord = req.getParameter("id");
			entity = dao.findById(keyWord);
			req.setAttribute("userdetail", entity);
			PageInfo.prepareAndForward(req, resp, PageType.USER_LIST_PAGE);
			break;
		}
		case "Save Profile": {
			String keyWord = req.getParameter("id");
			entity =  dao.findById(keyWord);
			try {
				BeanUtils.populate(entity, req.getParameterMap());
			}catch(Exception e) {
				throw new RuntimeException();
			}
			dao.update(entity);			
			req.setAttribute("userdetail", entity);
			req.setAttribute("message", "Thay đổi thành công");
			list = dao.findAll();
			req.setAttribute("listusers", list);
			PageInfo.prepareAndForward(req, resp, PageType.USER_LIST_PAGE);
			break;
		}
		case "Delete": {
			String keyWord = req.getParameter("id");
			dao.delete(keyWord);
			req.setAttribute("message", "Xóa thành công");
			list = dao.findAll();
			req.setAttribute("listusers", list);
			PageInfo.prepareAndForward(req, resp, PageType.USER_LIST_PAGE);
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
