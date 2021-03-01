package com.poly.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class videoLike {
	@Id
	Integer Id;
	Long like;
	String title;
	String poster;
	Integer views;
	String description;

	public videoLike(Integer id, Long like, String title, String poster, Integer views, String description) {
		super();
		Id = id;
		this.like = like;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.description = description;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Long getLike() {
		return like;
	}

	public void setLike(Long like) {
		this.like = like;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
