package com.google.qa.gradlemysqlwithscreenshot;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JUnitMySql {

	WebDriver driver;
	ResultSet rs;
	Connection con;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com.");
		String dataBaseUrl = "jdbc:mysql://localhost:3306/banco?useTimezone=true&serverTimezone=UTC";
		String user = "root";	
		String password = "Damicu2710+";			
		String query = "select nombre, apellidos,resultado, id from directores limit 7;";	
   	    Class.forName("com.mysql.cj.jdbc.Driver");
    	con = DriverManager.getConnection(dataBaseUrl,user,password);
	  	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
 		rs= stmt.executeQuery(query);	
	}

	@After
	public void tearDown() throws Exception {
		con.close();
		driver.close();
	}
	

	@Test
	public void test() throws SQLException {
		while (rs.next()){
    		String dataOne = rs.getString("nombre");
    		String dataTwo = rs.getString("apellidos");
    		driver.findElement(By.name("q")).sendKeys(dataOne + " " + dataTwo);
			driver.findElement(By.name("btnK")).submit();
			try {
				if(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Resultados de búsqueda')]"))) != null) {
					System.out.println("Reults for " + dataOne + " " + dataTwo);
					rs.updateString("resultado","found result");
					rs.updateRow();
					Screenshot.screenshot(driver);
					driver.get("https://google.com");				
				}				
			} catch (Exception e) {
				System.out.println("No results for: " + dataOne + " " + dataTwo);
				rs.updateString("resultado","not found result");
				rs.updateRow();
				Screenshot.screenshot(driver);
				driver.get("https://google.com");
			}			                          
            System. out.println(dataOne + " " + dataTwo);		
    }		
	}

}
