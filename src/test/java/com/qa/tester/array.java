package com.qa.tester;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class array {
	
	static WebDriver driver;
	
	
	@BeforeClass
	public void launch_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suvneet.Singh\\Downloads\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://suvneet.singh:zxcvbnm@2093@rsyspedia.india.rsystems.com/SitePages/Home.aspx");
		
		
	}
	
	@Test
	public void check() throws InterruptedException {
		driver.findElement(By.xpath("//ul[@id='responsive']/li[4]/a/img")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement ntwframe = driver.findElement(By.xpath("//iframe[starts-with(@id,'DlgFrame')]"));
		driver.switchTo().frame(ntwframe);
		//driver.findElement(By.xpath("//input[@value='Network/System']")).click();
		//List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		//int frameSize = frames.size();
		//String abc =frames.toString();
		//System.out.println(ntwframe);
		//for(int i=0; i < frameSize ; i++) {
			
			
		//}
		//driver.switchTo().frame("DlgFrame16eea804-994a-4270-923d-f8c93e6d4cca");
		//Thread.sleep(3000);
		WebElement ntw = driver.findElement(By.xpath("//input[@value='Network/System']"));
		Point point = ntw.getLocation();
		//int xcord = point.getX();
		//int ycord = point.getY();
		//System.out.println(xcord);
		//System.out.println(ycord);
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", ntw);
		
		Actions builder = new Actions(driver);
		//builder.moveToElement("//input[@value='Network/System']").
		//builder.moveToElement(ntw).click().build().perform();
		builder.moveToElement(ntw, point.getX(), point.getY()).click().build().perform();
		//driver.switchTo().defaultContent();
		
		System.out.println("Test");
		
	}
	
	@AfterClass
	public void close_browser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		
	}
	
}
