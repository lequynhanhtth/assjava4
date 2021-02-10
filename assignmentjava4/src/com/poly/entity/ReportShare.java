package com.poly.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class ReportShare {
	@Id
	String Id;
	String sender;
	String receiver;
	Date sentdate;

	public ReportShare(String id, String sender, String receiver, Date sentdate) {
		super();
		Id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.sentdate = sentdate;
	}

	public ReportShare() {
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Date getSentdate() {
		return sentdate;
	}

	public void setSentdate(Date sentdate) {
		this.sentdate = sentdate;
	}
}
