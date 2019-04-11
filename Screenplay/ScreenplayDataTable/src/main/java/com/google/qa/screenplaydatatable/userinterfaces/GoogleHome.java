package com.google.qa.screenplaydatatable.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.google.com")
public class GoogleHome extends PageObject{
	 public static final Target SEARCH_BAR = Target.the("Search bar")    		
	        	.located(By.name("q"));
	 
	 public static final Target SEARCH_BUTTON = Target.the("Search news")    		
	            .located(By.name("btnK"));
}
