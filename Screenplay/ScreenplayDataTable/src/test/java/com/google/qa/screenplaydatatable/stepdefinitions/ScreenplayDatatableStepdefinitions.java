package com.google.qa.screenplaydatatable.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;


import com.google.qa.screenplaydatatable.models.Phrase;
import com.google.qa.screenplaydatatable.task.LookUpPhrases;
import com.google.qa.screenplaydatatable.userinterfaces.GoogleHome;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;

public class ScreenplayDatatableStepdefinitions {
	public  static final int CURRENT_FRASE = 0;
	GoogleHome googleHome;
	@Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private static Actor Daniel = Actor.named("Daniel Miranda");

    
    
@Before
 public void actorCanBrowseTheWeb() {
        Daniel.can(BrowseTheWeb.with(hisBrowser));
   }
	
	@Given("^Daniel wants to look for a phrase$")
	public void danielWantsToLookForAPhrase() throws Exception {
		Daniel.wasAbleTo(Open.browserOn().the(googleHome));
	    
	}


	@When("^he looks for the phrase$")
	public void heLooksForThePhrase(List<Phrase> phrase) throws Exception {
		Daniel.attemptsTo(LookUpPhrases.composedPhrase(phrase.get(CURRENT_FRASE)));
	    
	}

	@Then("^he expects to find the phrase$")
	public void heExpectsToFindThePhrase() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
}
