package co.com.google.certificacion.miprimerserenity.stepsdefinitions;

import co.com.google.certificacion.miprimerserenity.steps.EndUserStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchGoogleStepsDefinitions {
	
	@Steps
	EndUserStep daniel;
	
	@Given("^Daniel is in google home page$")
	public void danielIsInGoogleHomePage() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    daniel.is_the_home_page();
	}


	@When("^he searchs a \"([^\"]*)\" compuesta \"([^\"]*)\"$")
	public void heSearchsACompuesta(String wordOne, String wordTwo) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    daniel.looks_for(wordOne + " " + wordTwo);
	}

	@Then("^he verify the \"([^\"]*)\" in step$")
	public void heVerifyTheInStep(String wordOne) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

}
