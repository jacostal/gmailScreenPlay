 package com.devco.mail.e2e.tasks.login;

import com.devco.mail.e2e.ui.GmailPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class Signout implements Task {


	@Override
	@Step("Sign out of gmail")
	public <T extends Actor> void performAs(T actor) {
		 actor.attemptsTo(
				 Click.on(GmailPage.ACCOUNT_BUTTON),
				 Click.on(GmailPage.SIGN_OUT)
			);
	}

}
