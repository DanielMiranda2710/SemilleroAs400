package co.com.google.certificacion.miprimerscreenplay.questions;


import co.com.google.certificacion.miprimerscreenplay.userinterfaces.GoogleResultPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("validate result")
public class PhraseToLookFor implements Question<String>  {
	
	public PhraseToLookFor() {
	}

	@Override
	public String answeredBy(Actor actor) {
		return GoogleResultPage.SEARCH_BAR.resolveFor(actor).waitUntilVisible().getValue();
	}
	
	public static PhraseToLookFor searched() {
		return new PhraseToLookFor();
	}
	
	


}
