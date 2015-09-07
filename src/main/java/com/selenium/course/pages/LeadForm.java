package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Elmer Alvarado on 9/6/2015.
 */
public class LeadForm extends ObjectFormPage
{
    @FindBy(id="name_firstlea2")
    @CacheLookup
    private WebElement firstNameTextField;

    @FindBy(id="name_lastlea2")
    @CacheLookup
    private WebElement lastNameTextField;

    @FindBy(id="lea3")
    @CacheLookup
    private WebElement companyTextField;

    @FindBy(id="lea4")
    @CacheLookup
    private WebElement titleTextField;

    @FindBy(id="lea5")
    @CacheLookup
    private WebElement leadSourceDropDown;

    @FindBy(xpath = "//img[@title='Campaign Lookup (New Window)']")
    @CacheLookup
    public WebElement findCampainLookupButton;

    public LeadForm(WebDriver driver)
    {
        super(driver);
    }

    public LeadForm setFirstName(String value)
    {
        this.driver = setTextFieldValue(firstNameTextField, value);
        return this;
    }

    public LeadForm setLastName(String value)
    {
        this.driver = setTextFieldValue(lastNameTextField, value);
        return this;
    }

    public LeadForm setCompany(String value)
    {
        this.driver = setTextFieldValue(companyTextField, value);
        return this;
    }

    public LeadForm setTitle(String value)
    {
        this.driver = setTextFieldValue(titleTextField, value);
        return this;
    }

    public LeadForm selectLeadSource(String value)
    {
        this.driver = selectListValue(leadSourceDropDown, value);
        return this;
    }
}
