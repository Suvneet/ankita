package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.qa.util.TestUtil;

public class testbase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	
	public testbase() {
		try {
			prop = new Properties();
			InputStream ip = this.getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(ip);	
					//this.getClass().getClassLoader().getResourceAsStream("config.properties");
			//FileInputStream ip = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\Automation\\config.properties");
			
			//System.out.println(ip);
			//System.out.println(prop.getProperty("Userid"));
			//System.out.println(prop.getProperty("password"));
					
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() throws InterruptedException{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\ChromeSetup.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Downloads\\geckodriver.exe");	
			driver = new FirefoxDriver();
		}
		
		
		/*
		 * e_driver = new EventFiringWebDriver(driver); // Now create object of
		 * EventListerHandler to register it with EventFiringWebDriver eventListener =
		 * new WebEventListener(); e_driver.register(eventListener); driver = e_driver;
		 */
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
			
	}
	
	/*
	 * @Test public void urlenter() throws InterruptedException { initialization();
	 * driver.get(prop.getProperty("URL")); Thread.sleep(2000); driver.close();
	 * 
	 * }
	 */

}
