package co.com.google.certificacion.miprimerserenity.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://www.google.com")
public class GoogleHomePage extends PageObject{
	
	@FindBy(name="q")
    private WebElementFacade searchBar;

    @FindBy(name="btnK")
    private WebElementFacade lookupButton;

    public void enterWords(String dataOne,String dataTwo) {
        searchBar.typeAndEnter(dataOne + " "+ dataTwo);
    }

    public void lookupTerms() {
    }
}
