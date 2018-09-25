package com.devco.mail.e2e.model;

import java.util.List;

public class Email {

	private List<String> receiverList;
	private String subject;
	private String body;

	public List<String> getReceiverList() {
		return receiverList;
	}

	public void setReceiverList(List<String> receiverList) {
		this.receiverList = receiverList;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
