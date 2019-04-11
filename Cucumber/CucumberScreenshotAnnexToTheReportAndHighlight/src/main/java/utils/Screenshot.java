package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;

import cucumber.api.Scenario;

public class Screenshot {
	private WebDriver driver;
	private Scenario scenario;
	
	public Screenshot(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
	}
	
	public void tomarPantallazo() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		try{
		    FileUtils.copyFile(src, new File("C:\\Users\\SEMILLERO12\\eclipse-workspace\\SearchGoogleCucumber\\target\\cucumber-report\\Prueba.png"));
		    scenario.embed(screenshot, "image/png");
		} 
		catch (Exception e) {
		    System.out.println("Excepcion mientras toma la captura "+e.getMessage());
		}
	}
	
}
