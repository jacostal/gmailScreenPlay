package com.devco.mail.e2e.tasks;

import com.devco.mail.e2e.ui.GmailPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheApplication implements Task {

	GmailPage gmailPage;

	@Step("Open gmail page and try to logging")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Open.browserOn().the(gmailPage)
		);

	}

}
