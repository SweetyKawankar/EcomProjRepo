package com.client.projectName.SomkeTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.projectName.BaseClass.BaseClass;
import com.client.projectName.GenericUtility.Utility_Excel_Utility_test;
import com.client.projectName.ObjectRepo_Test.HomePage;

public class Serach_Module_Test extends BaseClass {
	
	@Test
	public void Verify_search_functionality() throws EncryptedDocumentException, IOException {
		String ExpectedResult = "Transform Your Life with Robin Sharma";
		
		//Get data from Excel for search field
		Utility_Excel_Utility_test eu = new Utility_Excel_Utility_test();
		String data1 = eu.getDataFromExcel("Sheet2",2, 0);
		
		//Search product
		HomePage hp = new HomePage(driver);
		hp.getSerachfield().sendKeys(data1);
		hp.getSerach_btn().click();
		String book = hp.getFirstproduct_book().getText();
		
		//Validation
		Assert.assertEquals(book , ExpectedResult);
		System.out.println("TestCase result :" + book);

	}
	

	@Test
	public void Verify_product_detail() throws EncryptedDocumentException, IOException {
		//String ExpectedResult = "Transform Your Life with Robin Sharma";
		
		//Get data from Excel for search field
		Utility_Excel_Utility_test eu = new Utility_Excel_Utility_test();
		String data1 = eu.getDataFromExcel("Sheet2",2, 0);
		
		//Search product
		HomePage hp = new HomePage(driver);
		hp.getSerachfield().sendKeys(data1);
		hp.getSerach_btn().click();
		String book = hp.getFirstproduct_book().getText().trim();
		
		//Validation
//		Assert.assertEquals(book1 , ExpectedResult);
		System.out.println("TestCase result :" + book);

	}

}
