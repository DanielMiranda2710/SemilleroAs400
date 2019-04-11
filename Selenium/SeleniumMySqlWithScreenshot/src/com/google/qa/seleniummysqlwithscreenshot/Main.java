package com.google.qa.seleniummysqlwithscreenshot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {	
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com.");
		String dataBaseUrl = "jdbc:mysql://localhost:3306/banco?useTimezone=true&serverTimezone=UTC";	
		String user = "root";		
		String password = "Damicu961027";					
		String query = "select nombre, apellidos,resultado, id from directores limit 7;";		
   	    Class.forName("com.mysql.cj.jdbc.Driver");				
    	Connection con = DriverManager.getConnection(dataBaseUrl,user,password);	
    	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
 		ResultSet rs= stmt.executeQuery(query);							
     
			while (rs.next()){
		        		String data= rs.getString("nombre");
		        		String complement = rs.getString("apellidos");
		        		driver.findElement(By.name("q")).sendKeys(data+ " " + complement);
		    			driver.findElement(By.name("btnK")).submit();
		    			try {
		    				if(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Resultados de búsqueda')]"))) != null) {
		    					System.out.println("Results found for " + data+ " " + complement);
		    					rs.updateString("resultado","Result found");
		    					rs.updateRow();
		    					Screenshot.screenshot(driver);
		    					driver.get("https://google.com");				
		    				}				
		    			} catch (Exception e) {
		    				System.out.println("No results for: " + data+ " " + complement);
		    				rs.updateString("resultado","Result not found");
	    					rs.updateRow();
	    					Screenshot.screenshot(driver);
	    					driver.get("https://google.com");
		    			}			                          
                        System. out.println(data+ " " + complement);		
                }			
  			con.close();		
	}
}
