package com.selenium.course.pages;

import com.selenium.course.framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;


public class ViewFormPage extends FormPage {

    @FindBy(xpath = "//form[@id='editPage']")
    @CacheLookup
    protected WebElement viewTitle;

    @FindBy(xpath = "//input[@data-uidsfdc='3']")
    @CacheLookup
    protected WebElement saveButton;

    @FindBy(id = "fname")
    @CacheLookup
    protected WebElement viewName;

    @FindBy(id = "devname")
    @CacheLookup
    protected WebElement viewUniqueName;

    public ViewFormPage(WebDriver driver) {
        super(driver);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(viewTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public ViewFormPage setViewName(String name) {
        viewName.clear();
        viewName.sendKeys(name);
        return this;
    }

    public ViewFormPage setUniqueViewName(String name) {
        viewUniqueName.clear();
        viewUniqueName.sendKeys(name);
        return this;
    }

    public ViewDetailsPage clickSaveView() {
        saveButton.click();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new ViewDetailsPage(driver);
    }
}
