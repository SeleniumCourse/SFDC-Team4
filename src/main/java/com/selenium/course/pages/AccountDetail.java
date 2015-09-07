package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.selenium.course.common.Globals.*;

public class AccountDetail extends ObjectDetailsPage {

    @FindBy(xpath = "//h2[contains(.,'Account Detail')]")
    @CacheLookup
    private WebElement accountDetailLabel;

    @FindBy(id = "acc2_ileinner")
    @CacheLookup
    private WebElement accountNameField;

    @FindBy(id = "acc5_ileinner")
    @CacheLookup
    private WebElement accountNumberField;

    @FindBy(id = "acc23_ileinner")
    @CacheLookup
    private WebElement accountSiteField;

    @FindBy(id = "acc6_ileinner")
    @CacheLookup
    private WebElement typeField;

    @FindBy(id = "acc7_ileinner")
    @CacheLookup
    private WebElement industryField;

    @FindBy(id = "acc8_ileinner")
    @CacheLookup
    private WebElement revenueField;

    @FindBy(id = "acc9_ileinner")
    @CacheLookup
    private WebElement ratingField;

    @FindBy(id = "acc10_ileinner")
    @CacheLookup
    private WebElement phoneField;

    @FindBy(id = "acc11_ileinner")
    @CacheLookup
    private WebElement faxField;

    @FindBy(id = "acc12_ileinner")
    @CacheLookup
    private WebElement webSiteField;

    @FindBy(id = "acc13_ileinner")
    @CacheLookup
    private WebElement tickerSymbolField;

    @FindBy(id = "acc14_ileinner")
    @CacheLookup
    private WebElement ownershipField;

    @FindBy(id = "acc15_ileinner")
    @CacheLookup
    private WebElement employeesField;

    @FindBy(id = "acc16_ileinner")
    @CacheLookup
    private WebElement sicCodeField;

    @FindBy(id = "acc17_ileinner")
    @CacheLookup
    private WebElement billing;

    @FindBy(id = "acc18_ileinner")
    @CacheLookup
    private WebElement shipping;

    public AccountDetail(WebDriver driver) {
        super(driver);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(accountDetailLabel));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public String getAccountNameField() {
        return accountNameField.getText();
    }

    public String getAccountNumberField() {
        return accountNumberField.getText();
    }

    public String getAccountSiteField() {
        return accountSiteField.getText();
    }

    public String getTypeField() {
        return typeField.getText();
    }

    public String getIndustryField() {
        return industryField.getText();
    }

    public String getRevenueField() {
        return revenueField.getText();
    }

    public String getRatingField() {
        return ratingField.getText();
    }

    public String getPhoneField() {
        return phoneField.getText();
    }

    public String getFaxField() {
        return faxField.getText();
    }

    public String getWebSiteField() {
        return webSiteField.getText();
    }

    public String getTickerSymbolField() {
        return tickerSymbolField.getText();
    }

    public String getOwnershipField() {
        return ownershipField.getText();
    }

    public String getEmployeesField() {
        return employeesField.getText();
    }

    public String getSicCodeField() {
        return sicCodeField.getText();
    }

    public String getBilling() {
        return billing.getText();
    }

    public String getShipping() {
        return shipping.getText();
    }


}
