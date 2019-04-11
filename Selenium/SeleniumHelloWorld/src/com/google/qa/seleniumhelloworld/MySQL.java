package com.google.qa.seleniumhelloworld;

import  java.sql.Connection;		
import  java.sql.Statement;
import 	org.openqa.selenium.By;
import 	org.openqa.selenium.WebDriver;
import 	org.openqa.selenium.chrome.ChromeDriver;
import 	org.openqa.selenium.support.ui.ExpectedConditions;
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;		
public class  MySQL {				
    	public static void  main(String[] args) throws  ClassNotFoundException, SQLException {													
				//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
    		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
    		WebDriver driver = new ChromeDriver();
    		driver.get("https://www.google.com.");
    		String dbUrl = "jdbc:mysql://localhost:3306/banco?useTimezone=true&serverTimezone=UTC";
			//Database Username		
			String username = "root";	
            
			//Database Password		
			String password = "Damicu2710+";				

			//Query to Execute		
			String query = "select nombre, apellidos,resultado, id from directores limit 7;";
     	    //Load mysql jdbc driver		
       	    Class.forName("com.mysql.cj.jdbc.Driver");			
       
       		//Create Connection to DB		
        	Connection con = DriverManager.getConnection(dbUrl,username,password);
      
      		//Create Statement Object		
    	   Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);					
   
   			// Execute the SQL Query. Store results in ResultSet		
     		ResultSet rs= stmt.executeQuery(query);							
         
         		// While Loop to iterate through all data and print results		
				while (rs.next()){
			        		String myName = rs.getString("nombre");
			        		String myLastName = rs.getString("apellidos");
			        		//String id = rs.getString("id");
			        		driver.findElement(By.name("q")).sendKeys(myName + " " + myLastName);
			    			driver.findElement(By.name("btnK")).submit();
			    			try {
			    				if(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Resultados de búsqueda')]"))) != null) {
			    					System.out.println("Resultados encontrados para " + myName + " " + myLastName);
			    					rs.updateString("resultado","Estamos melos");
			    					rs.updateRow();
			    					driver.get("https://google.com");				
			    				}				
			    			} catch (Exception e) {
			    				
			    				System.out.println("Sin resultados para: " + myName + " " + myLastName);
			    				rs.updateString("resultado","No estamos melos");
		    					rs.updateRow();
		    					driver.get("https://google.com");
			    				
			    			}			                          
                            System. out.println(myName + " " + myLastName);		
                    }		
      			 // closing DB Connection		
      			con.close();			
		}
}