package com.testng;

import org.testng.annotations.Test;

public class DependencyTests {
	static int age = 17;
	@Test(expectedExceptions = Exception.class)
	public void myage() throws Exception {
		System.out.println(age);
		if(age <18) {
			throw new Exception();
		}
	}
	
	@Test(dependsOnMethods = "myage", timeOut=1000)
	public void isEligibleForVote() throws InterruptedException {
		System.out.println("Eligible for vote");
		Thread.sleep(2000);
	}
}
