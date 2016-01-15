package com.selenium.course.pages;

import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HelpPage extends Page{
    private String baseUrl;
    private String windowsID;

    @FindBy(id = "searchbox_heading")
    @CacheLookup
    WebElement helpSearchBox;

    public HelpPage(WebDriver driver) {
        super(driver);
        windowsID = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();
        windows = driver.getWindowHandles();
        LinkedList<String> windowsList = new LinkedList(windows);
        driver.switchTo().window(windowsList.getLast());
        wait.until(ExpectedConditions.visibilityOf(helpSearchBox));

    }

    public boolean isHelpPageDisplayed() {
        return helpSearchBox.isDisplayed();
    }

    public ContentPage closeHelpPage() {
        driver.close();
        driver.switchTo().window(windowsID);
        return new ContentPage(driver);
    }
}
