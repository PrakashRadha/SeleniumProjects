package com.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageActions.LoginPageActions;
import PageObjects.BasePage;
import Utilities.BaseClass;

public class SampleLogic extends TestBase {

	private WebDriver driver;
	@Test
	public void LoginTest() throws InterruptedException {
		 driver = getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://adactinhotelapp.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("MageshKumar1806");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("L0WZF7");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='Submit']")).click();

	}
	
	
}
