package com.client.projectName.GenericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility_WebDriver_Utility_test {
	//ImplicitlyWait
		public void waitForPageToLoad(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		//Explicit
		public void waitForElementPresent(WebElement element , WebDriver driver) {
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		//Chlid Window Handles
		public void switchNewBrowserTab(WebDriver driver,String partailURL) {
			Set<String> set = driver.getWindowHandles();
			for (String id : set) {
				driver.switchTo().window(id);
				String currentUrl = driver.getCurrentUrl();
				if(currentUrl.contains(partailURL))
				{
					break;
				}
			}
			
		}
	//SwitchToFram
		public void switchtoFrame(WebDriver driver ,int index) {
			driver.switchTo().frame(index);
		}
		public void switchtoFrame(WebDriver driver ,String nameID) {
			driver.switchTo().frame(nameID);
		}
		public void switchtoFrame(WebDriver driver ,WebElement element) {
			driver.switchTo().frame(element);
		}
		
		//switchToAlert
		public void switchtoAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		public void switchtoAlertAndCancel(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		//Droup-Down
		public void select(WebElement element , String text) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		public void select(WebElement element , int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		
		//Action
		public void mousemoveonElement(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		public void doubleclickElement(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
	}



