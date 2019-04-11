//import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Statement;

import java.sql.Connection;

public class mysql {

	WebDriver driver;
	String username;
	String ruta;
	String password;
	String query;
	Connection connection;
	Statement stmt;
	ResultSet resultSet;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com.");
		ruta = "jdbc:mysql://localhost:3306/banco";
		username = "root";
		password = "Damicu2710+";
		query = "Select nombre from clientes;";
		//Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(ruta,username,password);
		stmt = connection.createStatement();
		resultSet = stmt.executeQuery(query);
			
				
}
		
		
		
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws SQLException {
		while (resultSet.next()){
			System.out.println("Hola mundo");
    		String myName = resultSet.getString(1);								        
           // String myAge = resultSet.getString(2);					                               
            System. out.println(myName);		
    }		
	 // closing DB Connection		
	connection.close();	
	}

}
