package com.client.projectName.ObjectRepo_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "ap_email_login")
	private WebElement Enter_mobilenumber_or_email;

	@FindBy(xpath = "//input[@class='a-button-input']")
	private WebElement continue_BTN;

	@FindBy(id = "ap_password")
	private WebElement password;

	@FindBy(id = "signInSubmit'")
	private WebElement signInBTN;

	public WebElement getEnter_mobilenumber_or_email() {
		return Enter_mobilenumber_or_email;
	}

	public WebElement getContinue_BTN() {
		return continue_BTN;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignInBTN() {
		return signInBTN;
	}

}
