package com.poly.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
public class ReportUser {
	@Id
	String Id;
	String fullname;
	String email;
	Date favoritedate;

	public ReportUser(String id, String fullname, String email, Date favoritedate) {
		super();
		Id = id;
		this.fullname = fullname;
		this.email = email;
		this.favoritedate = favoritedate;
	}

	public ReportUser() {

	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFavoritedate() {
		return favoritedate;
	}

	public void setFavoritedate(Date favoritedate) {
		this.favoritedate = favoritedate;
	}

}
