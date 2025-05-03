package com.testng;

import org.testng.annotations.Test;

public class GroupingTests {

	@Test(groups = {"smoke", "regression"},priority = 1)
	public void testOne() {
		System.out.println("This is my first test");
	}
	
	@Test(groups ="functional", priority = 2)
	public void testTwo() {
		System.out.println("This is my second test");
	}
	
	@Test(groups = "smoke", priority =3)
	public void testThree() {
		System.out.println("This is my third test");
	}
	
	@Test(groups = "regression", priority=4)
	public void testFour() {
		System.out.println("This is my fourth test");
	}
	
	@Test(groups = "api", priority=5)
	public void testFive() {
		System.out.println("This is my fifth test");
	}
	
}
