package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Nelson Tapia on 9/4/2015.
 */
public class ProductViewForm extends ObjectFormPage {

    @FindBy(id = "fname")
    @CacheLookup
    private WebElement viewNameText;

    @FindBy(id = "devname")
    @CacheLookup
    private WebElement viewUniqueNameText;

    public ProductViewForm(WebDriver driver) {
        super(driver);
    }

    public ProductViewForm setViewNameText(String fieldValue){
        this.driver = setTextFieldValue(viewNameText,fieldValue);
        return  this;
    }

    public ProductViewForm setViewUniqueNameText(String fieldValue){
        this.driver = setTextFieldValue(viewUniqueNameText,fieldValue);
        return  this;
    }
}

