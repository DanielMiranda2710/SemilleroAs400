package com.eltiempo.qa.screenplayeltiempo.questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import static com.eltiempo.qa.screenplayeltiempo.userinterfaces.ElTiempoResultNews.NEWS_RESULTS;


@Subject
public class FoundProduct implements Question<String>  {
	

		

	@Override	
	public String answeredBy(Actor actor) {	
		return NEWS_RESULTS.resolveFor(actor).getTextContent();				
	}
	
	public static FoundProduct verified() {
		return new FoundProduct();
	}	
}