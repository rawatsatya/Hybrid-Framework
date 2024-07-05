package com.opencart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.opencart.qa.pageobject.HomePage;
import com.opencart.qa.pageobject.TestCasesPage;
import com.opencart.qa.testbase.TestBase;

public class Test_Case_7_Verify_Test_Cases_Page extends TestBase{
	HomePage hp;
	TestCasesPage test_cases_page;
	SoftAssert sf;
	@BeforeMethod
	public void initializeobject() throws Exception {
		hp = new HomePage(driver);
		sf = new SoftAssert();
		test_cases_page = new TestCasesPage(driver);
	}
	
	@Test
	public void verifyTestCasesPage() {
		Assert.assertTrue(hp.automationTestingLogoVisisible());
		test_cases_page.clickOnTestCases();
		Assert.assertTrue(test_cases_page.verifyTestCasePageIsVisible());
	}
	
	
	
}
