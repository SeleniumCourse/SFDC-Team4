package com.selenium.course.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Rina Espinoza on 8/29/2015.
 */
public class ViewDetailsPage extends DetailsPage {

    @FindBy(xpath = "//select[@class='title']")
    @CacheLookup
    private WebElement ViewNameText;

    @FindBy(linkText = "Edit")
    @CacheLookup
    public WebElement editLink;

    @FindBy(linkText = "Delete")
    @CacheLookup
    public WebElement deleteLink;

    public ViewDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getViewName() {
        Select select = new Select(ViewNameText);
        return select.getFirstSelectedOption().getText();
    }


    public ViewFormPage clickEditViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(editLink));
        editLink.click();
        return new ViewFormPage(driver);
    }

    public TabPage clickDeleteViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(deleteLink));
        deleteLink.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } finally {

            return new TabPage(driver);
        }
    }
}
