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

	@FindBy(id = "nav-link-accountList")
	private WebElement account_list_options;

	@FindBy(xpath = "//span[text()='Sign Out']")
	private WebElement signout;

	public WebElement getAccount_list_options() {
		return account_list_options;
	}

	public WebElement getSignout() {
		return signout;
	}

}
