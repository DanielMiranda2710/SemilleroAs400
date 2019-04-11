package com.eltiempo.automation;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JUnitElTiempoPOM {
	WebDriver driver;
	HomePageElTiempo page;
	ResultPage result;
	FoundPage foundpage;
	WebDriverWait wait;


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		HomePageElTiempo.openBrowser(driver);
		page = new HomePageElTiempo(driver);
		result = new ResultPage(driver);
		wait = new WebDriverWait(driver,10);
		foundpage = new FoundPage(driver,wait);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		page.closeCookie();
		page.search("Inteligencia artificial");
		result.openNews();
		foundpage.runCheckParagraph("Vision artificial");
	}

}
