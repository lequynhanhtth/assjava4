package com.poly.test;

import java.util.List;

import com.poly.dao.FavoriteDAO;
import com.poly.dao.ShareDAO;
import com.poly.dao.UserDAO;
import com.poly.dao.VideoDAO;
import com.poly.entity.Favorite;
import com.poly.entity.Report;
import com.poly.entity.ReportShare;
import com.poly.entity.ReportUser;
import com.poly.entity.User;

public class test {
	public static void main(String[] args) {
		FavoriteDAO dao = new FavoriteDAO();
		VideoDAO daoV = new VideoDAO();
		UserDAO daoU = new UserDAO();
		
		Integer i = 2 ;
		List<Favorite> list = dao.selectAll();
		System.out.println();
	}
}
