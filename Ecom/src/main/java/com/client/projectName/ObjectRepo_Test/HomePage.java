package com.client.projectName.ObjectRepo_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement serachfield;

	@FindBy(id = "nav-search-submit-button")
	private WebElement serach_btn;

	@FindBy(xpath = "(//span[contains(@class,'a-size-medium')])[1]")
	private WebElement firstproduct_book;

	@FindBy(xpath = "//div[@class='_c2Itd_productWrapper_2YcYM']")
	private WebElement firstproduct_details;

	@FindBy(xpath = "//span[text()='Ikigai: The Japanese secret to a long and happy life']/ancestor::div[@data-asin]//button[contains(text(),'Add to cart')]")
	private WebElement product_book;

	@FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
	private WebElement cart_btn;

	@FindBy(id = "nav-cart-count")
	private WebElement cartcount;

	public WebElement getProduct_book() {
		return product_book;
	}

	public WebElement getFirstproduct_book() {
		return firstproduct_book;
	}

	public WebElement getFirstproduct_details() {
		return firstproduct_details;
	}

	public WebElement getSerachfield() {
		return serachfield;
	}

	public WebElement getSerach_btn() {
		return serach_btn;
	}

	public WebElement getCart_btn() {
		return cart_btn;
	}

	public WebElement getCartcount() {
		return cartcount;
	}

}
