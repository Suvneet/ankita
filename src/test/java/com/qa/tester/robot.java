package com.qa.tester;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.FluentIterable;

public class robot {
static WebDriver driver;
	
	@BeforeClass
	public static void launch_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suvneet.Singh\\Downloads\\chromedriver.exe" );
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size= 1400,800");
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://suvneet.singh:zxcvbnm@2093@rsyspedia.india.rsystems.com/SitePages/Home.aspx");	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void upload_file() throws IOException, InterruptedException, AWTException {
		driver.findElement(By.xpath("//ul[@id='responsive']/li[4]/a/img")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement ntwframe = driver.findElement(By.xpath("//iframe[starts-with(@id,'DlgFrame')]"));
		driver.switchTo().frame(ntwframe);
		WebElement ntw = driver.findElement(By.xpath("//input[@value='Network/System']"));
		//Thread.sleep(2000);
		//WebElement btn = driver.findElement(By.linkText("Business Operations"));
		Point point = ntw.getLocation();
		
		int width = ntw.getSize().width;
		int height= ntw.getSize().height;
		
		int xaxis = ntw.getLocation().x;
		int yaxis = ntw.getLocation().y;
		System.out.println(xaxis);
		System.out.println(yaxis);
		//int xcord = point.getX();
		//int ycord = point.getY();
		Robot robot = new Robot();
		Actions builder = new Actions(driver);
		robot.mouseMove(0, 0);
		//builder.dragAndDropBy(btn, xaxis+width/2, yaxis+height/2+70);
		//builder.moveByOffset(xaxis, yaxis).build().perform();
		Thread.sleep(2000);
		//robot.mouseMove(xaxis+xaxis/1.5, yaxis*2.5);
		robot.delay(1500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click	
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click
	}
	
	@AfterClass
	public void close_browser() throws InterruptedException {
		Thread.sleep(8000);
		driver.quit();
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions(driver.findElement(By.id("abc")).click()));
		
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(10, TimeUnit.SECONDS)
				.ignoring(Exception.class);
		
		Wait waits = new FluentWait(driver).
				withTimeout(10, SECONDS)
				.pollingEvery(10, SECONDS).ignoring(Exception.class);
		
		Select dropdown = new Select(driver.findElement(By.id("")));
		
		
	}

	private Function ExpectedConditions(Object click) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
