package com.opencart.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@alt='Website for automation practice']")
	WebElement logo_image;
	
	@FindBy(xpath="//a[text()=' Signup / Login']")
	WebElement signup_login_btn;
	
	@FindBy(xpath = "//ul/li/a[text()=' Delete Account']")
	WebElement delete_acc_btn;
	
	@FindBy(xpath="//a[text()=' Logged in as ']/b")
	WebElement login_user;
	
	@FindBy(xpath="//div[@class='login-form']/h2")
	WebElement msg_login_acc;
	
	@FindBy(xpath="//a[text()=' Logout']")
	WebElement logout_btn;
	
	@FindBy(xpath="//div/h2[@data-qa='account-deleted']/b")
	WebElement acc_deleted;
	
	@FindBy(xpath = "//a[text()=' Contact us']")
	WebElement contact_us;
	
	public boolean automationTestingLogoVisisible() {
		return logo_image.isDisplayed();
	}
	public void clickSignupLoginBtn() {
		signup_login_btn.click();
	}
	
	public String loggedInUsername() {
		return login_user.getText();
	}
	
	
	public void clickOnlogout() {
		logout_btn.click();
	}
	
	public String cilckOnDelete() {
		delete_acc_btn.click();
		return acc_deleted.getText();
	}
	
	public String validateLoginToYourAccountMsg() {
		return msg_login_acc.getText();
	}
	
	public void clickOnContactUs() {
		contact_us.click();
	}
	

}
