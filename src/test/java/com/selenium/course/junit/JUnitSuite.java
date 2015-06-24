package com.selenium.course.junit;

import com.selenium.course.framework.DriverManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Carlos Gonzales on 5/25/2015.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Login.class,

})
public class JUnitSuite {

    @AfterClass
    public static void afterSuite() {
        DriverManager.getInstance().quit();
    }
}
