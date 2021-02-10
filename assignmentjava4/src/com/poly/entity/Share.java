package com.poly.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Shares" , uniqueConstraints = {
		@UniqueConstraint(columnNames = {"VideoId","UserId"})
})
public class Share {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Integer id;
@ManyToOne @JoinColumn(name = "UserId")
User user;
@ManyToOne @JoinColumn(name = "VideoId")
Video video;
String email;
@Temporal(TemporalType.DATE)
Date sharedate = new Date();

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Video getVideo() {
	return video;
}
public void setVideo(Video video) {
	this.video = video;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getSharedate() {
	return sharedate;
}
public void setSharedate(Date sharedate) {
	this.sharedate = sharedate;
}
}
