package com.poly.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class Report {
	@Id
	String groupId;
	Long likes;
	Date newest;
	Date oldest;

	public Report(String groupId, Long likes, Date newest, Date oldest) {
		super();
		this.groupId = groupId;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}

	public Report() {
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLike(Long likes) {
		this.likes = likes;
	}

	public Date getNewest() {
		return newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}

	public Date getOldest() {
		return oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}

}
