package com.client.projectName.SomkeTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.projectName.BaseClass.BaseClass;
import com.client.projectName.GenericUtility.Utility_Excel_Utility_test;
import com.client.projectName.ObjectRepo_Test.HomePage;

public class Serach_Module_Test extends BaseClass {

	@Test
	public void Verify_search_functionality() throws EncryptedDocumentException, IOException {
		String ExpectedResult = "Transform Your Life with Robin Sharma";

		// Get data from Excel for search field
		Utility_Excel_Utility_test eu = new Utility_Excel_Utility_test();
		String data1 = eu.getDataFromExcel("Sheet2", 2, 0);

		// Search product
		HomePage hp = new HomePage(driver);
		hp.getSerachfield().sendKeys(data1);
		hp.getSerach_btn().click();
		String book = hp.getFirstproduct_book().getText();

		// Validation
		Assert.assertEquals(book, ExpectedResult);
		System.out.println("TestCase result :" + book);

	}

	@Test
	public void Verify_product_detail() throws EncryptedDocumentException, IOException {
		//String ExpectedResult = "The Monk Who Sold His Ferrari 4.5(36.4k) ₹17700 M.R.P: ₹299.00 Delivery Sun, 24 May";

		// Get data from Excel for search field
		Utility_Excel_Utility_test eu = new Utility_Excel_Utility_test();
		String data1 = eu.getDataFromExcel("Sheet2", 2, 0);

		// Search product
		HomePage hp = new HomePage(driver);
		hp.getSerachfield().sendKeys(data1);
		hp.getSerach_btn().click();
		String book = hp.getFirstproduct_details().getText().trim();

		// Product details print
		//Assert.assertEquals(book, ExpectedResult);
		System.out.println("TestCase result :" + book);

	}

	@Test
	public void Verify_add_to_cart_button() throws EncryptedDocumentException, IOException, InterruptedException {
		String ExpectedResult = "15";

		// Get data from Excel for search field
		Utility_Excel_Utility_test eu = new Utility_Excel_Utility_test();
		String data1 = eu.getDataFromExcel("Sheet2", 2, 0);

		// Search product
		HomePage hp = new HomePage(driver);
		hp.getSerachfield().sendKeys(data1);
		hp.getSerach_btn().click();
		hp.getProduct_book().click();
		Thread.sleep(1000);
		String cartcount = hp.getCartcount().getText();

		// Validation
		Assert.assertEquals(cartcount, ExpectedResult);
		System.out.println("Cart count :" + cartcount);

	}

	@Test
	public void Verify_cart_page() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String ExpectedResult = "Amazon.in Shopping Cart";

		// Get data from Excel for search field
		Utility_Excel_Utility_test eu = new Utility_Excel_Utility_test();
		String data1 = eu.getDataFromExcel("Sheet2", 2, 0);

		// Search product
		HomePage hp = new HomePage(driver);

		WLib.waitForPageToLoad(driver);
		WLib.mousemoveonElement(driver, hp.getCart_btn());
		hp.getCart_btn().click();
		
		String cartTitle = driver.getTitle();

		// Validation
		Assert.assertEquals(cartTitle , ExpectedResult);
		 System.out.println("Page Title :" + cartTitle);

	}

}
