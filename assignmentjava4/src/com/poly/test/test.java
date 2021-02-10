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
		ShareDAO dao = new ShareDAO();
		List<ReportShare> list = dao.selectReportShare("Sĩ siêu to khổng");
		for(ReportShare x : list) {
			System.out.println(x.getId());
		}
	}
}
