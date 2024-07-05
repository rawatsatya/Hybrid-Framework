 package com.opencart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.qa.pageobject.HomePage;
import com.opencart.qa.pageobject.SignUpLoginPage;
import com.opencart.qa.testbase.TestBase;
import com.opencart.qa.utilities.DataProviders;



public class TestCase3_Login_User_with_incorrect_email_and_password extends TestBase{
	
	static int count;
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void loginUser_with_incorrect_email_and_password(String username,String pwd,String status) throws Exception {
		logger.info("***Test Case 3 : Started");
		HomePage hp = new HomePage(driver);
		hp.clickSignupLoginBtn();
		SignUpLoginPage signup_login = new SignUpLoginPage(driver);
		count++;
		System.out.println("Row "+count+" data passed from excel");
		signup_login.loginAsExistingUser(username, pwd);
		if(status.equalsIgnoreCase("valid")) {
			String usern = signup_login.verifyLoggedINAsUsername();
			if(usern.equals("Satyam")) {
				Assert.assertTrue(true);
				hp.clickOnlogout();
			}else {
				Assert.assertTrue(false);
			}
			
		}else if(status.equalsIgnoreCase("invalid")) {
			Assert.assertEquals(signup_login.validateErrorMessage(), "Your email or password is incorrect!");
		}
		logger.info("Test Case 3 : Ended");
	}
}
