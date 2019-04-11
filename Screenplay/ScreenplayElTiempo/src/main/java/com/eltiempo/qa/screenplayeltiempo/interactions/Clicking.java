package com.eltiempo.qa.screenplayeltiempo.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import com.eltiempo.qa.screenplayeltiempo.utils.Utilities;
import static com.eltiempo.qa.screenplayeltiempo.utils.Utilities.highlight;

public class Clicking implements Interaction{

	@Override
	public <T extends Actor> void performAs(T actor) {
		WebElementFacade position = Utilities.listNews(actor);
		highlight(BrowseTheWeb.as(actor).getDriver(),position, "20", "blue");
		actor.attemptsTo(
		Click.on(position)
			);
	}
	
	
	public static Clicking clickNewsFound(Actor actor) {
		return instrumented(Clicking.class,actor);
	}
}
