package com.qa.tester;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class autoIT {
	
	WebDriver driver;
	
	@BeforeClass
	public void launch_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suvneet.Singh\\Downloads\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://suvneet.singh:zxcvbnm@2093@rsyspedia.india.rsystems.com/SitePages/Home.aspx");	
	}
	
	@Test
	public void upload_file() throws IOException, InterruptedException {
		driver.get("file:///C:/Users/Suvneet.Singh/Desktop/fileupload.html");
		driver.findElement(By.id("1")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Suvneet.Singh\\Desktop\\AutoITscript\\fileupload.exe");
	}
	
	@AfterClass
	public void close_browser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		
	}
	
}
