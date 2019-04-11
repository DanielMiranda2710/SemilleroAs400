package com.eltiempo.qa.screenplayeltiempo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import static com.eltiempo.qa.screenplayeltiempo.userinterfaces.ElTiempoHomePage.LOGO;
	
@Subject
public class VisibleLogo implements Question<Boolean>{
	public Boolean answeredBy(Actor actor) {
		return the(LOGO).answeredBy(actor).isCurrentlyVisible();
	}
	
	public static Question<Boolean> Visible(){
		return new VisibleLogo();
	}
}
