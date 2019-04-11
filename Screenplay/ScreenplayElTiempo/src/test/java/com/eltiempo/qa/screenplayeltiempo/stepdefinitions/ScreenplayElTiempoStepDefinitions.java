package com.eltiempo.qa.screenplayeltiempo.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eltiempo.qa.screenplayeltiempo.exceptions.NotFoundNews;
import com.eltiempo.qa.screenplayeltiempo.models.ExpectedResult;
import com.eltiempo.qa.screenplayeltiempo.models.News;
import com.eltiempo.qa.screenplayeltiempo.questions.FoundProduct;
import com.eltiempo.qa.screenplayeltiempo.tasks.LookUpNews;
import com.eltiempo.qa.screenplayeltiempo.tasks.VisibleBrowser;
import com.eltiempo.qa.screenplayeltiempo.userinterfaces.ElTiempoHomePage;
import com.eltiempo.qa.screenplayeltiempo.utils.Utilities;
import static org.hamcrest.core.StringContains.containsString;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;

public class ScreenplayElTiempoStepDefinitions {
	
	public  static final int CURRENT_FRASE = 0;
	
	ElTiempoHomePage elTiempoHomePage;
	Utilities util;
	
	//static WebDriver driver;
	
	@Managed(driver = "chrome")
	    private WebDriver hisBrowser;
	    private static Actor Daniel = Actor.named("Daniel Miranda");

	    
	    
	@Before
	 public void actorCanBrowseTheWeb() {
	        Daniel.can(BrowseTheWeb.with(hisBrowser));
	        util = new Utilities();
	   }
	
	@Given("^Daniel wants to look for a news$")
	public void danielWantsToLookForANews() throws Exception {
		Daniel.wasAbleTo(Open.browserOn().the(elTiempoHomePage));
		Daniel.attemptsTo(VisibleBrowser.on(elTiempoHomePage));
	}

	@When("^he looks for the article$")
	public void heLooksForTheArticle(List<News> news) throws Exception {
		Daniel.attemptsTo(LookUpNews.composedNews(news.get(CURRENT_FRASE)));
	}
	
	@Then("^he expects to find the news$")
	public void heValidatedTheSelection(List<ExpectedResult> expectedResult){
		Daniel.should(seeThat(FoundProduct.verified(), containsString(expectedResult.get(0).getExpectedResult())).orComplainWith(NotFoundNews.class,NotFoundNews.newsNotFound()));
	}
}
