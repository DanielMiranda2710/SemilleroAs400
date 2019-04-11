package com.eltiempo.qa.screenplayeltiempo.tasks;

import static com.eltiempo.qa.screenplayeltiempo.userinterfaces.ElTiempoHomePage.BUTTON_COOKIES;
import static com.eltiempo.qa.screenplayeltiempo.userinterfaces.ElTiempoHomePage.INITIAL_SEARCH_BUTTON;
import static com.eltiempo.qa.screenplayeltiempo.userinterfaces.ElTiempoHomePage.SEARCH_BAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Task;

import org.openqa.selenium.Keys;

import com.eltiempo.qa.screenplayeltiempo.models.News;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LookUpNews implements Task {
	private String news;
	

	public LookUpNews(String news) {
		this.news = news;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				//Enter.theValue(phrase).into(SEARCH_BAR).thenHit(Keys.ENTER)
				Click.on(BUTTON_COOKIES),
				Click.on(INITIAL_SEARCH_BUTTON),
				Enter.theValue(news).into(SEARCH_BAR).thenHit(Keys.ENTER)
				);
		
		
	}
public static LookUpNews composedNews(News news) {
		return instrumented(LookUpNews.class, news.getwordOne() +" "+ news.getwordTwo());
	}
	
	
}
