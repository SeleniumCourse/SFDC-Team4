package com.selenium.course.pages;

import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchWindow extends Page {
    private String windowsID;

    @FindBy(css = "h1")
    @CacheLookup
    private WebElement lookupTitle;

    @FindBy(id = "lksrch")
    @CacheLookup
    private WebElement searchTxt;

    @FindBy(name = "go")
    @CacheLookup
    private WebElement goBtn;

    private By searchFrame = By.id("searchFrame");
    private By resultFrame = By.id("resultsFrame");


    public SearchWindow(WebDriver driver) {
        super(driver);
        try {

            windowsID = driver.getWindowHandle();
            Set<String> windows = driver.getWindowHandles();
            windows = driver.getWindowHandles();
            LinkedList<String> windowsList = new LinkedList(windows);
            driver.switchTo().window(windowsList.getLast());

            wait.until(ExpectedConditions
                    .frameToBeAvailableAndSwitchToIt(searchFrame));


            wait.until(ExpectedConditions.visibilityOf(lookupTitle));


        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public void findObject(String object) {
        try {
            wait.until(ExpectedConditions
                    .frameToBeAvailableAndSwitchToIt(searchFrame));
            searchTxt.clear();
            searchTxt.sendKeys(object);
            goBtn.click();


        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }

        try {
            wait.until(ExpectedConditions
                    .frameToBeAvailableAndSwitchToIt(resultFrame));

            driver.findElement(By.linkText(object)).click();

        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        }
        driver.switchTo().window(windowsID);
    }

}
