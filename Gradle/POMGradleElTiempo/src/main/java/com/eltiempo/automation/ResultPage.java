package com.eltiempo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {
	WebDriver driver;
	By news = By.xpath("//img[@src='/files/image_184_123/uploads/2017/05/02/5908b927d9d52.jpeg']");
	By enterNews = By.xpath("//img[@src='/files/image_184_123/uploads/2017/05/02/5908b927d9d52.jpeg']");
	
	public ResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openNews() {
		this.driver.findElement(news).click();
	}
	
}