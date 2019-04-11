package co.com.google.certificacion.miprimerscreenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static co.com.google.certificacion.miprimerscreenplay.userinterfaces.GoogleHomePage.SEARCH_BAR;
import static co.com.google.certificacion.miprimerscreenplay.userinterfaces.GoogleHomePage.SEARCH_BUTTON;


public class SearchPhrase implements Task{
	
	private String phrase;
	
	public SearchPhrase(String phrase) {
		this.phrase = phrase;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(phrase).into(SEARCH_BAR),
				Click.on(SEARCH_BUTTON)
				);
		
	}
	
	public static SearchPhrase composedOfTheWords(String wordOne, String wordTwo) {
		
		return instrumented(SearchPhrase.class, wordOne +" "+ wordTwo);
			
	}
	

}
