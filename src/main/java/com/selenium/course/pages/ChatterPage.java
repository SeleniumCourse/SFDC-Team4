package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

/**
 * Edited by Joel Rodriguez
 */
public class ChatterPage extends ObjectFormPage {

    @FindBy(id = "centerContent")
    @CacheLookup
    protected WebElement chatterPage;

    @FindBy(id = "publishereditablearea")
    @CacheLookup
    protected WebElement postChatTextArea;

    @FindBy(id = "publishersharebutton")
    @CacheLookup
    protected WebElement shareButton;

    @FindBy(xpath = "//a[@title='Delete this post']")
    @CacheLookup
    protected WebElement deletePostLink;

    @FindBy(xpath = "//a[contains(@style,'background-color: rgb(248, 248, 248);')]")
    @CacheLookup
    protected WebElement deleteLink;

    public ChatterPage(WebDriver driver) {
        super(driver);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(chatterPage));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public ChatterPage setTestToShare(String text) {
        postChatTextArea.clear();
        postChatTextArea.sendKeys(text);
        return this;
    }

    public ChatterPage shareText() {
        shareButton.click();
        return this;
    }

    public boolean verifyNewSharedPost(String text) {
        return driver.findElement(By.xpath("//span[contains(.,'" + text + "')]")).getText().contains(text);
    }
}