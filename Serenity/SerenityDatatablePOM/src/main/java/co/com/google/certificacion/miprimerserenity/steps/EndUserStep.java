package co.com.google.certificacion.miprimerserenity.steps;

import co.com.google.certificacion.miprimerserenity.pages.GoogleHomePage;
import net.thucydides.core.annotations.Step;


public class EndUserStep {
	
    GoogleHomePage googlePage;
    
    @Step
    public void is_the_home_page() {
        googlePage.open();
    }

    @Step
    public void enterKeyword(String dataOne, String dataTwo) {
        googlePage.enterWords(dataOne,dataTwo);
    }

    @Step
    public void startsSearch() {
    	googlePage.lookupTerms();
    
    }

    @Step
    public void looks_for(String term,String tern) {
        enterKeyword(term,tern);
        startsSearch();
    }

    
}