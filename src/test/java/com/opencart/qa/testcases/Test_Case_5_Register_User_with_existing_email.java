package com.opencart.qa.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.opencart.qa.pageobject.AccountCreatedPages;
import com.opencart.qa.pageobject.HomePage;
import com.opencart.qa.pageobject.NewUserSignUp;
import com.opencart.qa.pageobject.SignUpLoginPage;
import com.opencart.qa.testbase.TestBase;
import com.opencart.qa.utilities.DataProviders;

public class Test_Case_5_Register_User_with_existing_email extends TestBase{
	HomePage hp;
	SignUpLoginPage sign_up_login;
	HashMap<String, String> map;
	NewUserSignUp new_user_signup;
	AccountCreatedPages acc_creted_pages;
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
	}
	
	@Test
	public void registerUserwithexistingemailTest() {
		Assert.assertTrue(hp.automationTestingLogoVisisible());
		hp.clickSignupLoginBtn();
//		sf.assertEquals("New User Signup!",sign_up_login.validateNewUserSignUpText());
		sign_up_login.signUp("Satyam", p.getProperty("username"));
		
		Assert.assertEquals(sign_up_login.validateErrorMessage(), "Email Address already exist!");
		
	}
}
