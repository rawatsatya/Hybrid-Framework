package com.opencart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.opencart.qa.pageobject.HomePage;
import com.opencart.qa.pageobject.ProductDetailPage;
import com.opencart.qa.pageobject.ProductsPage;
import com.opencart.qa.pageobject.SignUpLoginPage;
import com.opencart.qa.testbase.TestBase;

public class Test_Case_8_Verify_All_Products_and_product_detail_page extends TestBase{
	HomePage hp;
	SignUpLoginPage sign_up_login;
	ProductsPage product_page;
	ProductDetailPage product_detail_page;
	SoftAssert sf;
	@BeforeMethod
	public void initializeobject() throws Exception {
		hp = new HomePage(driver);
		sign_up_login = new SignUpLoginPage(driver);
		sf = new SoftAssert();
		product_page = new ProductsPage(driver);
		product_detail_page = new ProductDetailPage(driver);
	}
	
	@Test
	public void VerifyAllProductsAndProductDetailPage() {
		Assert.assertTrue(hp.automationTestingLogoVisisible());
		hp.clickSignupLoginBtn();
		sign_up_login.loginAsExistingUser(p.getProperty("username"), p.getProperty("password"));
		product_page.clicOnProductBtn();
		Assert.assertEquals(product_page.allProductsPageIsVisible(), "ALL PRODUCTS");
		Assert.assertTrue(product_page.validateFeatureItemDisplayed());
		product_detail_page.clickOnViewProductFirst();
		sf.assertEquals(product_detail_page.verifyProductName(), "Blue Top");
		sf.assertTrue(product_detail_page.verifyCategory());
		sf.assertTrue(product_detail_page.verifyPrice());
		sf.assertTrue(product_detail_page.verifyAvailability());
		sf.assertTrue(product_detail_page.verifyCondition());
		sf.assertTrue(product_detail_page.verifyBrand());
	}
	

}
