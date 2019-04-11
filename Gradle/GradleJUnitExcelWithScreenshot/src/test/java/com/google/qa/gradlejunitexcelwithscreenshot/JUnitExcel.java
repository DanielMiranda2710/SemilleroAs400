package com.google.qa.gradlejunitexcelwithscreenshot;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JUnitExcel {



	WebDriver driver;
	Workbook libro;
	Sheet hoja;
	FileInputStream inputStream;
	FileOutputStream escribirExcel;
	File pruebaExcel;
	String yourAccountLabelText;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com.");
		String ruta = "C:\\Users\\SEMILLERO12\\Desktop\\prueba.xlsx";
		pruebaExcel = new File(ruta);
		inputStream = new FileInputStream(pruebaExcel);//Para modificar
		libro = new XSSFWorkbook(inputStream);//Es un archivo de excel xlsx
		hoja = libro.getSheetAt(0);//Hoja 1
	}

	@After
	public void tearDown() throws Exception {
		inputStream.close();
		FileOutputStream escribirExcel = new FileOutputStream(pruebaExcel);//Para guardar las modificaciones
		libro.write(escribirExcel);
		escribirExcel.close();
		libro.close();
		driver.close();
	}

	@Test
	public void test() {
		List<String> datos = new ArrayList<String>();//Crear una lista
		int rows = hoja.getLastRowNum() - hoja.getFirstRowNum();//Cuantas filas tiene el archivo
		for(int i = 0; i <= rows; i++) {
			datos.add(hoja.getRow(i).getCell(0).getStringCellValue());//Leer y guardar en una lista
		}
		for (int i = 0; i <= rows; i++) {
			driver.findElement(By.name("q")).sendKeys(datos.get(i));
			driver.findElement(By.name("btnK")).submit();		
			
			try {
				if(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Resultados de búsqueda')]"))) != null) {
					Cell cell = hoja.getRow(i).createCell(hoja.getRow(i).getLastCellNum());//crear celda para meter informacion
					cell.setCellValue("Encontrado");
					Screenshot.screenshot(driver);
					driver.get("https://google.com");				
				}				
			} catch (Exception e) {
				Cell cell = hoja.getRow(i).createCell(hoja.getRow(i).getLastCellNum());
				cell.setCellValue("No encontrado");
				Screenshot.screenshot(driver);
			}
		}
	}
	
	
	@Test
	public void test2() {
		assertTrue (driver.getTitle().equals("GooglT"));
	}

}
