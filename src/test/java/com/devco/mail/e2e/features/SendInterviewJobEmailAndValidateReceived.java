package com.devco.mail.e2e.features;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.devco.mail.e2e.model.Email;
import com.devco.mail.e2e.model.EmailBuilder;
import com.devco.mail.e2e.model.User;
import com.devco.mail.e2e.tasks.OpenTheApplication;
import com.devco.mail.e2e.tasks.Search;
import com.devco.mail.e2e.tasks.login.ChangeAccount;
import com.devco.mail.e2e.tasks.login.EnterPassword;
import com.devco.mail.e2e.tasks.login.EnterUserEmail;
import com.devco.mail.e2e.tasks.login.Signout;
import com.devco.mail.e2e.tasks.sendemail.Send;
import com.devco.mail.e2e.ui.GmailPage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class SendInterviewJobEmailAndValidateReceived {
	ApplicationSettings settings = new ApplicationSettings();

    User receiver;
    User sender;
    

    @Managed(uniqueSession = true)
    public WebDriver hisBrowser;

    @Steps
    OpenTheApplication openTheApplication;
    @Steps
    Signout signoutOfApplication;
    @Steps
    ChangeAccount changeAccout;
    
    

    @Before
    public void usersCanBrowseTheWeb() {
    	sender = User.named("sender")
					 .withUserMail(settings.getEmailSender())
					 .withPassword(settings.getPasswordSender());
    	receiver = User.named("receiver")
    				   .withUserMail(settings.getEmailReceiver())
    				   .withPassword(settings.getPasswordReceiver());
    	
    	receiver.can(BrowseTheWeb.with(hisBrowser));
    	sender.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void shouldLoginAndSendEmailAndChangeAccountAndValidTheEmeailSendedHasBeenReceived() {
    	Email interviewJobEmail = EmailBuilder
    				.withReceiverss("jhoel9211@gmail.com")
    				.andSubject("Entrevista Devco")
    				.andBody("Hola, usted ha sido seleccionado para un entrevista con nuestra empresa")
    				.toEmail();
    	
    	givenThat(sender).wasAbleTo(
    			openTheApplication,
    			EnterUserEmail.forLoggin(sender.getUserMail()),
    			EnterPassword.forLoggin(sender.getPassword()),
    			WaitUntil.the(GmailPage.COMPOSE_BUTTON, WebElementStateMatchers.isPresent()),
    			Click.on(GmailPage.COMPOSE_BUTTON),
    			Send.thisEmail(interviewJobEmail),
    			signoutOfApplication
		);
    	
    	when(receiver).attemptsTo(
    			changeAccout,
    			EnterUserEmail.forLoggin(receiver.getUserMail()),
    			EnterPassword.forLoggin(receiver.getPassword()),
    			Search.forTheMailSubject("Entrevista Devco")
    	);
    	
    	then(receiver).should(
    			eventually(seeThat(GmailPage.searchElement(), containsString("Entrevista Devco"))),
    			eventually(seeThat(GmailPage.searchElement(), not(containsString("1Entrevista1 1Devco1"))))
		);
    }
    
}