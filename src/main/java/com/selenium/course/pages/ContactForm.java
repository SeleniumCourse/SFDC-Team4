package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.course.framework.WebDriverManager;

/**
 * Created by reyna ulaque on 13/06/2015.
 */
public class ContactForm {
    private WebDriver driver;
    private WebDriverWait wait;
    private Select selectTitleBox;
    private Select selectLeadSourceBox;
    private Select selectLevelBox;
    private SearchWindow searchWindow;


    @FindBy(xpath = "//h2[contains(.,' New Contact')]")
    @CacheLookup
    WebElement newContactTitle;

    @FindBy(id = "name_salutationcon2")
    @CacheLookup
    WebElement titleSelect;

    @FindBy(id = "name_firstcon2")
    @CacheLookup
    WebElement firstName;

    @FindBy(id = "name_lastcon2")
    @CacheLookup
    WebElement lastName;

    @FindBy(id = "con4")
    @CacheLookup
    WebElement accountName;

    @FindBy(xpath = "//img[@alt='Account Name Lookup (New Window)']")
    @CacheLookup
    WebElement findAccountLookup;

    @FindBy(id = "con5")
    @CacheLookup
    WebElement title;

    @FindBy(id = "con6")
    @CacheLookup
    WebElement department;

    @FindBy(id = "con7")
    @CacheLookup
    WebElement birthDate;

    @FindBy(id = "con8")
    @CacheLookup
    WebElement reportTo;

    @FindBy(id = "con9")
    @CacheLookup
    WebElement leadSourceSelect;

    @FindBy(id = "con10")
    @CacheLookup
    WebElement phone;

    @FindBy(id = "con13")
    @CacheLookup
    WebElement homePhone;

    @FindBy(id = "con12")
    @CacheLookup
    WebElement mobile;

    @FindBy(id = "con14")
    @CacheLookup
    WebElement otherPhone;

    @FindBy(id = "con11")
    @CacheLookup
    WebElement fax;

    @FindBy(id = "con15")
    @CacheLookup
    WebElement email;

    @FindBy(id = "con16")
    @CacheLookup
    WebElement assistant;

    @FindBy(id = "con17")
    @CacheLookup
    WebElement assistantPhone;
    //Address information
    @FindBy(id = "con19street")
    @CacheLookup
    WebElement mailingStreet;

    @FindBy(id = "con19city")
    @CacheLookup
    WebElement mailingCity;

    @FindBy(id = "con19state")
    @CacheLookup
    WebElement mailingState;

    @FindBy(id = "con19zip")
    @CacheLookup
    WebElement mailingZipPostal;

    @FindBy(id = "con19country")
    @CacheLookup
    WebElement mailingCountry;

    @FindBy(id = "con18street")
    @CacheLookup
    WebElement otherStreet;

    @FindBy(id = "con18city")
    @CacheLookup
    WebElement otherCity;

    @FindBy(id = "con18state")
    @CacheLookup
    WebElement otherState;

    @FindBy(id = "con18zip")
    @CacheLookup
    WebElement otherZipPostal;

    @FindBy(id = "con18country")
    @CacheLookup
    WebElement otherCountry;

    @FindBy(id = "00N1a000005YAYl")
    @CacheLookup
    WebElement languages;

    @FindBy(id = "00N1a000005YAYm")
    @CacheLookup
    WebElement selectLevel;


    @FindBy(id = "con20")
    @CacheLookup
    WebElement description;

    @FindBy(name = "save")
    @CacheLookup
    WebElement saveBtn;


    public ContactForm() {
        //this.driver = driver;
        wait = WebDriverManager.getInstance().getWait();
        driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(3, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(lastName));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
    }

    public ContactForm selectTitle(String title) {
        selectTitleBox = new Select(titleSelect);
        selectTitleBox.selectByVisibleText(title);
        return this;
    }

    public ContactForm setFirstName(String newFirstName) {
        firstName.clear();
        firstName.sendKeys(newFirstName);
        return this;
    }

    public ContactForm setLastName(String newLastName) {
        lastName.clear();
        lastName.sendKeys(newLastName);
        return this;
    }


