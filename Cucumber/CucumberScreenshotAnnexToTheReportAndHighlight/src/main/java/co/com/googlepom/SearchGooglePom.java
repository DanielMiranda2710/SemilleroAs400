package co.com.googlepom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;

public class SearchGooglePom {
	WebDriver driver;
	private BasePage basePage;
	private By search = By.name("q");
	private By buttonSearch = By.name("btnK");
	
	public SearchGooglePom(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage(driver);
	}
	
	public void escribirElTextoABuscar (String cadenaABuscar) {
		basePage.writeText(search, cadenaABuscar);
	}
	
	public void darClickEnBotonBuscar() {
		basePage.click(buttonSearch);
	}
	
	public void tomarEvidencia() throws Exception {
		basePage.getEvidence("capture");
	}
}
