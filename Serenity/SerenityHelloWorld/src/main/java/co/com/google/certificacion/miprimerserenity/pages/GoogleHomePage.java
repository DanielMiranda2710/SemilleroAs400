package co.com.google.certificacion.miprimerserenity.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://www.bing.com")
public class GoogleHome extends PageObject{
	
	@FindBy(name="q")
    private WebElementFacade searchBar;

    @FindBy(name="go")
    private WebElementFacade lookupButton;

    public void enterWords(String word) {
        searchBar.typeAndEnter(word);
    }

    public void lookupTerms() {
    }
}
