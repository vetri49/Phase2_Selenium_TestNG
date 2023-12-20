package com.simplilearn.testng.Phase2_Selenium_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {

	@Test
	public void testAsserts() {
		
		String userName = "Vikram";
		String message = null;
		int age = 24;
		boolean isMarried = false;
		
		assertEquals("Vikram", userName);
		assertEquals(24, age);
		assertNotEquals("Vikram", userName);
		
		assertNotNull(userName);
		assertNull(message);
		
		assertFalse(isMarried);
		assertTrue(!isMarried);
		
	}
	
	
	@Test(description = "Hard Assert method Test")
	public void hardAssertTest() {
		System.out.println("--- Hard assert method is started ---");
		assertEquals("Kennady Vikram", "Kennady Vikram");
		System.out.println("--- Hard assert method is ended ---");
	}
	
	@Test(description="Soft Assert method Test")
	public void softAssertTest() {
		SoftAssert softAssert = new SoftAssert();
		System.out.println("--- Soft assert method is started ---");
		softAssert.assertEquals("Hello", "Hi");
		softAssert.assertEquals("Kennady Vikram", "Kennady Vikram");
		softAssert.assertEquals(true, false);
		softAssert.assertTrue(true);
		System.out.println("--- Soft assert method is completed ---");
	}
}
