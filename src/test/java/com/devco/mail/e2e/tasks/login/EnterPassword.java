 package com.devco.mail.e2e.tasks.login;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.devco.mail.e2e.ui.GmailPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterPassword implements Task {

	private final String password;
	
	protected EnterPassword(String password) {
		this.password = password;
	}

	public static EnterPassword forLoggin(String password) {
		return instrumented(EnterPassword.class, password);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		 actor.attemptsTo(
	        		Enter.theValue(password)
	        			 .into(GmailPage.LOGIN_PASSWORD_FIELD)
	        			 .thenHit(ENTER)
			);
	}

}
