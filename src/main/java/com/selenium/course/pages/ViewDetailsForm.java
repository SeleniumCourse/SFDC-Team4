package com.selenium.course.pages;

import com.selenium.course.framework.WebDriverManager;
import org.openqa.selenium.Alert;
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


public class ViewDetailsForm extends ObjectFormPage {

    @FindBy(xpath = "//div[@class='controls']")
    @CacheLookup
    WebElement viewTitle;

    @FindBy(xpath = "//a[contains(.,'Edit')]")
    @CacheLookup
    WebElement viewEdit;

    @FindBy(linkText = "Delete")
    @CacheLookup
    WebElement viewDelete;

    @FindBy(xpath = "//a[@id='create-new-view']")
    @CacheLookup
    WebElement createNewView;

    @FindBy(xpath = "//option[@selected='selected']")
    @CacheLookup
    WebElement viewName;

    public ViewDetailsForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(viewTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public ViewDetailsForm clickDeleteView() {
        viewDelete.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new ViewDetailsForm(driver);
    }

    public ViewFormPage clickEditView() {
        viewEdit.click();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new ViewFormPage(driver);
    }

    public ViewFormPage clickCreateNewView() {
        createNewView.click();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new ViewFormPage(driver);
    }

    public boolean verifyNewView(String viewName) {
        return this.viewName.getText().contains(viewName);
    }
}
