package com.testng;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import Utilities.BaseClass;

public class MyTestListener implements ITestListener, IAnnotationTransformer {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Starts " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Passed " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed " + result.getName());
		Object testInstance = result.getInstance();

		if (testInstance instanceof TestBase) {
			WebDriver driver = ((TestBase) testInstance).getDriver();
			try {
				BaseClass.captureScreenshot(driver, result.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Test instance is not a TestBase. Screenshot not captured.");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Skipped " + result.getName());
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setRetryAnalyzer(MyRetry.class);

	}
}
