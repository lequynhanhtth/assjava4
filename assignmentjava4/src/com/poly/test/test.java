package com.poly.test;

import java.util.List;

import com.poly.dao.ShareDAO;
import com.poly.dao.UserDAO;
import com.poly.dao.VideoDAO;
import com.poly.entity.Report;
import com.poly.entity.ReportShare;
import com.poly.entity.ReportUser;
import com.poly.entity.User;

public class test {
	public static void main(String[] args) {
		VideoDAO dao = new VideoDAO();
		List<String> list = dao.selectTitle();
		for(String x : list) {
			System.out.println(x);
		}
	}
}
