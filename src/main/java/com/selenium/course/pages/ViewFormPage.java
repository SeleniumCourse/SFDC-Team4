package com.selenium.course.pages;

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
 * Created by Rina Espinoza on 8/29/2015.
 */
public class ViewFormPage extends FormPage{

    @FindBy(className = "pageType")
    @CacheLookup
    protected WebElement pageTypeText;


    public ViewFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(pageTypeText));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }

    }

    public ObjectFormPage clickSaveNewBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(saveNewBtn));
        saveNewBtn.click();
        return new ObjectFormPage(driver);
    }

    public ViewDetailsPage clickSaveBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(saveBtn));
        saveBtn.click();
        return new ViewDetailsPage(driver);
    }

}
