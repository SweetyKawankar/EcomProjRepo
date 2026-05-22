package com.client.projectName.ObjectRepo_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Serachfield {

	WebDriver driver;

	public Serachfield(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	

}
