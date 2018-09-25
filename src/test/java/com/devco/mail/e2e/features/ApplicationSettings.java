package com.devco.mail.e2e.features;

import java.util.ResourceBundle;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationSettings {

	private static ResourceBundle rb = ResourceBundle.getBundle("application");

	private String emailSender;
	private String passwordSender;
	private String emailReceiver;
	private String passwordReceiver;
	private String subject;
	private String body;

	public ApplicationSettings() {
		this.emailSender = rb.getString("emailSender");
		this.passwordSender = rb.getString("passwordSender");
		this.emailReceiver = rb.getString("emailReceiver");
		this.passwordReceiver = rb.getString("passwordReceiver");
		this.subject = rb.getString("subject");
		this.body = rb.getString("body");
	}

	public String getEmailSender() {
		return emailSender;
	}

	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}

	public String getPasswordSender() {
		return passwordSender;
	}

	public void setPasswordSender(String passwordSender) {
		this.passwordSender = passwordSender;
	}

	public String getEmailReceiver() {
		return emailReceiver;
	}

	public void setEmailReceiver(String emailReceiver) {
		this.emailReceiver = emailReceiver;
	}

	public String getPasswordReceiver() {
		return passwordReceiver;
	}

	public void setPasswordReceiver(String passwordReceiver) {
		this.passwordReceiver = passwordReceiver;
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
