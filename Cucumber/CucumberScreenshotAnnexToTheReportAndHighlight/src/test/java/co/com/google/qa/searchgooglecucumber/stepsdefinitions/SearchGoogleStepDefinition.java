package co.com.google.qa.searchgooglecucumber.stepsdefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import co.com.googlepom.SearchGooglePom;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import utils.BasePage;
import utils.Driver;
import utils.Screenshot;

public class SearchGoogleStepDefinition {
	private WebDriver driver;
	private SearchGooglePom searchGooglePom;
	private Driver startDriver;
	private Scenario scenario;
	private Screenshot capture;
	BasePage basepage;
	
	@Before
	public void before(Scenario scenario) {
    this.scenario = scenario;
}
	
	@Given("Daniel is on the google home page")
	public void daniel_is_on_the_google_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Daniel abre su navegador");
		
		startDriver = new Driver(driver);
		driver= startDriver.startDriver("https://www.google.com");
		searchGooglePom = new SearchGooglePom(driver);
		capture = new Screenshot(driver,scenario);
		basepage = new BasePage(driver);
		
		System.out.println("Daniel abre la página de inicio de google");
	}

	@When("he does the search")
	public void he_does_the_search() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("En la barra de búsqueda Daniel escribe una palabra");
		searchGooglePom.escribirElTextoABuscar("cucumber java serenity ");
		
		System.out.println("Daniel da click en el botón buscar");
		searchGooglePom.darClickEnBotonBuscar();
	}

	@Then("he validates that the result is success")
	public void he_validates_that_the_result_is_success() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Daniel captura los resultados de la búsqueda");
		basepage.highlight(driver.findElement(By.xpath("//div[@id='rcnt']")), "10", "green");
		Thread.sleep(3000);
		capture.tomarPantallazo();
		System.out.println("Daniel verifica que la busqueda sea exitosa");
		driver.quit();
	}
}
