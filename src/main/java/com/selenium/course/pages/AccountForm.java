package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.selenium.course.common.Globals.*;

public class AccountForm extends ObjectFormPage {

    @FindBy(xpath = "//h1[contains(.,'Account Edit:')]")
    @CacheLookup
    private WebElement newAccountTitle;

    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement accountNameField;

    @FindBy(xpath = "//img[@title='Parent Account Lookup (New Window)']")
    @CacheLookup
    private WebElement findAccountLookup;

    @FindBy(id = "acc5")
    @CacheLookup
    private WebElement accountNumberField;

    @FindBy(id = "acc23")
    @CacheLookup
    private WebElement accountSiteField;

    @FindBy(id = "acc6")
    @CacheLookup
    private WebElement typeField;

    @FindBy(id = "acc7")
    @CacheLookup
    private WebElement industryField;

    @FindBy(id = "acc8")
    @CacheLookup
    private WebElement revenueField;

    @FindBy(id = "acc9")
    @CacheLookup
    private WebElement ratingField;

    @FindBy(id = "acc10")
    @CacheLookup
    private WebElement phoneField;

    @FindBy(id = "acc11")
    @CacheLookup
    private WebElement faxField;

    @FindBy(id = "acc12")
    @CacheLookup
    private WebElement webSiteField;

    @FindBy(id = "acc13")
    @CacheLookup
    private WebElement tickerSymbolField;

    @FindBy(id = "acc14")
    @CacheLookup
    private WebElement ownershipField;

    @FindBy(id = "acc15")
    @CacheLookup
    private WebElement employeesField;

    @FindBy(id = "acc16")
    @CacheLookup
    private WebElement sicCodeField;

    @FindBy(id = "acc17city")
    @CacheLookup
    private WebElement billingCityField;

    @FindBy(id = "acc17state")
    @CacheLookup
    private WebElement billingStateField;

    @FindBy(id = "acc17zip")
    @CacheLookup
    private WebElement billingZipField;

    @FindBy(id = "acc17country")
    @CacheLookup
    private WebElement billingCountryField;

    @FindBy(id = "acc18city")
    @CacheLookup
    private WebElement shipCityField;

    @FindBy(id = "acc18state")
    @CacheLookup
    private WebElement shipStateField;

    @FindBy(id = "acc18zip")
    @CacheLookup
    private WebElement shipZipField;

    @FindBy(id = "acc18country")
    @CacheLookup
    private WebElement shipCountryField;

    public AccountForm(WebDriver driver) {
        super(driver);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(newAccountTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public AccountForm setAccountNameText(String fieldValue) {
        this.driver = setTextFieldValue(accountNameField, fieldValue);
        return this;
    }

    public AccountForm setAccountNumberField(String fieldValue) {
        this.driver = setTextFieldValue(accountNumberField, fieldValue);
        return this;
    }

    public AccountForm setAccountSiteField(String fieldValue) {
        this.driver = setTextFieldValue(accountSiteField, fieldValue);
        return this;
    }


}
