package com.testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;  // to set the UI of the report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest test; // to fetch the ddata of the report based on test execution
	
	@Override
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreport.html");
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Jeevi");
		extent.setSystemInfo("Browser Name", "Chrome");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case passed is "+result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case failed is "+result.getName());
		test.log(Status.FAIL, "Test case failure cause is "+result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped is "+result.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
