package com.selenium.course.pages;

import com.selenium.course.framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    public WebDriver driver;
    public WebDriverWait wait;

    public Page() {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
    }

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverManager.getInstance().getWait();
    }
}
