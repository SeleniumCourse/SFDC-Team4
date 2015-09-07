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

    @FindBy(id = "acc17street")
    @CacheLookup
    private WebElement billingStreet;

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

    @FindBy(id = "acc18street")
    @CacheLookup
    private WebElement shipStreet;

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

    public AccountForm setAccountTypeField(String fieldValue) {
        this.driver = selectListValue(typeField, fieldValue);
        return this;
    }

    public AccountForm setAccountIndustryField(String fieldValue) {
        this.driver = selectListValue(industryField, fieldValue);
        return this;
    }

    public AccountForm setAccountRatingField(String fieldValue) {
        this.driver = selectListValue(ratingField, fieldValue);
        return this;
    }

    public AccountForm setAccountRevenueField(String fieldValue) {
        this.driver = setTextFieldValue(revenueField, fieldValue);
        return this;
    }
    public AccountForm setAccountPhoneField(String fieldValue) {
        this.driver = setTextFieldValue(phoneField, fieldValue);
        return this;
    }

    public AccountForm setAccountFaxField(String fieldValue) {
        this.driver = setTextFieldValue(faxField, fieldValue);
        return this;
    }

    public AccountForm setAccountWebSiteField(String fieldValue) {
        this.driver = setTextFieldValue(webSiteField, fieldValue);
        return this;
    }

    public AccountForm setAccountTickerField(String fieldValue) {
        this.driver = setTextFieldValue(tickerSymbolField, fieldValue);
        return this;
    }

    public AccountForm setAccountOwnershipField(String fieldValue) {
        this.driver = selectListValue(ownershipField, fieldValue);
        return this;
    }

    public AccountForm setAccountEmployeesField(String fieldValue) {
        this.driver = setTextFieldValue(employeesField, fieldValue);
        return this;
    }

    public AccountForm setAccountSicCodeField(String fieldValue) {
        this.driver = setTextFieldValue(sicCodeField, fieldValue);
        return this;
    }

    public AccountForm setAccountBillingCityField(String fieldValue) {
        this.driver = setTextFieldValue(billingCityField, fieldValue);
        return this;
    }

    public AccountForm setAccountBillingStateField(String fieldValue) {
        this.driver = setTextFieldValue(billingStateField, fieldValue);
        return this;
    }

    public AccountForm setAccountBillingZipField(String fieldValue) {
        this.driver = setTextFieldValue(billingZipField, fieldValue);
        return this;
    }

    public AccountForm setAccountBillingCountryField(String fieldValue) {
        this.driver = setTextFieldValue(billingCountryField, fieldValue);
        return this;
    }

    public AccountForm setAccountShipCityField(String fieldValue) {
        this.driver = setTextFieldValue(shipCityField, fieldValue);
        return this;
    }


    public AccountForm setAccountShipStateField(String fieldValue) {
        this.driver = setTextFieldValue(shipStateField, fieldValue);
        return this;
    }

    public AccountForm setAccountShipZipField(String fieldValue) {
        this.driver = setTextFieldValue(shipZipField, fieldValue);
        return this;
    }

    public AccountForm setAccountShipCountryField(String fieldValue) {
        this.driver = setTextFieldValue(shipCountryField, fieldValue);
        return this;
    }
    public AccountForm setAccountShipStreetField(String fieldValue) {
        this.driver = setTextFieldValue(shipStreet, fieldValue);
        return this;
    }

    public AccountForm setAccountBillingStreetField(String fieldValue) {
        this.driver = setTextFieldValue(billingStreet, fieldValue);
        return this;
    }
}
