package com.client.projectName.ObjectRepo_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath  = "//span[text()='The Final Experiment | The Mystery Thriller of the Year | Witness the Fall of our World']/ancestor::div[@data-asin]//button[contains(text(),'Add to cart')]")
	private WebElement addtocart;
	
	

	public WebElement getAddtocart() {
		return addtocart;
	}

}