    public void setAccountName(String newAccountName) {
        searchWindow = clickParentLookup();
        searchWindow.findObject(newAccountName);
    }

    private SearchWindow clickParentLookup() {
        findAccountLookup.click();
        return new SearchWindow(driver);
    }

    public ContactForm setTitle(String newTitle) {
        title.clear();
        title.sendKeys(newTitle);
        return this;
    }

    public ContactForm setDepartment(String newDepartment) {
        department.clear();
        department.sendKeys(newDepartment);
        return this;
    }

    public ContactForm selectLeadSource(String leadSource) {
        selectLeadSourceBox = new Select(leadSourceSelect);
        selectLeadSourceBox.selectByVisibleText(leadSource);
        return this;
    }

    public ContactForm setPhone(String newPhone) {
        phone.clear();
        phone.sendKeys(newPhone);
        return this;
    }

    public ContactForm setHomePhone(String newHomePhone) {
        homePhone.clear();
        homePhone.sendKeys(newHomePhone);
        return this;
    }

    public ContactForm setMobile(String newMobile) {
        mobile.clear();
        mobile.sendKeys(newMobile);
        return this;
    }

    public ContactForm setOtherPhone(String newOtherPhone) {
        otherPhone.clear();
        otherPhone.sendKeys(newOtherPhone);
        return this;
    }

    public ContactForm setFax(String newFax) {
        fax.clear();
        fax.sendKeys(newFax);
        return this;
    }

    public ContactForm setEmail(String newEmail) {
        email.clear();
        email.sendKeys(newEmail);
        return this;
    }

    public ContactForm setAssistant(String newAssistant) {
        assistant.clear();
        assistant.sendKeys(newAssistant);
        return this;
    }

    public ContactForm setAssistantPhone(String newAssistantPhone) {
        assistantPhone.clear();
        assistantPhone.sendKeys(newAssistantPhone);
        return this;
    }

    //Address information
    public ContactForm setMailingStreet(String newMailingStreet) {
        mailingStreet.clear();
        mailingStreet.sendKeys(newMailingStreet);
        return this;
    }

    public ContactForm setMailingCity(String newMailingCity) {
        mailingCity.clear();
        mailingCity.sendKeys(newMailingCity);
        return this;
    }

    public ContactForm setMailingState(String newMailingState) {
        mailingState.clear();
        mailingState.sendKeys(newMailingState);
        return this;
    }

    public ContactForm setMailingZipPostal(String newMailingZipPostal) {
        mailingZipPostal.clear();
        mailingZipPostal.sendKeys(newMailingZipPostal);
        return this;
    }

    public ContactForm setMailingCountry(String newMailingCountry) {
        mailingCountry.clear();
        mailingCountry.sendKeys(newMailingCountry);
        return this;
    }

    public ContactForm setOtherStreet(String newOtherStreet) {
        otherStreet.clear();
        otherStreet.sendKeys(newOtherStreet);
        return this;
    }

    public ContactForm setOtherCity(String newOtherCity) {
        otherCity.clear();
        otherCity.sendKeys(newOtherCity);
        return this;
    }

    public ContactForm setOtherState(String newOtherState) {
        otherState.clear();
        otherState.sendKeys(newOtherState);
        return this;
    }

    public ContactForm setOtherZipPostal(String newOtherZipPostal) {
        otherZipPostal.clear();
        otherZipPostal.sendKeys(newOtherZipPostal);
        return this;
    }

    public ContactForm setOtherCountry(String newOtherCountry) {
        otherCountry.clear();
        otherCountry.sendKeys(newOtherCountry);
        return this;
    }

    public ContactForm setLanguages(String newLanguages) {
        languages.clear();
        languages.sendKeys(newLanguages);
        return this;
    }

    public ContactForm selectLevel(String newLevel) {
        selectLevelBox = new Select(selectLevel);
        selectLevelBox.selectByVisibleText(newLevel);
        return this;
    }

    public ContactForm setDescription(String newDescription) {
        description.clear();
        description.sendKeys(newDescription);
        return this;
    }

    public ContactDetail clickSaveBtn() {
        saveBtn.click();
        return new ContactDetail();
    }
}

