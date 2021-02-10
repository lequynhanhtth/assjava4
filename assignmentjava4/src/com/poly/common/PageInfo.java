package com.poly.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.UserDAO;
import com.poly.entity.User;

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
		pageRoute.put(PageType.INDEX,
				new PageInfo("index/head_index.jsp", "Trang chủ", "index/indexpage.jsp", null, true));
		pageRoute.put(PageType.SIGN_UP,
				new PageInfo(null, "Đăng ký", "sign_up/sign_up_page.jsp", "login/login_script.jsp", false));
		pageRoute.put(PageType.EDIT_PROFILE, new PageInfo("index_login/head_page.jsp", "Chỉnh sửa tài khoản",
				"edit_user/edit_profile.jsp", "index_login/script_page.jsp", true));
		pageRoute.put(PageType.CHANGE_PASSWORD, new PageInfo("index_login/head_page.jsp", "Đổi mật khẩu",
				"edit_user/changePassword.jsp", "index_login/script_page.jsp", true));
		pageRoute.put(PageType.USER_LIST_PAGE, new PageInfo("admin/head_login.jsp", "Quản lý người dùng",
				"admin/user_page.jsp", "login/login_script.jsp", true));
		pageRoute.put(PageType.VIDEO_LIST_PAGE, new PageInfo("admin/head_login", "Quản lý Video",
				"admin/video_page.jsp", "login/login_script.jsp", true));
		pageRoute.put(PageType.REPORT_PAGE, new PageInfo("admin/head_login.jsp", "Thống kê", "admin/report_page.jsp",
				"login/login_script.jsp", true));
	}

	public static void prepareAndForward(HttpServletRequest request, HttpServletResponse respone, PageType pageType)
			throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		UserDAO dao = new UserDAO();
		if (page.getCss()) {
			User username = (User) SessionUtils.get(request, "username");
			if (username != null) {
				if (!username.getAdmin()) {
					page.setHead("index_login/head_page.jsp");
					page.setScriptUrl("index_login/script_page.jsp");
				} else {
					page.setHead("admin/head_page.jsp");
					page.setScriptUrl("index_login/script_page.jsp");
				}
			} else {
				page.setHead("index/head_index.jsp");
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
