package com.simplilearn.testng.Phase2_Selenium_TestNG.Amazon;

import static org.testng.Assert.assertEquals;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class AmazonLinkVerificationCssSelectorTest {

	WebDriver driver;
	WebDriverWait wait;
	String siteurl="https://www.amazon.in";
	String driverpath="drivers/windows/geckodriver.exe";
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.geckodriver.driver", driverpath);
		FirefoxOptions op=new FirefoxOptions();
		op.addArguments("--headless");
		driver=new FirefoxDriver(op);
		driver.get(siteurl);
		wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	@Test(description = "Test Amazon Mobile Phones Title Match")
	public void tdLinkTest1() {
		WebElement mobileLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-xshop > a:nth-child(7)")));

		System.out.println("Is link loaded :: " + mobileLink.isDisplayed());
		System.out.println("Is link is enabled :: " + mobileLink.isEnabled());

		
		mobileLink.click();
		

		String expectedTitle = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}

	@Test(description = "Test Amazon Mobile Phones Title Match")
	public void tdLinkTest2() {
		WebElement tdLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-xshop > a:nth-child(6)")));

		System.out.println("Is link loaded :: " + tdLink.isDisplayed());
		System.out.println("Is link is enabled :: " + tdLink.isEnabled());

		tdLink.click();

		String expectedTitle = "Amazon.in - Deals";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}

}
