package com.google.qa.seleniumexcelwithscreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Main {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com.");
		String road = "C:\\Users\\SEMILLERO12\\Desktop\\prueba.xlsx";
		File testExcel = new File(road);
		FileInputStream inputStream = new FileInputStream(testExcel);//Para modificar
		Workbook bookExcel = new XSSFWorkbook(inputStream);//Es un archivo de excel xlsx
		Sheet sheet = bookExcel.getSheetAt(0);//Hoja 1
		MethodsExcel operations = new MethodsExcel(sheet);
		ArrayList<String> givens = (ArrayList<String>) operations.listExcelData();
		
		for (int i = 0; i <= operations.getRows(); i++) {
			driver.findElement(By.name("q")).sendKeys(givens.get(i));
			driver.findElement(By.name("btnK")).submit();
			
			try {
				if(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Resultados de búsqueda')]"))) != null) {
					System.out.println("Results found for " + givens.get(i));
					operations.writeExcel(operations.getSheet().getRow(i), "Found");	
					MethodsExcel.screenshot(driver);
					driver.get("https://google.com");				
				}				
			} catch (Exception e) {
				operations.writeExcel(operations.getSheet().getRow(i), "Not found");
				System.out.println("No results found for " + givens.get(i));
				MethodsExcel.screenshot(driver);
				driver.get("https://google.com");
			}
		}
		inputStream.close();
		FileOutputStream writeInExcel = new FileOutputStream(testExcel);//Para guardar las modificaciones
		bookExcel.write(writeInExcel);
		writeInExcel.close();
		bookExcel.close();
		driver.close();
	}
}

