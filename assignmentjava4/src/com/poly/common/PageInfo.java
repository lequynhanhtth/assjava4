package com.poly.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.UserDAO;
import com.poly.dao.VideoDAO;
import com.poly.entity.User;
import com.poly.entity.Video;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashMap<PageType, PageInfo>();
	private String title;
	private String contenUrl;
	private String scriptUrl;
	private String head;
	private boolean css;
	static {
		pageRoute.put(PageType.LOGIN,
				new PageInfo(null, "Đăng nhập", "login/login_page.jsp", "login/login_script.jsp", false));
		pageRoute.put(PageType.INDEX, new PageInfo("index/head_index.jsp", "Trang chủ", "index/indexpage.jsp",
				"index_login/script_page.jsp", true));
		pageRoute.put(PageType.SIGN_UP,
				new PageInfo(null, "Đăng ký", "sign_up/sign_up_page.jsp", "login/login_script.jsp", false));
		pageRoute.put(PageType.EDIT_PROFILE, new PageInfo("index_login/head_page.jsp", "Chỉnh sửa tài khoản",
				"edit_user/edit_profile.jsp", "index_login/script_page.jsp", true));
		pageRoute.put(PageType.CHANGE_PASSWORD, new PageInfo("index_login/head_page.jsp", "Đổi mật khẩu",
				"edit_user/changePassword.jsp", "index_login/script_page.jsp", true));
		pageRoute.put(PageType.USER_LIST_PAGE, new PageInfo("admin/head_page.jsp", "Quản lý người dùng",
				"admin/user_page.jsp", "admin/script_page.jsp", true));
		pageRoute.put(PageType.VIDEO_LIST_PAGE, new PageInfo("admin/head_page.jsp", "Quản lý Video",
				"admin/video_page.jsp", "admin/script_page.jsp", true));
		pageRoute.put(PageType.REPORT_PAGE, new PageInfo("admin/head_page.jsp", "Thống kê", "admin/report_page.jsp",
				"admin/script_page.jsp", true));
		pageRoute.put(PageType.INDEX_ADMIN,
				new PageInfo("admin/head_page.jsp", "Trang chủ", "index/indexpage.jsp", "admin/script_page.jsp", true));
		pageRoute.put(PageType.INDEX_USER, new PageInfo("index_login/head_page.jsp", "Trang chủ",
				"index_login/body_page.jsp", "index_login/script_page.jsp", true));
		pageRoute.put(PageType.VIDEO_DETAIL_PAGE, new PageInfo("index_login/head_page.jsp", "Video",
				"index_login/detail_video.jsp", "index_login/script_page.jsp", true));
	}

	public static void prepareAndForward(HttpServletRequest request, HttpServletResponse respone, PageType pageType)
			throws ServletException, IOException  {
		PageInfo page = pageRoute.get(pageType);
		if (page.getTitle().equals("Trang chủ")) {
			System.out.println("ádas");
			if (SessionUtils.get(request,"username") != null) {
				User entity = (User)SessionUtils.get(request,"username");
				if(entity.getAdmin()) {
					page= pageRoute.get(PageType.INDEX_ADMIN);
				}else {
					VideoDAO Vdao = new VideoDAO();
					List<Video> list = Vdao.selectCountVideo(12, 1);
					List<Video> list1 = Vdao.selectInRow(1, list);
					List<Video> list2 = Vdao.selectInRow(2, list);
					List<Video> list3 = Vdao.selectInRow(3, list);
					request.setAttribute("listvideo1", list1);
					request.setAttribute("listvideo2", list2);
					request.setAttribute("listvideo3", list3);
					page= pageRoute.get(PageType.INDEX_USER);
				}
			}
		}
		request.setAttribute("page", page);
		request.getRequestDispatcher("/views/layout.jsp").forward(request, respone);
	}

	public PageInfo(String head, String title, String contenUrl, String scriptUrl, boolean css) {
		super();
		this.head = head;
		this.title = title;
		this.contenUrl = contenUrl;
		this.css = css;
		this.scriptUrl = scriptUrl;
	}

	public String getHead() {
		return head;
	}

	public boolean getCss() {
		return css;
	}

	public void setCss(boolean css) {
		this.css = css;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContenUrl() {
		return contenUrl;
	}

	public void setContenUrl(String contenUrl) {
		this.contenUrl = contenUrl;
	}

	public String getScriptUrl() {
		return scriptUrl;
	}

	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
}
