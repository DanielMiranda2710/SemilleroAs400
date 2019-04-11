package com.eltiempo.qa.screenplayeltiempo.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.eltiempo.qa.screenplayeltiempo.interactions.Clicking;
import com.eltiempo.qa.screenplayeltiempo.utils.Utilities;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class ScreenplayElTiempoFoundNewsStepDefinitions {
	Utilities util;
	@Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private static Actor Daniel = Actor.named("Daniel Miranda");

    @Before
    public void actorCanBrowseTheWeb() {
        Daniel.can(BrowseTheWeb.with(hisBrowser));
        util = new Utilities();
   }
	
	@Given("^Daniel wants to enter the news$")
	public void danielWantsToEnterTheNews() throws Exception {
			
	}

	@When("^he selects the news$")
	public void heSelectsTheNews() throws Exception {
		Daniel.attemptsTo(Clicking.clickNewsFound(Daniel));
	}

	@Then("^he validates the selection$")
	public void heValidatesTheSelection() throws Exception {
		util.scroll(hisBrowser, "0", "1500");
		Thread.sleep(3000);
	    
	}
}
