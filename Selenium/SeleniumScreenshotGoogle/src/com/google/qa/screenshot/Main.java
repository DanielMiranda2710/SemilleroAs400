package com.google.qa.screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {

	public static void main(String[] args) {
		
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.google.com.uy");
			driver.findElement(By.name("q")).sendKeys("Selenium get screenshot java");
			driver.findElement(By.name("btnK")).submit();
			Screenshot.screenshot(driver);
		}

	}


