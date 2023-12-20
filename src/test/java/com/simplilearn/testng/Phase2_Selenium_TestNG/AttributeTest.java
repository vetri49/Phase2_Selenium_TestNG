package com.simplilearn.testng.Phase2_Selenium_TestNG;

import org.testng.annotations.Test;

public class AttributeTest {

	@Test(description = "The sample Test One", priority = 2)
	public void testOne() {
		System.out.println("--- Test One is executed ---");
		
	}

    @Test(description = "The sample Test Three", priority = 1, enabled = false)
	public void testThree() {
		System.out.println("--- Test Three is executed ---");
		
	}

	
	@Test(description = "The sample Test Two", dependsOnMethods = { "testOne", "testThree" }, alwaysRun = true)
	public void testTwo() {
		System.out.println("--- Test Two is executed ---");
	}

	
	@Test(groups = "Regression Test")
	public void r1() {
		System.out.println("--- Test R1 is executed ---");
	}
	
	@Test(groups = "Regression Test" , timeOut = 200)
	public void r2() throws InterruptedException {
		
		Thread.sleep(500);
		System.out.println("--- Test R2 is executed ---");
	}
	
	@Test(groups = "Regression Test" , dependsOnGroups = {"Regression Test"})
//	@Test(groups = "Regression Test" , dependsOnGroups = {"Regression Test"}, alwaysRun = true)
	public void r3() {
		System.out.println("--- Test R3 is executed ---");
	}
}
