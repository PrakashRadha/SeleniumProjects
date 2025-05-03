package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;



public class DataProvider {
	
	WebDriver driver;
	@Test(dataProvider = "dp")
	public void browserLaunch(String browser, String url) throws InterruptedException {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
  

	@org.testng.annotations.DataProvider(name = "dp")
	public Object[][] data(){
		return new Object[][] {
			{"chrome", "https://www.google.com/"},
			{"edge", "https://www.adactin.com/"}
		};
	}


}
