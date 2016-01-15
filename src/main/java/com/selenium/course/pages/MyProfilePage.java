package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;

import com.selenium.course.framework.WebDriverManager;

import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

public class MyProfilePage extends Page{

    @FindBy(xpath = "//div[contains(@class,'userProfilePage')]")
    @CacheLookup
    WebElement myProfilePage;

    public MyProfilePage(WebDriver driver) {
        super(driver);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(myProfilePage));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public boolean MyProfilePageIsDisplayed() {
        return myProfilePage.isDisplayed();
    }

}
