package com.poly.test;

import com.poly.dao.UserDAO;
import com.poly.entity.User;

public class test {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		User entity = new User();
		entity.setAdmin(true);
		entity.setEmail("nha123n@gmail.com");
		entity.setFullname("nhan");
		entity.setPassword("123");
		entity.setId("lequynhan2");
		dao.create(entity);
	}
}
