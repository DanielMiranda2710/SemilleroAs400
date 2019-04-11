package com.eltiempo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FoundPage {
	WebDriver driver;
	WebDriverWait wait;
	By paragraph = By.xpath("//h1[@id='p339906-m367-366-368']");
	By highlightParagraph = By.xpath("//p[@id='p341446-m493-2-494']");
	
	public FoundPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void runCheckParagraph(String textNews) {
		this.wait.until(ExpectedConditions.textToBe(paragraph , textNews));
		this.scroll("0", "200");
		this.highlight("20", "red");
		Operations.screenshot(driver);
	}
	
	public void scroll(String x, String y) {
		JavascriptExecutor move;
		move = (JavascriptExecutor)driver;
		move.executeScript("window.scrollBy ("+x+","+y+")");
	}
	
	public void highlight(String pixel, String colour) {
		WebElement product = driver.findElement(highlightParagraph);
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border="+"'"+pixel+"px"+"solid" +colour+"'",product);
		}
	}
	
	
}