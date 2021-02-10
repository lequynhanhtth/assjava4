package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.common.CookieUtils;
import com.poly.common.PageInfo;
import com.poly.common.PageType;

/**
 * Nhẫn 
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public indexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String action  = req.getParameter("actions");
			if(action == null || action.equals("")) {
				PageInfo.prepareAndForward(req, resp, PageType.INDEX);
			}else if (action.equals("Login")) {
				String username = CookieUtils.get("username", req);
				req.setAttribute("username", username);
				PageInfo.prepareAndForward(req, resp, PageType.LOGIN);
			}else if (action.equals("Sign up")) {
				PageInfo.prepareAndForward(req, resp, PageType.SIGN_UP);
			}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
