package com.crm.qa.testcases;

import org.testng.Assert;   // Ctrl+shift+O : short cut key for import packages
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super(); //here, config file property will be initialize from TestBase class  : try using press ctrl key and click on super 
	}

	// note: test cases should be separated or independent with each other
	// before each test cases -- launch the browser and login
	//@test --execute test case
	// after each test case -- close the browser
	
	@BeforeMethod
	public void setUP()
	{
		initialization();
		testUtil =new TestUtil();
		contactsPage=new ContactsPage();
		loginPage=new LoginPage(); // create the constructor of login page class
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//Test Cases
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		//System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.", "Home page title not matched"); //try to pass this message , so when test case will  fail this msg will show
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName()); // it will return true or false 
	}
	
	@Test (priority=3)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContctsLink();
		
	}	
	
	
	@AfterMethod
	public void tearDown()
	{
		// we have to close the browser every time after launch it and run the test cases...bcz
		driver.quit();  // for 100 test cases if they run on browser without close it then it will exhausted, cookies will be there 
	}

}
