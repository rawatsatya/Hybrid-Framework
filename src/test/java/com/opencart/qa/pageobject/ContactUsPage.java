package com.opencart.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactUsPage extends BasePage{
	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[@class='contact-form']/h2")
	WebElement get_in_touch;
	
	@FindBy(name = "name")
	WebElement name;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "subject")
	WebElement subject;
	
	@FindBy(id = "message")
	WebElement message;
	
	@FindBy(name = "upload_file")
	WebElement file_upload;
	
	@FindBy(name = "submit")
	WebElement submit;
	
	@FindBy(xpath = "//div[@class='contact-form']/div[2]")
	WebElement succes_msg;
	
	@FindBy(xpath = "//div[@id='form-section']/a")
	WebElement home_btn;
	
	public String validateGetInTouchText() {
		return get_in_touch.getText();
	}
	
	public void setName(String c_name) {
		name.sendKeys(c_name);
	}
	 public void setEmail(String c_email) {
		 email.sendKeys(c_email);
	 }
	
	 public void setSubject(String c_subject) {
		 subject.sendKeys(c_subject);
	 }
	
	 public void setMessages(String c_message) {
		 message.sendKeys(c_message);
	 }
	 
	 public void uploadFile(String path) {
		 file_upload.sendKeys(path);
	 }
	 
	 public void clickOnSubmit() {
		 submit.click();
	 }
	 
	 public String verifySucessMessage() {
		 return succes_msg.getText();
	 }
	 
	 public void clickOnHomeBtn() {
		 home_btn.click();
	 }
	 
	 
}
