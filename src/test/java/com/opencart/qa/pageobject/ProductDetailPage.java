package com.opencart.qa.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage{

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}

//	product name, category, price, availability, condition, brand
	@FindBy(xpath = "//div[@class='features_items']/div[2]//a[text()='View Product']") 
	WebElement view_product_first;
	
	
	@FindBy(xpath = "//div[@class='product-information']//h2")
	WebElement product_name;
	
	@FindBy(xpath = "//div[@class='product-information']//p[1]")
	WebElement category;
	
	@FindBy(xpath = "(//div[@class='product-information']//span)[2]")
	WebElement price;
	
	@FindBy(xpath = "//div[@class='product-information']//p/b[text()='Availability:']")
	WebElement availability;

	@FindBy(xpath = "//div[@class='product-information']//p/b[text()='Condition:']")
	WebElement condition;
	
	@FindBy(xpath = "//div[@class='product-information']//p/b[text()='Brand:']")
	WebElement brand;
	public void clickOnViewProductFirst() {
		view_product_first.click();
	}
	
	public String verifyProductName() {
		return product_name.getText();	
	}
	
	public boolean verifyCategory() {
		return 	category.isDisplayed();
	}
	
	public boolean verifyPrice() {
		return price.isDisplayed();
	}
	
	public boolean verifyAvailability() {
		return availability.isDisplayed();
	}
	
	public boolean verifyCondition() {
		return condition.isDisplayed();
	}
	
	public boolean verifyBrand() {
		return brand.isDisplayed();
	}
}
