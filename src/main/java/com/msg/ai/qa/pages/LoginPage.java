package com.msg.ai.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.testbase;


public class LoginPage extends testbase{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@placeholder='Enter Email' and @class='el-input__inner']")
	WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Enter Password' and @class='el-input__inner']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='el-button btn-submit el-button--default']")
	WebElement loginBtn;
	
	
	@FindBy(xpath="//img[@class='img-responsive' and @src='/images/login-graphic.png']")
	WebElement aiLogo;
	
	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		String title = driver.getTitle();
		return title;
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
