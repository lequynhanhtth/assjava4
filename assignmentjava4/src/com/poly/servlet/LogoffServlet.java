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
import com.poly.common.SessionUtils;

/**
 * Servlet implementation class LogoffServlet
 */
@WebServlet("/LogoffServlet")
public class LogoffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CookieUtils.add("username", null, 0, resp);
		SessionUtils.invalidate(req);
		PageInfo.prepareAndForward(req, resp, PageType.INDEX);
	}

}
