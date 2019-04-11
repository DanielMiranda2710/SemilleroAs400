package com.google.qa.seleniumexcelwithscreenshot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class MethodsExcel {
public static void drive() {
		
	}
	
	private int rows;
	private Sheet sheet;
	
	public MethodsExcel(Sheet sheet) {
		this.sheet=sheet;
		this.rows = this.sheet.getLastRowNum() - this.sheet.getFirstRowNum();
	}
	
	public Sheet getSheet(){
		return sheet;
	}
	
	public int getRows(){
		return rows;
	}
	
	public List<String> listExcelData() {
		List<String> givens = new ArrayList<String>();
		for(int i = 0; i < this.getRows(); i++) {
			givens.add(this.getSheet().getRow(i).getCell(0).getStringCellValue());
		}
		return givens;
	}
	
	public void writeExcel(Row currentRow, String value) {
		Cell cell = currentRow.createCell(currentRow.getLastCellNum());
		cell.setCellValue(value);
	}
	
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
}


