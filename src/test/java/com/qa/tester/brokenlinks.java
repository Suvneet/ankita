package com.qa.tester;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class brokenlinks {
	WebDriver driver;
	List<WebElement> activelinks;
	
	@BeforeClass
	public void initate_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suvneet.Singh\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Window-Size=1400,800");
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		driver.get("http://suvneet.singh:zxcvbnm@2093@rsyspedia.india.rsystems.com/SitePages/Home.aspx");
		
	}
	
	@Test
	public void check_links() throws MalformedURLException, IOException {
		System.out.println("check");
		
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Size full link and images : "+linklist.size());
		
		activelinks = new ArrayList<WebElement>();
		
		for(int i=0; i < linklist.size(); i++) {
			System.out.println(linklist.get(i).getAttribute("href"));
				if(linklist.get(i).getAttribute("href") !=null && (! linklist.get(i).getAttribute("href").contains("javascript"))) {
					activelinks.add(linklist.get(i));		
				}
			}
	}
	@Test
	public void active_links() throws MalformedURLException, IOException {
System.out.println("Working links are : "+activelinks.size());
		
		for(int j=0; j<activelinks.size();j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
				connection.connect();
				String response = connection.getResponseMessage();
				connection.disconnect();
				System.out.println(activelinks.get(j).getAttribute("href")+"---> "+response );
		}
		
	}
		
			
	@AfterClass
	public void close() {
		driver.quit();
		
	}
	
}
