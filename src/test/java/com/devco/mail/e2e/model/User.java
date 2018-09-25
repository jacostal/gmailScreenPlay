package com.devco.mail.e2e.model;

import net.serenitybdd.screenplay.Actor;

public class User extends Actor {

	public User(String name) {
		super(name);
	}

	public static User named(String name) {
		return new User(name);
	}

	private String userMail;
	private String password;

	public String getUserMail() {
		return userMail;
	}

	public User withUserMail(String userMail) {
		this.userMail = userMail;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User withPassword(String password) {
		this.password = password;
		return this;
	}

}
