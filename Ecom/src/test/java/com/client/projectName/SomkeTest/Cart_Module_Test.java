package com.client.projectName.SomkeTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.projectName.BaseClass.BaseClass;
import com.client.projectName.GenericUtility.Utility_Excel_Utility_test;
import com.client.projectName.ObjectRepo_Test.HomePage;

public class Cart_Module_Test extends BaseClass {
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
