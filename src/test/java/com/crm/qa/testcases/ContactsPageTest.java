package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="contacts";

	public ContactsPageTest() // constructor calling
	{
		super();
	}

	@BeforeMethod
	public void setUP() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage(); // create the constructor of login page class
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame(); // to switch to the contacts page, which is in frame
		contactsPage = homePage.clickOnContctsLink(); // click on contact page link and return contact page object
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}

	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("test1 test1"); // this method clicking on this checkBox on contact page
	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("test1 test1");
		contactsPage.selectContactsByName("ui ui");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;

	}

	//---- POM with data driven approach with selenium-----  keyword driven approach is not recommended with POM as per maintenance point of view

	@Test(priority = 4, dataProvider="getCRMTestData")   // pass the getCRMTestData in this test to get the data from data provider
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) { // you have to create same column arguments which you fetch from excel data sheet
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

}
