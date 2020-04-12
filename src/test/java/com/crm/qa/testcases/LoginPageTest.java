package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {   // here TestBase is a Parent Class -- so LoginPageTest (Child Class) extends it to use it's vars and methods.
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()   // it's constructor of the class 
	{
		super(); // it will call super class constructor by using 'super' keyword -- 
				//because we want to initialize the properties from TestBase() constructor before calling initialization method
	}
	
	@BeforeMethod  // testNg annotation
	public void setUP()
	{
		initialization();   //calling this method from the parent Class -TestBase
		loginPage=new LoginPage(); // create the constructor of login page class
	}
	
	@Test (priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test (priority=2)
	public void crmLogoImageTest()
	{
		boolean flag=loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test (priority=3)
	public void loginTest()
	{
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
