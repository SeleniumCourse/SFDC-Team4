package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Rina Espinoza on 8/30/2015.
 */
public class AccountViewForm extends ViewFormPage {
    @FindBy(id = "fname")
    @CacheLookup
    private WebElement viewNameText;

    @FindBy(id = "devname")
    @CacheLookup
    private WebElement viewUniqueNameText;

    public AccountViewForm(WebDriver driver) {
        super(driver);
    }

    public AccountViewForm setViewNameText(String fieldValue) {
        this.driver = setTextFieldValue(viewNameText, fieldValue);
        return this;
    }

    public AccountViewForm setViewUniqueNameText(String fieldValue) {
        this.driver = setTextFieldValue(viewUniqueNameText, fieldValue);
        return this;
    }

}
