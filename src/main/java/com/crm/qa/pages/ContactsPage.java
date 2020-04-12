package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	//info about @Cache Lookup testNg annotation:
	//This annotation, when applied over a WebElement, instructs Selenium to keep a cache (memory) of the WebElement instead of searching for the WebElement every time from the WebPage.
	//This helps us save a lot of time and improves performance of your script.
	// drawback: some times if page gets refresh or web element gets refresh on the browser then cache memory will corrupted or will be stalled (StalledException)
	
	//Interview Question: How will you improve your script performance? ---> You can use @CacheLookup annotation for the particular web element which you think it will not get changed
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup 
	WebElement contactsLabel;

	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	//Initializing the Page objects: creating constructors
	public ContactsPage()
	{
		PageFactory.initElements(driver, this); //"this" points to current class objects

	}

	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//form[@id='vContactsForm']/table/tbody/tr[4]/td[1]")).click();

		/*driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();*/
	}
	
	public void createNewContact(String title, String ftName, String ltName, String comp) {
		 Select select = new Select(driver.findElement(By.name("title")));
		 select.selectByVisibleText(title);
		 
		 firstName.sendKeys(ftName);
		 lastName.sendKeys(ltName);
		 company.sendKeys(comp);
		 saveBtn.click();
	}
}
