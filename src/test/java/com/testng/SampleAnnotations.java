package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleAnnotations {
	@Test
	public void myTest1() {
		System.out.println("@ Test 1");
	}
	
	@Test
	public void myTest2() {
		System.out.println("@ Test 2");
	}
	
	@Test
	public void myTest3() {
		System.out.println("@ Test 3");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
