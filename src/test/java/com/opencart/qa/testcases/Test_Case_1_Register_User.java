package com.opencart.qa.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.opencart.qa.pageobject.AccountCreatedPages;
import com.opencart.qa.pageobject.HomePage;
import com.opencart.qa.pageobject.NewUserSignUp;
import com.opencart.qa.pageobject.SignUpLoginPage;
import com.opencart.qa.testbase.TestBase;
import com.opencart.qa.utilities.DataProviders;

public class Test_Case_1_Register_User extends TestBase{
	HomePage hp;
	SignUpLoginPage sign_up_login;
	HashMap<String, String> map;
	NewUserSignUp new_user_signup;
	AccountCreatedPages acc_creted_pages;
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
	public void verifyRegisterUser() {
		logger.info("*****Test_Case_1_Register_User >> Started*******");
		boolean flag = hp.automationTestingLogoVisisible();
		Assert.assertEquals(flag, true);
		hp.clickSignupLoginBtn();
		Assert.assertTrue(sign_up_login.verifyNewUserSignup());
		sign_up_login.signUp(map.get("name"), map.get("email"));;
		new_user_signup.password(map.get("password"));
		new_user_signup.fillDertails(map.get("first_name"), map.get("last_name"), map.get("company"), map.get("address_1"), map.get("address_2"), map.get("country"), map.get("state"), map.get("city"), map.get("zipcode"),map.get("mobile_number"));
		new_user_signup.verifyAccountCreatedTextVisisible();
		acc_creted_pages.clickContinue();
		String msg = hp.cilckOnDelete();
		Assert.assertEquals(msg, "ACCOUNT DELETED!");
		
		logger.info("*****Test_Case_1_Register_User >> Finished*******");
	}
//	@BeforeMethod
//	public void initialize() {
//		hp = new HomePage(driver);
//		sign_up_login = new SignUpLoginPage(driver);
//	}
//	@Test
//	public void verify_Home_Page_Test() {
//		Assert.assertTrue(hp.automationTestingLogoVisisible());
//	}
//	@Test
//	public void new_User_Signup_is_visible() {
//		hp.clickSignupLoginBtn();
//		Assert.assertTrue(sign_up_login.verifyNewUserSignup());
//	}
	
}
