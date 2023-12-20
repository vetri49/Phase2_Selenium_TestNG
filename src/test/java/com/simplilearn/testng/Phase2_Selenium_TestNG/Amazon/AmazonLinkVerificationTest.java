package com.simplilearn.testng.Phase2_Selenium_TestNG.Amazon;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonLinkVerificationTest {
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
	public void linkTest1() throws InterruptedException {
		WebElement link = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"));

		link.click();
		Thread.sleep(1000);

		String expectedTitle = "Amazon.in Bestsellers: The most popular items on Amazon";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}

	@Test(description = "Verify the Todays deals link")
	public void linkTest2() throws InterruptedException {
		WebElement link = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(6)"));

		link.click();

		Thread.sleep(1000);

		String expectedTitle = "Amazon.in - Deals";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}
}
