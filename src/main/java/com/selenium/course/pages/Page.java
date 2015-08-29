package com.selenium.course.pages;

import com.selenium.course.framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page() {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
    }

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverManager.getInstance().getWait();
    }
}
