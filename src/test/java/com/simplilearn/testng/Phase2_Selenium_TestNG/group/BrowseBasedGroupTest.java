package com.simplilearn.testng.Phase2_Selenium_TestNG.group;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BrowseBasedGroupTest {

	String amazonurl = "https://www.amazon.in";
	String facebookurl = "https://www.facebook.com";

	String firefoxpath = "drivers/windows/geckodriver.exe";
	String chromepath = "drivers/windows/chromedriver.exe";

	WebDriver driver1;
	WebDriver driver2;
	WebDriverWait driver2wait;

	@Test(groups = "chromeonly")
	public void launchChrome() {
		System.setProperty("webdriver.chrome.driver", chromepath);
		ChromeOptions cp = new ChromeOptions();
		cp.addArguments("--headless");
		driver1 = new ChromeDriver(cp);
		driver1.get(amazonurl);

	}

	@Test(groups = "chromeonly", description = "Search Iphone 15 pro max", dependsOnMethods = "launchChrome", priority = 1)
	private void testSearch1() throws InterruptedException {

		WebElement searchBox = driver1.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 15 pro max");
		searchBox.submit();

		// add delay
		Thread.sleep(2000);

		String expectedTitle = "Amazon.in : Iphone 15 pro max";
		String actualTitle = driver1.getTitle();

		assertEquals(actualTitle, expectedTitle);
	}

	@Test(groups = "chromeonly", dependsOnMethods = "testSearch1", description = "Search Apple mac book", priority = 2)
	private void testSearch2() throws InterruptedException {

		WebElement searchBox = driver1.findElement(By.id("twotabsearchtextbox"));
		searchBox.clear();
		searchBox.sendKeys("Apple Mac book");
		searchBox.submit();

		// add delay
		Thread.sleep(2000);

		String expectedTitle = "Amazon.in : Apple Mac book";
		String actualTitle = driver1.getTitle();

		assertEquals(actualTitle, expectedTitle);
	}

	@Test(groups = "firefoxonly")
	public void launchFirefox() {
		System.setProperty("webdriver.geckodriver.driver", firefoxpath);
		FirefoxOptions op = new FirefoxOptions();
		op.addArguments("--headless");
		driver2 = new FirefoxDriver(op);
		driver2wait = new WebDriverWait(driver2, Duration.ofSeconds(50));
		driver2.get(facebookurl);

	}

	@Test(dependsOnGroups = "chromeonly")
	public void cleanupchrome() {
		driver1.quit();

	}

	@Test(dependsOnGroups = "firefoxonly")
	public void cleanupfirefox() {
		driver2.quit();
	}

	@Test(groups = "firefoxonly", dependsOnMethods = "launchFirefox", priority = 4)
	public void facebookHomepageTest() {
		String text = "Facebook – log in or sign up";
		assertEquals(driver2.getTitle(), text);
	}

	@Test(groups = "firefoxonly", dependsOnMethods = "launchFirefox", priority = 5)
	public void testFailureLogin() {
		driver2.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver2.findElement(By.id("pass")).sendKeys("abc@123");
		driver2.findElement(By.name("login")).submit();

		WebElement errorMsg = driver2wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#loginform > div:nth-child(12) > div._9ay7")));

		String errortext = "The password that you've entered is incorrect. Forgotten password?";

		assertEquals(errorMsg.getText(), errortext);

	}

}
