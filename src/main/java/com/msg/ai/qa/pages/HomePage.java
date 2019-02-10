package com.msg.ai.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.qa.base.testbase;

public class HomePage extends testbase {

	@FindBy(xpath="//div[@class='ais-bot-switch']//div[@class='el-col el-col-18']//h2[contains(text(),'666')]")
	WebElement bot;

	@FindBy(id = "//a[contains(text(),'Contacts')]")
	WebElement selectbot;
	
	@FindBy(xpath="//p[contains(text(),'Go ahead and select the Bot you’d like to view, modify, train or play with!')]")

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateAiLogo(){
			return aiLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd){
			email.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();	
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", loginBtn);
			return new HomePage();
		}	
	
	
	
	
	
	

}
