package com.client.projectName.BaseClass;

import java.io.IOException;
import java.time.Duration;

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
import com.client.projectName.GenericUtility.Utility_WebDriver_Utility_test;
import com.client.projectName.ObjectRepo_Test.HomePage;
import com.client.projectName.ObjectRepo_Test.LoginPage;

public class BaseClass {
	public Utility_File_Utility_test fLib = new Utility_File_Utility_test();
	public Utility_Excel_Utility_test ELib = new Utility_Excel_Utility_test();
	public Utility_WebDriver_Utility_test WLib = new Utility_WebDriver_Utility_test();
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
		WLib.waitForPageToLoad(driver);
		LoginPage lp = new LoginPage(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USER_Details = fLib.getDataFromPropertiesFile("EnterMobileNumber");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		driver.get(URL);

		lp.getAccount_list_options().click();

		lp.getEnter_mobilenumber_or_email().sendKeys(USER_Details);
		lp.getContinue_BTN().click();
		lp.getPassword().sendKeys(PASSWORD);
		lp.getSignInBTN().click();

	}

	@AfterMethod
	public void configAM() throws InterruptedException {
		System.out.println("=====Logout to Page=======");
		WLib.waitForPageToLoad(driver);
//		HomePage hp = new HomePage(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		LoginPage lp = new LoginPage(driver);
		WLib.mousemoveonElement(driver, lp.getAccount_list_options());
//		lp.getAccount_list_options().click();
		WLib.mousemoveonElement(driver, lp.getSignout2());
		
		//lp.getSignout().click();

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
