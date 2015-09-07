package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.selenium.course.common.Globals.*;

public class NavigationLinks extends Page {

    @FindBy(id = "userNavLabel")
    @CacheLookup
    private WebElement userLabel;

    @FindBy(xpath = "//a[contains(@title,'Help')]")
    @CacheLookup
    private WebElement helpTab;

    @FindBy(xpath = "//a[@title='Logout']")
    @CacheLookup
    private WebElement logout;

    public NavigationLinks(WebDriver driver) {
        super(driver);
        /*try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(userLabel));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }*/
    }

    public HelpPage clickHelp() {
        helpTab.click();
        return new HelpPage(driver);
    }

    public String getLoginUsername() {
        return userLabel.getText();
    }

    public void clickLogoutBtn() {
        driver.findElement(By.id("userNav")).click();
        logout.click();
        driver.quit();
    }

}
