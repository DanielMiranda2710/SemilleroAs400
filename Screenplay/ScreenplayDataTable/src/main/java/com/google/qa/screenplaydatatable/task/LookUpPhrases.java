package com.google.qa.screenplaydatatable.task;

import static com.google.qa.screenplaydatatable.userinterfaces.GoogleHome.SEARCH_BAR;
import static com.google.qa.screenplaydatatable.userinterfaces.GoogleHome.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.Keys;

import com.google.qa.screenplaydatatable.models.Phrase;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LookUpPhrases implements Task {
	private String phrase;
	

	public LookUpPhrases(String phrase) {
		this.phrase = phrase;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				//Enter.theValue(phrase).into(SEARCH_BAR).thenHit(Keys.ENTER)
			
				
				Enter.theValue(phrase).into(SEARCH_BAR).thenHit(Keys.ENTER),
				Click.on(SEARCH_BUTTON)
				);
		
		
	}
public static LookUpPhrases composedPhrase(Phrase phrase) {
		return instrumented(LookUpPhrases.class, phrase.getWordOne() +" "+ phrase.getWordTwo());
	}
	
	
}
