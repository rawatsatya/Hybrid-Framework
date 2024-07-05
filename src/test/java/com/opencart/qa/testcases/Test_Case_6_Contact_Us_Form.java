package com.opencart.qa.testcases;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.opencart.qa.pageobject.AccountCreatedPages;
import com.opencart.qa.pageobject.ContactUsPage;
import com.opencart.qa.pageobject.HomePage;
import com.opencart.qa.pageobject.NewUserSignUp;
import com.opencart.qa.pageobject.SignUpLoginPage;
import com.opencart.qa.testbase.TestBase;
import com.opencart.qa.utilities.DataProviders;

public class Test_Case_6_Contact_Us_Form extends TestBase{
	HomePage hp;
	SignUpLoginPage sign_up_login;
	HashMap<String, String> map;
	NewUserSignUp new_user_signup;
	AccountCreatedPages acc_creted_pages;
	ContactUsPage contact_us_pg;
	SoftAssert sf;
	@BeforeMethod
	public void initializeobject() throws Exception {
		hp = new HomePage(driver);
		sign_up_login = new SignUpLoginPage(driver);
		new_user_signup = new NewUserSignUp(driver);
		acc_creted_pages = new AccountCreatedPages(driver);
		DataProviders dp = new DataProviders();
		map = new HashMap<String, String>();
		map = dp.mapData();
		contact_us_pg = new ContactUsPage(driver);
		sf = new SoftAssert();
	}
	
	
	@Test
	public void contactUsForm() {
		Assert.assertTrue(hp.automationTestingLogoVisisible());
		hp.clickOnContactUs();
		sf.assertEquals(contact_us_pg.validateGetInTouchText(), "GET IN TOUCH");
		contact_us_pg.setName("Satyam");
		contact_us_pg.setEmail(p.getProperty("email"));
		contact_us_pg.setSubject("Enquiry for Subject");
		contact_us_pg.setMessages(p.getProperty("text_messages"));
		contact_us_pg.uploadFile("C:\\Users\\Rawat\\eclipse-workspace\\Automation_Execise_0.1\\upload-file\\Test Case 3.txt");
		contact_us_pg.clickOnSubmit();
		Alert simple_alert = driver.switchTo().alert();
		simple_alert.accept();
		Assert.assertEquals(contact_us_pg.verifySucessMessage(), "Success! Your details have been submitted successfully.");
		contact_us_pg.clickOnHomeBtn();
		Assert.assertTrue(hp.automationTestingLogoVisisible());
	}
}
