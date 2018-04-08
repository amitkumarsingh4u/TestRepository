package org.testingmasters.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.xml.crypto.Data;

import org.openqa.selenium.WebDriver;
import org.testingmasters.commonUtils.SelectBrowser;
import org.testingmasters.pageLib.LoginLib;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class LoginTests {
	
	static Properties prop = new Properties();
	WebDriver driver;
	
/*	@BeforeTest
	public void setUp() throws IOException {
		FileInputStream fis = new FileInputStream("./config.properties");
		prop.load(fis);
		
		driver = SelectBrowser.selectBrowser(prop.getProperty("browser"));
		 driver.get(prop.getProperty("url"));
	}
	
	@Test(priority = 1)
	public void loginValidCredentials() {
		LoginLib lb= new LoginLib(driver);
		lb.login(prop.getProperty("username"), prop.getProperty("password"));
		String title= driver.getTitle();
		assertEquals(title, "Find a Flight: Mercury Tours:");
		
	}
	*/
	@Test(dataProvider ="test",priority =2)
	public void loginInValidCredentials(String url,String name, String password) {
		/*LoginLib lb= new LoginLib(driver);
		lb.login("sdhdshb", "dsds");
		*/
		System.out.println(url+"  "+name+"  "+password );
		
	}
	
	@DataProvider(name ="test")
	public Object[][] data(){
			
		String data[][] = new String[2][3];
 		
		data[0][0] = "something";
		data[0][1] = "Somethingelse";
		data[0][2] = "dskjkhdsjhds";
		
		data[1][0] = "facebook";
		data[1][1] = "Google";
		data[1][2] = "kjsdhds";
		return data;
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	

}
