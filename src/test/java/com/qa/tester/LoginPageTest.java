package com.qa.tester;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.testbase;
import com.msg.ai.qa.pages.*;

public class LoginPageTest extends testbase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super(); //to call constructor of the class
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "AI Studio");
	}
	
	@Test(priority=2, enabled= false)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateAiLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3, enabled= false)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("Userid"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
