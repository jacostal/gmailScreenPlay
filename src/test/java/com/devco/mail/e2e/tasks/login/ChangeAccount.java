 package com.devco.mail.e2e.tasks.login;

import com.devco.mail.e2e.ui.GmailPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ChangeAccount implements Task {


	@Override
	@Step("change account")
	public <T extends Actor> void performAs(T actor) {
		 actor.attemptsTo(
				 Click.on(GmailPage.CHANGE_ACCOUNT),
				 Click.on(GmailPage.NEW_ACCOUNT)
			);
	}

}
