package ExplorerScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class explorer {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver","C:\\Selenium\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.bing.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("go")).submit();
	}
}
