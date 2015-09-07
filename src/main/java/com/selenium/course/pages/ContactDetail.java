package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

public class ContactDetail extends ObjectDetailsPage{

    @FindBy(xpath = "//h2[contains(.,'Contact Detail')]")
    @CacheLookup
    WebElement contactDetailLabel;

    @FindBy(id = "con2_ileinner")
    @CacheLookup
    WebElement contactName;

    @FindBy(id = "con4_ileinner")
    @CacheLookup
    WebElement accountName;

    @FindBy(id = "con5_ileinner")
    @CacheLookup
    WebElement titleName;

    @FindBy(id = "con6_ileinner")
    @CacheLookup
    WebElement departamentName;

    @FindBy(id = "con9_ileinner")
    @CacheLookup
    WebElement leadSourceName;

    @FindBy(id = "con10_ileinner")
    @CacheLookup
    WebElement phoneNumber;

    @FindBy(id = "con13_ileinner")
    @CacheLookup
    WebElement homephoneNumber;

    @FindBy(id = "con12_ileinner")
    @CacheLookup
    WebElement mobileNumber;

    @FindBy(id = "con14_ileinner")
    @CacheLookup
    WebElement otherphoneNumber;

    @FindBy(id = "con11_ileinner")
    @CacheLookup
    WebElement faxNumber;


    @FindBy(id = "con15_ileinner")
    @CacheLookup
    WebElement emailName;

    @FindBy(id = "con16_ileinner")
    @CacheLookup
    WebElement assistanName;

    @FindBy(id = "con17_ileinner")
    @CacheLookup
    WebElement assistanPhone;

    @FindBy(id = "00N2400000EaNhr_ileinner")
    @CacheLookup
    WebElement languageName;


    @FindBy(id = "00N2400000EaNhs_ileinner")
    @CacheLookup
    WebElement levelName;

    @FindBy(id = "con20_ileinner")
    @CacheLookup
    WebElement descriptionName;


    @FindBy(name = "del")
    @CacheLookup
    WebElement delBtn;

    @FindBy(name = "edit")
    @CacheLookup
    WebElement editBtn;

    public ContactDetail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(contactDetailLabel));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public String getContactName() {
        String fullName = null;
        fullName = contactName.getText().trim();
        return fullName;
    }


    public String getAccountName() {
        String fullName = null;
        fullName = accountName.getText().trim();
        return fullName;
    }

    public String getTitleName() {
        String fullName = null;
        fullName = titleName.getText().trim();
        return fullName;
    }

    public String getDepartamentName() {
        String fullName = null;
        fullName = departamentName.getText().trim();
        return fullName;
    }

    public String getLeadSourceName() {
        String fullName = null;
        fullName = leadSourceName.getText().trim();
        return fullName;
    }

    public String getPhoneNumber() {
        String fullName = null;
        fullName = phoneNumber.getText().trim();
        return fullName;
    }

    public String getHomePhoneNumber() {
        String fullName = null;
        fullName = homephoneNumber.getText().trim();
        return fullName;
    }

    public String getMobileNumber() {
        String fullName = null;
        fullName = mobileNumber.getText().trim();
        return fullName;
    }

    public String getOtherPhoneNumber() {
        String fullName = null;
        fullName = otherphoneNumber.getText().trim();
        return fullName;
    }

    public String getFaxNumber() {
        String fullName = null;
        fullName = faxNumber.getText().trim();
        return fullName;
    }

    public String getEmailName() {
        String fullName = null;
        fullName = emailName.getText().trim();
        return fullName;
    }

    public String getAssistantName() {
        String fullName = null;
        fullName = assistanName.getText().trim();
        return fullName;
    }

    public String getAssistantPhone() {
        String fullName = null;
        fullName = assistanPhone.getText().trim();
        return fullName;
    }

    public String getLanguage() {
        String fullName = null;
        fullName = languageName.getText().trim();
        return fullName;
    }

    public String getLevel() {
        String fullName = null;
        fullName = levelName.getText().trim();
        return fullName;
    }

    public String getDescription() {
        String fullName = null;
        fullName = descriptionName.getText().trim();
        return fullName;
    }

}

