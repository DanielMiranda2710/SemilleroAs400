package com.eltiempo.qa.screenplayeltiempo.userinterfaces;

import org.openqa.selenium.By;


import net.serenitybdd.screenplay.targets.Target;

public class ElTiempoResultNews {
	public static final Target NEWS_IMAGE = Target.the("Desired news")
            .located(By.xpath("//img[@src='/files/image_184_123/uploads/2019/03/29/5c9e75fd79760.jpeg']"));
	
	public static final Target NEWS_IMAGE_SQUARE = Target.the("Desired news")
            .located(By.xpath("//div[contains(@class,'search-results-container homepage-board')]//div[3]//article[1]"));
	
	public static final Target NEWS_RESULTS = Target.the("Result news")
            .located(By.xpath("//div[@class='search-results-title']"));

}
