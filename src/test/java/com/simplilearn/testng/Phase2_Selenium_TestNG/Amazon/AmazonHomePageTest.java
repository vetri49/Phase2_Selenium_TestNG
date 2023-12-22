package com.simplilearn.testng.Phase2_Selenium_TestNG.Amazon;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonHomePageTest {

	WebDriver driver;
	String siteurl = "https://www.amazon.in/";
	String driverpath = "driver/windows/geckodriver.exe";

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.geckodriver.driver", driverpath);
		FirefoxOptions op = new FirefoxOptions();
		op.addArguments("--headless");
		driver = new FirefoxDriver(op);
		driver.get(siteurl);
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@Test(description = "Test Amazon home page title match")
	public void homePageTitleTest() {
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}

	@Test(description = "Test Amazon Home page source url")
	public void homePageSOurceUrlTest() {
		String url = driver.getCurrentUrl();
		assertEquals(siteurl, url);
	}

	@Test(description = "Test Amazon Home page title invalid match")
	public void homePageTitleTest2() {
		String actualTitle = "Online Shopping site in India: Shop Online for Mobile,Book, Watches, Shoes and More - Amazon.in";
		assertNotEquals(actualTitle, driver.getTitle());
	}

}
