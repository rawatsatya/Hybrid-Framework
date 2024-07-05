package com.opencart.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountCreatedPages extends BasePage{
	public AccountCreatedPages(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//div[@class='pull-right']/a[text()='Continue']")
	WebElement cont_btn;
	
	public void clickContinue() { // After clicking it will go to home page
		cont_btn.click();
	}
}

