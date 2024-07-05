package com.opencart.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class NewUserSignUp extends BasePage{
	public NewUserSignUp(WebDriver driver) {
		super(driver);
	}
	
	Select select;
	@FindBy (xpath = "//div[@class='login-form']/h2/b")
	WebElement enter_account_information;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(id = "days")
	WebElement date_date;
	
	@FindBy(id = "months")
	WebElement date_month;
	
	@FindBy(id = "years")
	WebElement date_years;
	
	@FindBy(xpath = "//label[text()='Sign up for our newsletter!']/parent::div//input[@type='checkbox']")
	WebElement news_letter_checkbox;
	
	@FindBy(xpath="//label[text()='Receive special offers from our partners!']/parent::div//input[@type='checkbox']")
	WebElement special_offer_checkbox;
	
	@FindBy (xpath="//label[@for='first_name']/following-sibling::input[@name='first_name']")
	WebElement first_name;
	
	@FindBy(xpath = "//label[@for='last_name']/following-sibling::input[@name='last_name']")
	WebElement last_name;
	
	@FindBy (xpath = "//label[@for='company']/following-sibling::input[@name='company']")
	WebElement company;
	
	@FindBy(xpath = "//label[@for='address1']/following-sibling::input[@name='address1']")
	WebElement address_1;
	
	@FindBy(xpath ="//label[@for='address2']/following-sibling::input[@name='address2']")
	WebElement address_2;
	
	@FindBy (id = "country")
	WebElement country;
	
	@FindBy(xpath = "//label[@for='state']/following-sibling::input[@name='state']")
	WebElement state;
	
	@FindBy(xpath = "//label[@for='city']/following-sibling::input[@name='city']")
	WebElement city;
	
	@FindBy(xpath = "//label[@for='city']/following-sibling::input[@name='zipcode']")
	WebElement zipcode;
	
	@FindBy(xpath = "//label[@for='mobile_number']/following-sibling::input[@name='mobile_number']")
	WebElement mobile_number;
	
	@FindBy(xpath="//button[@type='submit' and text()='Create Account']")
	WebElement create_accoun_btn;
	
	@FindBy(xpath="//b[text()='Account Created!']")
	WebElement account_created;

	
	public String validateEnterAccountInformation() {
		String actual_text = enter_account_information.getText();
		return actual_text;
	}
	
	public void password(String Pass) {
		password.sendKeys(Pass);
	}
	
	public void selectDateOfBirth(String day,String month,String year) {
		select = new Select(date_date);
		select.selectByVisibleText(day);
		select = new Select(date_month);
		select.selectByVisibleText(month);
		select = new Select(date_month);
		select.selectByVisibleText(month);
	}
	
	public void selectBothCheckBox() {
		news_letter_checkbox.click();
		special_offer_checkbox.click();
	}
	public void fillDertails(String fname,String lname,String comp,String adres_1,String adres_2,String countri,String rajya,String shaher,String pincode, String mob) {
		first_name.sendKeys(fname);
		last_name.sendKeys(lname);
		company.sendKeys(comp);
		address_1.sendKeys(adres_1);
		address_2.sendKeys(adres_2);
		select = new Select(country);
		select.selectByVisibleText(countri);
		state.sendKeys(rajya);
		city.sendKeys(shaher);
		zipcode.sendKeys(pincode);
		mobile_number.sendKeys(mob);
		create_accoun_btn.click();
	}
	public String verifyAccountCreatedTextVisisible() {
		return account_created.getText();
	}
}
