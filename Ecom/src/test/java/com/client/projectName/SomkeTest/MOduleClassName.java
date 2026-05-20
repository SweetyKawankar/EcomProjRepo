package com.client.projectName.SomkeTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.projectName.BaseClass.BaseClass;
import com.client.projectName.GenericUtility.Utility_Excel_Utility_test;



public class MOduleClassName extends BaseClass {

	@Test
	public void Verify_Homepage() {

		String ExpectedResult = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String pagetitle = driver.getTitle();

		Assert.assertEquals(pagetitle, ExpectedResult);
		System.out.println("TestCase result :" + pagetitle);

	}

	@Test
	public void Verify_Invalid_crendentioal() throws EncryptedDocumentException, IOException {
		
		Utility_Excel_Utility_test eu = new Utility_Excel_Utility_test();

		String data1 = eu.getDataFromExcel("Sheet1", 7, 0);

		String ExpectedResult = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String pagetitle = driver.getTitle();

		Assert.assertEquals(pagetitle, ExpectedResult);
		System.out.println("TestCase result :" + pagetitle);
		System.out.println("new statement");

	}

}
