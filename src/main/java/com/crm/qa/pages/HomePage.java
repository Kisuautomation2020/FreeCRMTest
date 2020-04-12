package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	//Page Factory - OR (Object Repository)
	@FindBy(xpath="//td[contains(text(),'User: shweta patel')]")
	WebElement userNameLabel;

	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;


	@FindBy (xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy (xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	//Initializing the Page objects:
	public HomePage()
	{
		PageFactory.initElements(driver, this); 

	}

	public String verifyHomePageTitle()
	{
		return driver.getTitle(); // it's return title of the home page
	}

	public boolean verifyCorrectUserName()
	{
		
		return userNameLabel.isDisplayed();
		
	}
	
	//Note: if any link or button click and moving to the next page  then that particular next method should return the next landing page object as following
	
	public ContactsPage clickOnContctsLink() {

		contactsLink.click();
		return new ContactsPage(); // it returns contacts page object
	}
	public DealsPage clickOnDealsLink() {

		dealsLink.click();
		return new DealsPage(); // it returns contacts page object
	}
	
	public TasksPage clickOnTasksLink() {  

		tasksLink.click();
		return new TasksPage(); // it returns tasks page object
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	  
}
