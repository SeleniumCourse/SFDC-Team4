package com.selenium.course.testng;

import com.selenium.course.framework.WebDriverManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by carlos_gonzales on 29-05-15.
 */
public class TestNGSuite {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Starting suite");
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverManager.getInstance().quit();
    }
}
