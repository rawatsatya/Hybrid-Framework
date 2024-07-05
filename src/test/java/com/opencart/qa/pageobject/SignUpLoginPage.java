package com.opencart.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpLoginPage extends BasePage{
	public SignUpLoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath="//div[@class='signup-form']/h2[text()='New User Signup!']")
	WebElement new_user_signup;
	
	@FindBy(name = "name")
	WebElement name;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement email;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement signup_btn;
	
	@FindBy (xpath="//div[@class='login-form']/h2[text()='Login to your account']")
	WebElement Login_to_Account_text;
	
	@FindBy(xpath="//div[@class='signup-form']/h2")
	WebElement new_signup_msg;
	
	@FindBy(xpath = "//div[@class='login-form']//form/input[@type='email']")
	WebElement existing_email;
	
	@FindBy(xpath = "//div[@class='login-form']//form/input[@type='password']")
	WebElement existing_password;
	
	@FindBy(xpath = "//div[@class='login-form']//button[text()='Login']")
	WebElement login_btn;
	
	@FindBy(xpath = "//ul/li/a[text()=' Logged in as ']/b")
	WebElement username;
	
	@FindBy(xpath="//form/p[text()='Email Address already exist!']")
	WebElement error_message;
	
	
	public boolean verifyNewUserSignup() {
		return new_user_signup.isDisplayed();
	}
	
	public void signUp(String fname,String email_address) {
		name.sendKeys(fname);
		email.sendKeys(email_address);
		signup_btn.click();
	}
	
	public boolean loginToYourAccount() {
		return Login_to_Account_text.isDisplayed();
	}
	
	public void loginAsExistingUser(String e_user,String e_password) {
		existing_email.sendKeys(e_user);
		existing_password.sendKeys(e_password);
		login_btn.click();
	}
	
	public String verifyLoggedINAsUsername() {
		String u_name = username.getText();
		return u_name;
	}
	public String validateErrorMessage() {
		return error_message.getText();
	}
	public String validateNewUserSignUpText() {
		return new_signup_msg.getText();
	}
}
