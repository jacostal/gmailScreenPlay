 package com.devco.mail.e2e.tasks.login;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.devco.mail.e2e.ui.GmailPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterUserEmail implements Task {

	private final String userMail;
	
	protected EnterUserEmail(String userMail) {
		this.userMail = userMail;
	}

	public static EnterUserEmail forLoggin(String userMail) {
		return instrumented(EnterUserEmail.class, userMail);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		 actor.attemptsTo(
	        		Enter.theValue(userMail)
	        			 .into(GmailPage.LOGIN_MAIL_FIELD)
	        			 .thenHit(ENTER)
			);
	}

}
