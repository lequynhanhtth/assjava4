package com.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.common.PageInfo;
import com.poly.common.PageType;
import com.poly.common.SessionUtils;
import com.poly.dao.FavoriteDAO;
import com.poly.dao.VideoDAO;
import com.poly.entity.Favorite;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.entity.videoLike;

/**
 * Servlet implementation class opendetail
 */
@WebServlet("/opendetail")
public class opendetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		VideoDAO dao = new VideoDAO();
		FavoriteDAO Fdao = new FavoriteDAO();
		try {
			videoLike entity = Fdao.selectLikeByID(id);
			req.setAttribute("videodetail", entity);
		} catch (NoResultException e) {
			Video entity1 = dao.findById(id);
			req.setAttribute("videodetail", entity1);
			req.setAttribute("like", 0);
		}
		List<Video> list = dao.selectCountVideo(6, 1);
		req.setAttribute("videolist", list);
		PageInfo.prepareAndForward(req, resp, PageType.INDEX_DETAIL);
	}

}
