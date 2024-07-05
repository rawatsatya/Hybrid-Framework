package com.opencart.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[text()=' Products']")
	WebElement product_btn;
	
	@FindBy(xpath = "//div[@class='features_items']/h2")
	WebElement all_products;
	
	@FindBy(className = "features_items")
	WebElement feature_item;
	
	@FindBy(xpath = "//div[@class='features_items']/div[2]//a[text()='View Product']")
	WebElement first_product;
	
	public void clicOnProductBtn() {
		product_btn.click();
	}
	
	public String allProductsPageIsVisible() {
		return all_products.getText();
	}
	
	public boolean validateFeatureItemDisplayed() {
		return feature_item.isDisplayed();
	}
	public void viewProductOfFirstProduct() {
		first_product.click();
	}
}
