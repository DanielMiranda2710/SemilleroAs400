package com.google.qa.gradlechallengeautomationeltiempowithmysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JUnitElTiempo {

	WebDriver driver;
	ResultSet rs;

	@Before
	public void setUp() throws Exception {
		String dbUrl = "jdbc:mysql://localhost:3306/banco?useTimezone=true&serverTimezone=UTC";	
		String username = "root";		
		String password = "Damicu2710+";						
		String query = "select nombre, apellidos, resultado, id from directores;";
	    Class.forName("com.mysql.cj.jdbc.Driver");				
		Connection con = DriverManager.getConnection(dbUrl,username,password);		
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);						
		rs= stmt.executeQuery(query);	
	}
	

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		Operations.selection(driver);
	}
	
	@Test
	public void test2() {
		Operations.search(driver);
	}
	
	@Test
	public void test3() throws SQLException, InterruptedException {
		while (rs.next()){
    		String myName = rs.getString("nombre");
    		String myLastName = rs.getString("apellidos");
    		driver = new ChromeDriver();
    		driver.get("https://www.eltiempo.com");
    		driver.manage().window().maximize();
    		driver.findElement(By.xpath("//button[@class='qc-cmp-button']")).click();
    		driver.findElement(By.xpath("//body[@class='section-home amp-mode-mouse qc-cmp-ui-showing']/div[@id='main-container']/div[@class='content_grid content_grid_header']/header[@class='header-home header-blanco']/div[@class='top-contenedor']/div[@class='topbar']/ul[@class='cliente']/li[@class='buscador-header-container']/a/span[1]")).click();
    		driver.findElement(By.xpath("//input[@placeholder='Noticias de Colombia y el Mundo']")).sendKeys(myName + " " + myLastName);
    		driver.findElement(By.xpath("//form[@name='search_form']//span[@class='buscador-icon']")).submit();
			try {
				WebDriverWait wait = new WebDriverWait(driver,5);
				wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='search-results-title no-results']"), "¡LO SENTIMOS!"));
					System.out.println("Sin resultados para: " + myName + " " + myLastName);
					rs.updateString("resultado","Noticia No encontrada ");
					rs.updateRow();
					WebElement recuadro = driver.findElement(By.xpath("//div[@class='search-error-text']"));
					if (driver instanceof JavascriptExecutor) {
						((JavascriptExecutor)driver).executeScript("arguments[0].style.border='30px solid red'",recuadro);
					}
					Thread.sleep(2000);
					JavascriptExecutor mover;
					mover = (JavascriptExecutor)driver;
					mover.executeScript("window.scrollBy (0,400)");
					Thread.sleep(4000);
					Operations.screenshot(driver);
					driver.close();
				}				
			catch (Exception e) {
				System.out.println("Resultados encontrados para: " + myName + " " + myLastName);
				rs.updateString("resultado","Noticia encontrada");
				rs.updateRow();
				driver.close();
			}			                          
            System. out.println(myName + " " + myLastName);		
            
		}			
	}
}
