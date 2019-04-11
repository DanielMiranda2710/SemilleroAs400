package com.eltiempo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageElTiempo {
	WebDriver driver;
	By cookie = By.xpath("//button[@class='qc-cmp-button']");
	By buttonSearch = By.xpath("//body[@class='section-home amp-mode-mouse qc-cmp-ui-showing']/div[@id='main-container']/div[@class='content_grid content_grid_header']/header[@class='header-home header-blanco']/div[@class='top-contenedor']/div[@class='topbar']/ul[@class='cliente']/li[@class='buscador-header-container']/a/span[1]");
	By browser = By.xpath("//input[@placeholder='Noticias de Colombia y el Mundo']");
	By enterButton = By.xpath("//form[@name='search_form']//span[@class='buscador-icon']");
	
	public HomePageElTiempo(WebDriver driver) {
		this.driver = driver;
	}
	
	public void search(String busqueda) {
		this.driver.findElement(buttonSearch).click();
		this.driver.findElement(browser).sendKeys(busqueda);
		this.driver.findElement(enterButton).submit();
	}
	public void closeCookie() {
		this.driver.findElement(cookie).click();
	}	
	
	public static void openBrowser(WebDriver driver) {
		driver = new ChromeDriver();
		driver.get("https://www.eltiempo.com");
		driver.manage().window().maximize();
	}
	
}