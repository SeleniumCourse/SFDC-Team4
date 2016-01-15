package com.selenium.course.framework;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.List;

/**
 * Created by Carlos Gonzales on 8/26/2015.
 */
public class Interceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(
            List<IMethodInstance> methods,
            ITestContext context) {
        return null;
        // split 10

        //
    }
}
