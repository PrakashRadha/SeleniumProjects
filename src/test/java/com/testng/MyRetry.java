package com.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {
    int retry = 0;
    static int maxCount = 5;

    @Override
    public boolean retry(ITestResult result) {
        if (retry < maxCount) {
            retry++;
            return true;
        }
        return false;
    }
}
