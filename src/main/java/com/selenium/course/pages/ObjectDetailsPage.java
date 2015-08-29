package com.selenium.course.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Rina Espinoza on 8/29/2015.
 */
public class ObjectDetailsPage extends DetailsPage {

    @FindBy(className = "topName")
    @CacheLookup
    private WebElement objectNameText;

    @FindBy(className = "pageDescription")
    @CacheLookup
    private WebElement pageDescriptionText;

    @FindBy(name = "edit")
    @CacheLookup
    public WebElement editBtn;

    @FindBy(name = "delete")
    @CacheLookup
    public WebElement deleteAccountBtn;

    @FindBy(name = "del")
    @CacheLookup
    public WebElement deleteOppBtn;

    public ObjectDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
