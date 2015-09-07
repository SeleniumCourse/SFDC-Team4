package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Elmer A on 9/7/2015.
 */
public class LeadViewForm extends ViewFormPage
{
    @FindBy(id = "fname")
    @CacheLookup
    private WebElement viewNameTextField;

    @FindBy(id = "devname")
    @CacheLookup
    private WebElement viewUniqueNameTextField;

    public LeadViewForm(WebDriver driver)
    {
        super(driver);
    }

    public LeadViewForm setViewNameText(String fieldValue) {
        this.driver = setTextFieldValue(viewNameTextField, fieldValue);
        return this;
    }

    public LeadViewForm setViewUniqueNameText(String fieldValue) {
        this.driver = setTextFieldValue(viewUniqueNameTextField, fieldValue);
        return this;
    }
}
