package com.selenium.course.pages;

import com.selenium.course.framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 6/27/2015.
 */
public class EditChatPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private String windowsID;

    @FindBy(id = "quickActionFeedBodyInput")
    @CacheLookup
    WebElement publisherTxtArea;

    @FindBy(xpath = "//span[@class='publisherShareButtonPlaceholder']/input[@title='Save']")
    @CacheLookup
    WebElement SaveBtn;


    public EditChatPage(WebDriver driver) {
        this.driver = driver;
        this.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver, this);
        windowsID = this.driver.getWindowHandle();
        this.driver.switchTo().window(windowsID);
        wait.until(ExpectedConditions.visibilityOf(SaveBtn));
    }

    public void modifyPostMessage(String newMessage) {
        wait.until(ExpectedConditions.visibilityOf(publisherTxtArea));
        publisherTxtArea.clear();
        publisherTxtArea.sendKeys(newMessage);
    }

    public ChatterPage clickSaveBtn() {
        SaveBtn.click();
        return new ChatterPage(driver);
    }
}
