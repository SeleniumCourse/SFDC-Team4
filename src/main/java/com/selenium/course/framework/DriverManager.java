package com.selenium.course.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by GustavoCavero
 */
public class DriverManager {

    private static DriverManager instance;
    private WebDriver driver;
    private WebDriverWait wait;

    private DriverManager() {
        initializeDriver();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private void initializeDriver() {
        driver = new FirefoxDriver();
        String baseUrl = "https://login.salesforce.com/";
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void quit() {
        driver.quit();
    }
}
