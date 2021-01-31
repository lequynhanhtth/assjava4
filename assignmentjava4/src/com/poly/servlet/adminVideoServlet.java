package com.poly.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.VideoDAO;
import com.poly.entity.Video;


/**
 * Servlet implementation class adminVideoServlet
 */
@WebServlet("/adminVideoServlet")
public class adminVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminVideoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("actions");
		List<Video> list = new ArrayList<Video>();
		Video entity = new Video();
		VideoDAO dao = new VideoDAO();
		if (action == null || action.equals("")) {
			list = dao.selectAll();
			req.setAttribute("videos", list);
			req.getRequestDispatcher("views/list_video.jsp").forward(req, res);
		}
		switch (action) {
		case "edit": {
			String keyWord = req.getParameter("id");
			if (keyWord == null) {
				req.setAttribute("video", entity);
				req.getRequestDispatcher("views/edit_video.jsp").forward(req, res);
			}
			entity = dao.findById(keyWord);
			req.setAttribute("video", entity);
			req.getRequestDispatcher("views/edit_video.jsp").forward(req, res);
			break;
		}
		case "Update": {
			try {
				BeanUtils.populate(entity, req.getParameterMap());
			} catch (Exception e) {
				throw new RuntimeException();
			}
			dao.update(entity);
			req.setAttribute("video", entity);
			req.getRequestDispatcher("views/edit_video.jsp").forward(req, res);
			break;
		}
		case "Delete": {
			String keyWord = req.getParameter("id");
			dao.delete(keyWord);
			entity = new Video();
			req.setAttribute("video", entity);
			req.getRequestDispatcher("views/edit_video.jsp").forward(req, res);
			break;

		}
		case "Create" : {
			try {
				BeanUtils.populate(entity, req.getParameterMap());
			}catch(Exception e) {
				throw new RuntimeException();
			}
			dao.create(entity);
			entity = new Video();
			req.setAttribute("video", entity);
			req.getRequestDispatcher("views/edit_video.jsp").forward(req, res);
			break;
		}
		}
	}

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
