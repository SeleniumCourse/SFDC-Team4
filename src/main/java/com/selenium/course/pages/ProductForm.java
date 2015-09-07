package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by AutomationUser on 9/7/2015.
 */
public class ProductForm extends ObjectFormPage
{
    @FindBy(id = "Name")
    @CacheLookup
    private WebElement productNameTextField;

    @FindBy(id = "ProductCode")
    @CacheLookup
    private WebElement productCodeTextField;

    @FindBy(id = "Description")
    @CacheLookup
    private WebElement productDescriptionTextField;

    @FindBy(id = "IsActive")
    @CacheLookup
    private WebElement activeCheckBoxButton;

    @FindBy(id = "Family")
    @CacheLookup
    private WebElement productFamilyDropDown;

    public ProductForm(WebDriver driver)
    {
        super(driver);
    }

    public ProductForm setProductName(String name)
    {
        this.driver = setTextFieldValue(productNameTextField, name);
        return this;
    }

    public ProductForm setProductCode(String code)
    {
        this.driver = setTextFieldValue(productCodeTextField, code);
        return this;
    }

    public ProductForm setDescription(String description)
    {
        this.driver = setTextFieldValue(productDescriptionTextField, description);
        return this;
    }

    public ProductForm CheckActive()
    {
        activeCheckBoxButton.clear();
        activeCheckBoxButton.click();
        return this;
    }

    public ProductForm selectFamily(String value)
    {
        this.driver = selectListValue(productFamilyDropDown, value);
        return this;
    }
}
