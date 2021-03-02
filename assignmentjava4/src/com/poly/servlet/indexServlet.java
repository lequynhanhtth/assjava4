package com.poly.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.common.CookieUtils;
import com.poly.common.PageInfo;
import com.poly.common.PageType;
import com.poly.dao.VideoDAO;
import com.poly.entity.Video;

/**
 * Nhẫn
 */
@MultipartConfig
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
		String action = req.getParameter("actions");
		if (action == null || action.equals("")) {
			VideoDAO dao = new VideoDAO();
			List<Video> list = dao.selectCountVideo(12, 1);
			List<Video> listall = dao.selectAll();
			int count = listall.size();
			int str = count % 12 == 0 ? count / 12 : count / 12 + 1;
			List<Integer> countPage = new ArrayList<Integer>();
			for (int i = 1; i <= str; i++) {
				countPage.add(i);
			}
			req.setAttribute("countSelect", 1);
			req.setAttribute("countPage", countPage);
			List<Video> list1 = dao.selectInRow(1, list);
			List<Video> list2 = dao.selectInRow(2, list);
			List<Video> list3 = dao.selectInRow(3, list);
			req.setAttribute("listvideo1", list1);
			req.setAttribute("listvideo2", list2);
			req.setAttribute("listvideo3", list3);
			PageInfo.prepareAndForward(req, resp, PageType.INDEX);
		} else if (action.equals("Login")) {
			String username = CookieUtils.get("username", req);
			req.setAttribute("username", username);
			PageInfo.prepareAndForward(req, resp, PageType.LOGIN);
		} else if (action.equals("Sign up")) {
			PageInfo.prepareAndForward(req, resp, PageType.SIGN_UP);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, response);
	}

}
