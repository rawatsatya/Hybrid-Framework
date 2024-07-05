package com.opencart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.qa.pageobject.HomePage;
import com.opencart.qa.pageobject.SignUpLoginPage;
import com.opencart.qa.testbase.TestBase;

public class Test_Case_2_Login_User_with_correct_email_and_password extends TestBase{
	HomePage hp;
	SignUpLoginPage signup_login;
	@Test
	public void LoginUserWithCorrectEmailAndPassword() {
		hp = new HomePage(driver);
		Assert.assertTrue(hp.automationTestingLogoVisisible());
		hp.clickSignupLoginBtn();
		signup_login = new SignUpLoginPage(driver);
		Assert.assertTrue(signup_login.loginToYourAccount());
		signup_login.loginAsExistingUser(p.getProperty("username"), p.getProperty("password"));
		String login_username = hp.loggedInUsername();
		Assert.assertEquals(login_username, "Satyam");
//	pending to write test cases
	}
	
}
