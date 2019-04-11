package com.eltiempo.automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Operations {
	public static void screenshot(WebDriver driver) {
		java.io.File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:/selenium/FirstAutomationScreenshot/"+System.currentTimeMillis()+".png"));
			} 
			catch (IOException e)
			 
			{
			  System.out.println(e.getMessage());
			}
	}
}
