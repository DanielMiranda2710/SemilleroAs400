package com.eltiempo.qa.screenplayeltiempo.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.eltiempo.com")
public class ElTiempoHomePage extends PageObject{
		
	public static final Target BUTTON_COOKIES = Target.the("Disable cookies")
            .located(By.xpath("//button[@class='qc-cmp-button']"));
	
	public static final Target INITIAL_SEARCH_BUTTON = Target.the("Open search")
            .located(By.xpath("//body[@class='section-home amp-mode-mouse']/div[@id='main-container']/div[@class='content_grid content_grid_header']/header[@class='header-home header-blanco']/div[@class='top-contenedor']/div[@class='topbar']/ul[@class='cliente']/li[@class='buscador-header-container']/a/span[1]"));
	
    public static final Target SEARCH_BAR = Target.the("Search bar")    		
        	.located(By.name("q"));
	    
    public static final Target FINAL_SEARCH_BUTTON = Target.the("Search news")    		
            .located(By.xpath("//form[@name='search_form']//span[@class='buscador-icon']"));
    
    public static final Target LOGO = Target.the("Logo el tiempo")    		
            .located(By.xpath("//*[@id='Capa_1']"));
    
  
	    
}
