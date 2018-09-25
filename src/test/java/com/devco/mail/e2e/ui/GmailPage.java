package com.devco.mail.e2e.ui;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.gmail.com")
public class GmailPage extends PageObject {

	public static Target LOGIN_MAIL_FIELD = Target.the("login field").located(By.id("identifierId"));

	public static Target LOGIN_PASSWORD_FIELD = Target.the("login field").located(By.name("password"));
	
	public static Target RECEIBER_FIELD = Target.the("login field").located(By.name("to"));
	
	public static Target COMPOSE_BUTTON = Target.the("compose button").located(By.cssSelector(".z0 div"));
	
	public static Target SUBJECT_FIELD = Target.the("subject field").located(By.name("subjectbox"));
	
	public static Target BODY_FIELD = Target.the("body field").located(By.cssSelector("div[role=\"textbox\"]"));
	
	public static Target SEND_BUTTON = Target.the("send button").located(By.cssSelector(".J-J5-Ji div"));
	
	public static Target MESSAGE_DIV = Target.the("message div").located(By.className("vh"));
	
	public static Target ACCOUNT_BUTTON = Target.the("account button").located(By.className("gb_9a"));
	
	public static Target SIGN_OUT = Target.the("sign out button").located(By.id("gb_71"));
	
	public static Target CHANGE_ACCOUNT = Target.the("change account button").located(By.id("profileIdentifier"));
	
	public static Target NEW_ACCOUNT = Target.the("another account button").located(By.id("identifierLink"));
	
	public static Target SEARCH_FIELD = Target.the("search field").located(By.className("gb_bf"));
	
	public static Target ELEMENT_FILTERED = Target.the("search element").located(By.cssSelector(".ae4.UI .y6"));
	
	public static Question<String> searchElement() {
		return TheTarget.textOf(ELEMENT_FILTERED);
	}
			
}