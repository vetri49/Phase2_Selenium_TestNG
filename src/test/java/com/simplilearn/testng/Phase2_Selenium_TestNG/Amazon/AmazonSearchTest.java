package com.simplilearn.testng.Phase2_Selenium_TestNG.Amazon;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonSearchTest {
	String siteurl="https://www.amazon.in";
	String driverpath="drivers/windows/geckodriver.exe";
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.geckodriver.driver", driverpath);
		FirefoxOptions op=new FirefoxOptions();
		op.addArguments("--headless");
		driver=new FirefoxDriver(op);
		driver.get(siteurl);
	}
	@AfterClass
	public void clean() {
		driver.quit();
	}
	@Test(description="Search Iphone 15 pro max",priority=1)
	public void toSearch1() throws InterruptedException {
		WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 15 pro max");
		searchBox.submit();

		Thread.sleep(2000);
		
		String expectedTitle = "Amazon.in : Iphone 15 pro max";
		String actualTitle = driver.getTitle();
		
		assertEquals(actualTitle, expectedTitle);
		
	}
	@Test(description="seacrh Mac book",priority=2)
	public void toSearch2() throws InterruptedException {
		WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.clear();
		searchBox.sendKeys("Mac book");
		searchBox.submit();

		Thread.sleep(2000);
		
		String expectedTitle = "Amazon.in : Mac book";
		String actualTitle = driver.getTitle();
		
		assertEquals(actualTitle, expectedTitle);
	}

}
