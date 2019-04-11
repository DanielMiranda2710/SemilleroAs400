package com.google.qa.gradlechallengeautomationeltiempowithmysql;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Operations {
	public static void screenshot(WebDriver driver) {
		java.io.File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:/selenium/"+System.currentTimeMillis()+".png"));
			} 
			catch (IOException e)
			 
			{
			  System.out.println(e.getMessage());
			}

	}
	
	public static void selection(WebDriver driver) {
		driver.get("https://www.eltiempo.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='qc-cmp-button']")).click();
		driver.findElement(By.xpath("//img[@alt='Donald Trump']")).click();
		//driver.findElement(By.xpath("//button[@id='onesignal-popover-cancel-button']")).click();
		//driver.findElement(By.xpath("//a[@class='page-link'][contains(text(),'Rusia')]")).click();
		screenshot(driver);
		
		
		//driver.findElement(By.xpath("//button[@id='onesignal-popover-cancel-button']")).click();
		
		//driver.findElement(By.xpath("//a[contains(text(),'papa Francisco')]")).click();
		}
	public static void search(WebDriver driver) {
		
		driver.get("https://www.eltiempo.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='qc-cmp-button']")).click();
		driver.findElement(By.xpath("//body[@class='section-home amp-mode-mouse qc-cmp-ui-showing']/div[@id='main-container']/div[@class='content_grid content_grid_header']/header[@class='header-home header-blanco']/div[@class='top-contenedor']/div[@class='topbar']/ul[@class='cliente']/li[@class='buscador-header-container']/a/span[1]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Noticias de Colombia y el Mundo']")).sendKeys("inteligencia artificial");
		driver.findElement(By.xpath("//form[@name='search_form']//span[@class='buscador-icon']")).submit();
		driver.findElement(By.xpath("//img[@src='/files/image_184_123/uploads/2017/05/02/5908b927d9d52.jpeg']")).click();
		WebElement product = driver.findElement(By.xpath("//div[7]//article[1]"));
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='20px solid green'",product);
		}
		screenshot(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.textToBe(By.xpath("//h1[@id='p339906-m367-366-368']"), "Con inteligencia artificial medirán el tráfico en Medellín"));
		WebElement producto = driver.findElement(By.xpath("//h1[@id='p339906-m367-366-368']"));
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='30px solid green'",producto);
		}
		screenshot(driver);
		
		
		
	}
	
	
}


