package com.devco.mail.e2e.model;

import java.util.Arrays;

public class EmailBuilder {

	private final Email email;

	public EmailBuilder(String... receivers) {
		email = new Email();
		email.setReceiverList(Arrays.asList(receivers));
	}

	public static EmailBuilder withReceiverss(String... receivers) {
		return new EmailBuilder(receivers);
	}

	public EmailBuilder andSubject(String subject) {
		email.setSubject(subject);
		return this;
	}
	
	public EmailBuilder andBody(String body) {
		email.setBody(body);
		return this;
	}
	
	public Email toEmail() {
		return email;
	}
}
