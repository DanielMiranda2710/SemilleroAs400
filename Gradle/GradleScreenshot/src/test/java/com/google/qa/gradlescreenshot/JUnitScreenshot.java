package com.google.qa.gradlescreenshot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitScreenshot {

	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		Screenshot.screenshot(driver);
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Devops right from the start");
		driver.findElement(By.name("btnK")).submit();
		
	}

}
