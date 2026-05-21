package com.client.projectName.SomkeTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.projectName.BaseClass.BaseClass;
import com.client.projectName.GenericUtility.Utility_Excel_Utility_test;
import com.client.projectName.ObjectRepo_Test.HomePage;
import com.client.projectName.ObjectRepo_Test.LoginPage;

public class Login_MOdule_Test extends BaseClass {

	@Test
	public void Verify_Homepage() {

		String ExpectedResult = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String pagetitle = driver.getTitle();

		Assert.assertEquals(pagetitle, ExpectedResult);
		System.out.println("TestCase result :" + pagetitle);

	}

	@Test(enabled=false)
	public void Verify_Invalid_crendentioal() throws EncryptedDocumentException, IOException {

		WebDriver chromeDriver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Utility_Excel_Utility_test eu = new Utility_Excel_Utility_test();

		String data1 = eu.getDataFromExcel("Sheet1", 1, 0);
		String data2 = eu.getDataFromExcel("Sheet1", 1, 1);

		LoginPage lp = new LoginPage(driver);
		lp.getAccount_list_options().click();
		lp.getSignInBTN().click();
		lp.getEnter_mobilenumber_or_email().sendKeys(data1);
		lp.getContinue_BTN().click();
		lp.getPassword().sendKeys(data2);
		lp.getSignInBTN().click();

//		Assert.assertEquals(pagetitle, ExpectedResult);
//		System.out.println("TestCase result :" + pagetitle);

	}

}
