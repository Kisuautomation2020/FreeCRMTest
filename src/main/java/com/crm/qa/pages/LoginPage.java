package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// ---------- define object repository / page factory of login page ---------
	// Page Factory - OR (Object Repository):

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn; // login button

	/*
	 * @FindBy (xpath="//button[contains(text(),'Sign Up')]") WebElement signUPBtn;
	 * // sign up button
	 */

	@FindBy(className = "img-responsive")
	WebElement crmLogo;

	@FindBy(linkText = "Sign Up")
	WebElement signUPLink;

	// Initialize the Page objects
	public LoginPage() {
		// here in below code this pointing to the current class object
		PageFactory.initElements(driver, this); // we can initialize all web elements using this 'driver' pass in the initElements();
												

	}

	// Actions: (different features on Login Page)
	public String validateLoginPageTitle() // it return the title of the page
	{
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) // this method is returning home page object bcz after login we are redirect to home page
													
	{
		username.sendKeys(un); // enter the email id of user
		password.sendKeys(pwd);
		// loginBtn.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginBtn);

		return new HomePage(); // return type of login page is HomePage() -- that's y we create HoemPage class object.
								
	}
}
