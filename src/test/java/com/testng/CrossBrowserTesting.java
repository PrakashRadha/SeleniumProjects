package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

	WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	public void browserLaunch(String browser) {
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void getTitle() {
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
