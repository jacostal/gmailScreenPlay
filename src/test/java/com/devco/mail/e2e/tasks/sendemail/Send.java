package com.devco.mail.e2e.tasks.sendemail;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.TAB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.devco.mail.e2e.model.Email;
import com.devco.mail.e2e.ui.GmailPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Send implements Task {

	private Email email;

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				sendEmailTasks()
		);
	}


	private Performable[] sendEmailTasks() {
		List<Performable> sendEmailTasks = new ArrayList<>();
		sendEmailTasks.addAll(enterReceibers());
		sendEmailTasks.add(enterSubject());
		sendEmailTasks.add(enterBodyAndSend());
		return sendEmailTasks.toArray(new Performable[sendEmailTasks.size()]);
	}



	private Collection<? extends Performable> enterReceibers() {
		List<Performable> actionsList = new ArrayList<>(email.getReceiverList().size());
		for (int i = 0; i < email.getReceiverList().size(); i++) {
			actionsList.add(Enter.theValue(email.getReceiverList().get(i))
			   		  .into(GmailPage.RECEIBER_FIELD)
			   		  .thenHit(ENTER));
		}
		return actionsList;
	}
	
	private Performable enterSubject() {
		return Enter.theValue(email.getSubject())
		   		  .into(GmailPage.SUBJECT_FIELD);
	}
	
	private Performable enterBodyAndSend() {
		return Enter.theValue(email.getBody())
		   		  .into(GmailPage.BODY_FIELD)
		   		  .thenHit(TAB)
		   		  .thenHit(ENTER)
		   		  ;
	}

	protected Send(Email email) {
		this.email = email;
	}

	public static Send thisEmail(Email email) {
		return instrumented(Send.class, email);
	}

}
