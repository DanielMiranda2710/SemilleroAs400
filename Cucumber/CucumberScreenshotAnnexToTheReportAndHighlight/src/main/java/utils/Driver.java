package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	WebDriver driver;
	
	public Driver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver startDriver(String page) {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(page);
		driver.manage().window().maximize();
		return driver;
	}
}
