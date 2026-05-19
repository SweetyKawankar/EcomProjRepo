package com.client.projectName.BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.client.projectName.GenericUtility.Utility_Excel_Utility_test;
import com.client.projectName.GenericUtility.Utility_File_Utility_test;
import com.client.projectName.ObjectRepo_Test.HomePage;
import com.client.projectName.ObjectRepo_Test.LoginPage;

public class BaseClass {
	public Utility_File_Utility_test fLib = new Utility_File_Utility_test();
	public Utility_Excel_Utility_test ELib = new Utility_Excel_Utility_test();
	public WebDriver driver = null;

	@BeforeSuite
	public void configBS() {
		System.out.println("Connect To DB");
	}

	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("=====Launch the Browser=======");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firfox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void configBM() throws IOException {

		System.out.println("=====Login to Page=======");
		LoginPage lp = new LoginPage(driver);

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USER_Details = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		driver.get(URL);
		lp.getEnter_mobilenumber_or_email().sendKeys(USER_Details);
		lp.getContinue_BTN().click();
		lp.getPassword().sendKeys(PASSWORD);
		lp.getSignInBTN().click();

	}

	@AfterMethod
	public void configAM() {
		System.out.println("=====Logout to Page=======");
		HomePage hp = new HomePage(driver);
		hp.getSignout().click();

	}

	@AfterClass
	public void configAC() {
		System.out.println("=====Close the Browser=======");
		driver.quit();
	}

	@AfterSuite
	public void configAS() {
		System.out.println("DisConnect To DB");

	}

}
