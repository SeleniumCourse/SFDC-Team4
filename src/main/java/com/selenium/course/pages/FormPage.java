package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public abstract class FormPage extends ContentPage {

    @FindBy(className = "pageDescription")
    @CacheLookup
    protected WebElement pageDescriptionText;

    @FindBy(name = "save")
    @CacheLookup
    protected WebElement saveBtn;

    @FindBy(name = "save_new")
    @CacheLookup
    protected WebElement saveNewBtn;

    @FindBy(name = "cancel")
    @CacheLookup
    protected WebElement cancelBtn;

    @FindBy(css = "img.rightArrowIcon")
    @CacheLookup
    protected WebElement rightArrowIcon;

    @FindBy(css = "img.leftArrowIcon")
    @CacheLookup
    protected WebElement leftArrowIcon;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public String getPageDescription() {
        return pageDescriptionText.getText();
    }

    public WebDriver setTextFieldValue(WebElement field, String fieldValue) {
        field.clear();
        field.sendKeys(fieldValue);
        return this.getDriver();
    }

    public WebDriver selectListValue(WebElement field, String fieldValue) {
        Select select = new Select(field);
        select.selectByVisibleText(fieldValue);
        return this.getDriver();
    }

    public WebDriver setMultiSelectValue(WebElement field, List<String> selectedOptions) {
        Select multiSelect = new Select(field);
        for (String selectOption : selectedOptions) {
            multiSelect.selectByVisibleText(selectOption);
        }
        return this.getDriver();
    }

    public WebDriver clickAddMultiSelection() {
        rightArrowIcon.click();
        return this.getDriver();
    }

    public WebDriver clickRemoveMultiSelection() {
        leftArrowIcon.click();
        return this.getDriver();
    }

    public WebDriver setRadioButton(WebElement field) {
        field.click();
        return this.getDriver();
    }

    public WebDriver selectLookupValue(String selectedValue) {

        String windowID = driver.getWindowHandle();
        driver.findElement(By.className("lookupIcon")).click();

        try {
            Set<String> setWindows = driver.getWindowHandles();
            LinkedList<String> listWindows = new LinkedList<String>(setWindows);
            driver.switchTo().window(listWindows.getLast());
            driver.switchTo().frame("resultsFrame");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(selectedValue)));
            driver.findElement(By.linkText(selectedValue)).click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().window(windowID);
        }
        return this.getDriver();
    }

    public TabPage clickCancelBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(cancelBtn));
        cancelBtn.click();
        return new TabPage(driver);
    }
}
