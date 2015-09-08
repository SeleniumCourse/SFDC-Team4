package com.selenium.course.framework;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.*;

/**
 * Created by Carlos Gonzales on 8/26/2015.
 */
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        //refresh page
        //setting
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // catch screenshot
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // catch screenshot
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // List of test results which we will delete later
        List<ITestResult> testsToBeRemoved = new ArrayList<>();

        // collect all id's from passed test
        Set<Integer> passedTestIds = new HashSet<>();
        for (ITestResult passedTest : iTestContext.getPassedTests().getAllResults()) {
            passedTestIds.add(getId(passedTest));
        }

        Set<Integer> failedTestIds = new HashSet<>();
        for (ITestResult failedTest : iTestContext.getFailedTests().getAllResults()) {

            // id = class + method + dataprovider
            int failedTestId = getId(failedTest);

            // if we saw this test as a failed test before we mark as to be deleted
            // or delete this failed test if there is at least one passed version
            if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId)) {
                testsToBeRemoved.add(failedTest);
            } else {
                failedTestIds.add(failedTestId);
            }
        }

        // finally delete all tests that are marked
        for (Iterator<ITestResult> iterator = iTestContext.getFailedTests().getAllResults().iterator(); iterator.hasNext(); ) {
            ITestResult testResult = iterator.next();
            if (testsToBeRemoved.contains(testResult)) {
                iterator.remove();
            }
        }
    }

    public int getId(ITestResult result) {
        int id = result.getTestClass().getName().hashCode();
        id = 31 * id + result.getMethod().getMethodName().hashCode();
        id = 31 * id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
        return id;
    }
}
