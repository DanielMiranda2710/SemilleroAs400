package co.com.google.certificacion.miprimerscreenplay.stepsdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

import org.openqa.selenium.WebDriver;

import co.com.google.certificacion.miprimerscreenplay.questions.PhraseToLookFor;
import co.com.google.certificacion.miprimerscreenplay.tasks.SearchPhrase;
import co.com.google.certificacion.miprimerscreenplay.userinterfaces.GoogleHomePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;


public class BusquedaEnGoogleStepsDefinitions {
	
	GoogleHomePage googleHomePage;
	
	@Managed(driver = "chrome")
	    private WebDriver hisBrowser;
	    private Actor Daniel = Actor.named("Daniel Miranda");
	    
	@Before
	 public void actorCanBrowseTheWeb() {
	        Daniel.can(BrowseTheWeb.with(hisBrowser));
	   }
	
	@Given("^Daniel is in the google home page$")
	public void danielIsInTheGoogleHomePage() throws Exception {
		Daniel.wasAbleTo(Open.browserOn().the(googleHomePage));
	  
	}

	@When("^he searchs a \"([^\"]*)\" composite \"([^\"]*)\"$")
	public void heSearchsAComposite(String wordOne, String wordTwo) throws Exception {
	    Daniel.attemptsTo(SearchPhrase.composedOfTheWords(wordOne, wordTwo));
	}

	@Then("^he validates that word\"([^\"]*)\" is in results\\.$")
	public void heValidatesThatWordIsInResults(String expectedResult) throws Exception {
		Daniel.should(seeThat(PhraseToLookFor.searched(), is(expectedResult))); 
	}



}
