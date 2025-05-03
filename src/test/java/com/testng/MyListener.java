package com.testng;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import Utilities.BaseClass;

public class MyListener implements IAnnotationTransformer, ITestListener {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		if(annotation.getRetryAnalyzerClass() == null) {
			annotation.setRetryAnalyzer(MyRetry.class);
		}
	}
//	@Override
//	public void onTestFailure(ITestResult result) {
//		System.out.println("Test Failed : "+result.getName());
//		try {
//			BaseClass.captureScreenshot(result.getName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
