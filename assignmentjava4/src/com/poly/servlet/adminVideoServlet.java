package com.poly.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.common.PageInfo;
import com.poly.common.PageType;
import com.poly.dao.VideoDAO;
import com.poly.entity.Video;

/**
 * Servlet implementation class adminVideoServlet
 */
@MultipartConfig
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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getParameter("actions");
		List<Video> list = new ArrayList<Video>();
		Video entity = new Video();
		VideoDAO dao = new VideoDAO();
		File dir = new File(req.getServletContext().getRealPath("/files"));
		if (!dir.exists()) {
			dir.mkdirs();
		}

		switch (action) {
		case "edit": {
			int keyWord = Integer.parseInt(req.getParameter("id"));
			entity = dao.findById(keyWord);
			req.setAttribute("videodetail", entity);
			list = dao.selectAll();
			req.setAttribute("listvideos", list);

			PageInfo.prepareAndForward(req, resp, PageType.VIDEO_LIST_PAGE);
			break;
		}
		case "Update": {
			int keyWord = Integer.parseInt(req.getParameter("id"));
			entity = dao.findById(keyWord);
			Part photo = req.getPart("photo_file");
			File photoFile = new File(dir, photo.getSubmittedFileName());
			photo.write(photoFile.getAbsolutePath());
			entity.setPoster(photoFile.getName());
			try {
				BeanUtils.populate(entity, req.getParameterMap());
			} catch (Exception e) {
				throw new RuntimeException();
			}
			dao.update(entity);
			req.setAttribute("videodetail", entity);
			list = dao.selectAll();
			req.setAttribute("listvideos", list);
			req.setAttribute("message", "Cập nhật thành công");

			PageInfo.prepareAndForward(req, resp, PageType.VIDEO_LIST_PAGE);
			break;
		}
		case "Delete": {
			int keyWord = Integer.parseInt(req.getParameter("id"));
			dao.delete(keyWord);
			entity = new Video();

			req.setAttribute("videodetail", entity);
			list = dao.selectAll();
			req.setAttribute("listvideos", list);
			req.setAttribute("message", "Xóa thành công");

			PageInfo.prepareAndForward(req, resp, PageType.VIDEO_LIST_PAGE);
			break;
		}
		case "Create": {
			try {
				BeanUtils.populate(entity, req.getParameterMap());
			} catch (Exception e) {
				throw new RuntimeException();
			}
			Part photo = req.getPart("photo_file");
			File photoFile = new File(dir, photo.getSubmittedFileName());
			photo.write(photoFile.getAbsolutePath());
			entity.setPoster(photoFile.getName());	
			entity.setId(null);
			dao.create(entity);

			req.setAttribute("videodetail", entity);
			list = dao.selectAll();
			req.setAttribute("listvideos", list);
			req.setAttribute("message", "Tạo video thành công");
			PageInfo.prepareAndForward(req, resp, PageType.VIDEO_LIST_PAGE);
			break;
		}
		case "New": {
			entity = new Video();

			list = dao.selectAll();
			req.setAttribute("listvideos", list);
			req.setAttribute("videodetail", entity);
			PageInfo.prepareAndForward(req, resp, PageType.VIDEO_LIST_PAGE);
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
