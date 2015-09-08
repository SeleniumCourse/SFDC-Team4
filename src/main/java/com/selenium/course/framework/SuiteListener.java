package com.selenium.course.framework;

import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Created by Carlos Gonzales on 8/26/2015.
 */
public class SuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        // initialize driver
        // start services

    }

    @Override
    public void onFinish(ISuite suite) {
        // quit driver
    }
}
