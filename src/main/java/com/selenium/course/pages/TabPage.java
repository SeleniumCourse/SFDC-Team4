package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public class TabPage extends ContentPage {

    @FindBy(name = "new")
    @CacheLookup
    public WebElement newBtn;

    @FindBy(linkText = "Create New View")
    @CacheLookup
    public WebElement createNewViewLink;

    @FindBy(linkText = "Edit")
    @CacheLookup
    public WebElement editViewLink;

    public TabPage(WebDriver driver) {
        super(driver);
    }

    public ObjectFormPage clickNewBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(newBtn));
        newBtn.click();
        return new ObjectFormPage(driver);
    }

    public ViewFormPage clickCreateNewViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(createNewViewLink));
        createNewViewLink.click();
        return new ViewFormPage(driver);
    }

    public ViewFormPage clickEditViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(editViewLink));
        editViewLink.click();
        return new ViewFormPage(driver);
    }

    public Boolean existByLinkText(String value)
    {
        Boolean result = false;
        try {
            driver.findElement(By.linkText(value));
            result = true;
        } catch (WebDriverException e) {
            result = false;
        } finally {
            return result;
        }
    }

}
