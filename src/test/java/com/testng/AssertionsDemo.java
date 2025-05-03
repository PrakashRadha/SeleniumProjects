package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
	
	@Test
	public void myTest() {
		System.out.println("Hi");
		System.out.println("Hello");
		Assert.assertTrue(true, "This test passed successfully"); // A successful assertion
		System.out.println("How are you ?");
	}
}
