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

	@FindBy(xpath = "//span[text()='The Monk Who Sold His Ferrari']")
	private WebElement product_book;
	
	

	public WebElement getProduct_book() {
		return product_book;
	}
	
	public WebElement getFirstproduct_book() {
		return firstproduct_book;
	}

	public WebElement getSerachfield() {
		return serachfield;
	}

	public WebElement getSerach_btn() {
		return serach_btn;
	}

}
