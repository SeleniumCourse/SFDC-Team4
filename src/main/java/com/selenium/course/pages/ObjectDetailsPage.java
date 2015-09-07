package com.selenium.course.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Rina Espinoza on 8/29/2015.
 */
public class ObjectDetailsPage extends DetailsPage {

    @FindBy(className = "topName")
    @CacheLookup
    protected WebElement objectNameText;

    @FindBy(className = "pageDescription")
    @CacheLookup
    protected WebElement pageDescriptionText;

    @FindBy(name = "edit")
    @CacheLookup
    protected WebElement editBtn;

    @FindBy(name = "delete")
    @CacheLookup
    protected WebElement deleteAccountBtn;

    @FindBy(name = "del")
    @CacheLookup
    protected WebElement deleteOppBtn;

    public ObjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getObjectName() {
        return objectNameText.getText();
    }

    public String getPageDescription() {
        return pageDescriptionText.getText();
    }

    public ObjectFormPage clickEditBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(editBtn));
        editBtn.click();
        return new ObjectFormPage(driver);
    }

    public TabPage clickDeleteBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(deleteAccountBtn));
        deleteAccountBtn.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } finally {

            return new TabPage(driver);
        }
    }

    public TabPage clickDeleteOppBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(deleteOppBtn));
        deleteOppBtn.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } finally {

            return new TabPage(driver);
        }
    }

}
