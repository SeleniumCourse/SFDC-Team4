package com.selenium.course.framework;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by Carlos Gonzales on 8/26/2015.
 */
public class RetryAnalyzer implements IRetryAnalyzer{

    private int count = 0;
    private static final int COUNT_MAX = 1;

    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (count < COUNT_MAX) {
                count++;
                return true;
            }
        }
        return false;
    }
}
