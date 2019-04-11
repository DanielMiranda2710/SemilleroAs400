package com.eltiempo.qa.screenplayeltiempo.tasks;

import com.eltiempo.qa.screenplayeltiempo.exceptions.NoInternetConnection;
import com.eltiempo.qa.screenplayeltiempo.questions.VisibleLogo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class VisibleBrowser implements Task{
	PageObject page;

	public VisibleBrowser(PageObject page) {
		this.page = page;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.should(seeThat(VisibleLogo.Visible()).orComplainWith(NoInternetConnection.class,
		MessageNoConnection()));
		
	}
	
	public static VisibleBrowser on(PageObject page) {
		return instrumented(VisibleBrowser.class,page);
	}

	public String MessageNoConnection() {
		return String.format(NoInternetConnection.getErrorNetworkMessage());
	}
	
	
	
}
