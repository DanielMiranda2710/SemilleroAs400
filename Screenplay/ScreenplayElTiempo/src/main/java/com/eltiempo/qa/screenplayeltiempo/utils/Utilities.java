package com.eltiempo.qa.screenplayeltiempo.utils;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class Utilities {
	
	public static void highlight(WebDriver driver, WebElementFacade newFound, String pixel, String colour) {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='"+pixel+"px solid " +colour+"'",newFound);
		}
	}
	
	public void scroll(WebDriver driver, String x, String y) {
		JavascriptExecutor move;
		move = (JavascriptExecutor)driver;
		move.executeScript("window.scrollBy ("+x+","+y+")");
	}
	
    public static WebElementFacade listNews(Actor actor) {
    	List<WebElementFacade> listElements = BrowseTheWeb.as(actor).findAll("//div[@class='listing default-listing view-list']//a[@itemprop='name']");
    	int position = (int) (Math.random()*listElements.size());
    	return listElements.get(position);
    }
    
   
}
