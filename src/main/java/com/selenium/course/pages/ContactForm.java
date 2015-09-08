package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

public class ContactForm extends ObjectFormPage {
    private Select selectTitleBox;
    private Select selectLeadSourceBox;
    private Select selectLevelBox;
    private SearchWindow searchWindow;


    @FindBy(xpath = "//h1[contains(.,'Contact Edit:')]")
    @CacheLookup
    private WebElement newContactTitle;

    @FindBy(id = "name_salutationcon2")
    @CacheLookup
    private WebElement titleSelect;

    @FindBy(id = "name_firstcon2")
    @CacheLookup
    private WebElement firstName;

    @FindBy(id = "name_lastcon2")
    @CacheLookup
    private WebElement lastName;

    @FindBy(id = "con4")
    @CacheLookup
    private WebElement accountName;

    @FindBy(xpath = "//img[@alt='Account Name Lookup (New Window)']")
    @CacheLookup
    private WebElement findAccountLookup;

    @FindBy(id = "con5")
    @CacheLookup
    private WebElement title;

    @FindBy(id = "con6")
    @CacheLookup
    private WebElement department;

    @FindBy(id = "con7")
    @CacheLookup
    private WebElement birthDate;

    @FindBy(id = "con8")
    @CacheLookup
    private WebElement reportTo;

    @FindBy(id = "con9")
    @CacheLookup
    private WebElement leadSourceSelect;

    @FindBy(id = "con10")
    @CacheLookup
    private WebElement phone;

    @FindBy(id = "con13")
    @CacheLookup
    private WebElement homePhone;

    @FindBy(id = "con12")
    @CacheLookup
    private WebElement mobile;

    @FindBy(id = "con14")
    @CacheLookup
    private WebElement otherPhone;

    @FindBy(id = "con11")
    @CacheLookup
    private WebElement fax;

    @FindBy(id = "con15")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "con16")
    @CacheLookup
    private WebElement assistant;

    @FindBy(id = "con17")
    @CacheLookup
    private WebElement assistantPhone;

    @FindBy(id = "con19street")
    @CacheLookup
    private WebElement mailingStreet;

    @FindBy(id = "con19city")
    @CacheLookup
    private WebElement mailingCity;

    @FindBy(id = "con19state")
    @CacheLookup
    private WebElement mailingState;

    @FindBy(id = "con19zip")
    @CacheLookup
    private WebElement mailingZipPostal;

    @FindBy(id = "con19country")
    @CacheLookup
    private WebElement mailingCountry;

    @FindBy(id = "con18street")
    @CacheLookup
    private WebElement otherStreet;

    @FindBy(id = "con18city")
    @CacheLookup
    private WebElement otherCity;

    @FindBy(id = "con18state")
    @CacheLookup
    private WebElement otherState;

    @FindBy(id = "con18zip")
    @CacheLookup
    private WebElement otherZipPostal;

    @FindBy(id = "con18country")
    @CacheLookup
    private WebElement otherCountry;

    //@FindBy(id = "00N2400000EaNhr")
    @FindBy(xpath = "//*[text() ='Languages']/parent::td/following-sibling::td[1]/input")
    @CacheLookup
    private WebElement languages;

    //@FindBy(id = "00N2400000EaNhs")
    @FindBy(xpath = "//*[text() ='Level']/parent::td/following-sibling::td[1]//select")
    @CacheLookup
    private WebElement selectLevel;

    @FindBy(id = "con20")
    @CacheLookup
    private WebElement description;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;

    public ContactForm(WebDriver driver) {
        super(driver);

        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(newContactTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public ContactForm setContactName(String fieldValue){
        driver = setTextFieldValue(firstName,fieldValue);
        return this;
    }

    public ContactForm setLastName(String newLastName) {
        lastName.clear();
        lastName.sendKeys(newLastName);
        return this;
    }

    public ContactForm selectTitle(String title) {
        selectTitleBox = new Select(titleSelect);
        selectTitleBox.selectByVisibleText(title);
        return this;
    }

    public ContactForm setFirstName(String newFirstName) {
        this.driver = setTextFieldValue(firstName,newFirstName);
        return this;
    }

    public ContactForm setAccountName(String newAccountName) {

        String windowID = driver.getWindowHandle();
        searchWindow = clickParentLookup();

        try {
            Set<String> setWindows = driver.getWindowHandles();
            LinkedList<String> listWindows = new LinkedList<String>(setWindows);
            driver.switchTo().window(listWindows.getLast());
            driver.switchTo().frame("resultsFrame");
            driver.findElement(By.linkText(newAccountName)).click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().window(windowID);
        }
        return this;
    }
    private SearchWindow clickParentLookup() {
        findAccountLookup.click();
        return new SearchWindow(driver);
    }

    public ContactForm setTitle(String newTitle) {
        this.driver = setTextFieldValue(title, newTitle);
        return this;
    }

    public ContactForm setDepartment(String newDepartment) {
        this.driver = setTextFieldValue(department, newDepartment);
        return this;
    }

    public ContactForm selectLeadSource(String leadSource) {
        this.driver = selectListValue(leadSourceSelect, leadSource);
        return this;
    }

    public ContactForm setPhone(String newPhone) {
        this.driver = setTextFieldValue(phone,newPhone);
        return this;
    }

    public ContactForm setHomePhone(String newHomePhone) {
        this.driver = setTextFieldValue(homePhone,newHomePhone);
        return this;
    }

    public ContactForm setMobile(String newMobile) {
        this.driver = setTextFieldValue(mobile,newMobile);
        return this;
    }

    public ContactForm setOtherPhone(String newOtherPhone) {
        this.driver = setTextFieldValue(otherPhone,newOtherPhone);
        return this;
    }

    public ContactForm setFax(String newFax) {
        this.driver = setTextFieldValue(fax,newFax);
        return this;
    }

    public ContactForm setEmail(String newEmail) {
        this.driver = setTextFieldValue(email,newEmail);
        return this;
    }

    public ContactForm setAssistant(String newAssistant) {
        this.driver = setTextFieldValue(assistant,newAssistant);
        return this;
    }

    public ContactForm setAssistantPhone(String newAssistantPhone) {
        this.driver = setTextFieldValue(assistantPhone,newAssistantPhone);
        return this;
    }

    public ContactForm setMailingStreet(String newMailingStreet) {
        mailingStreet.clear();
        mailingStreet.sendKeys(newMailingStreet);
        return this;
    }

    public ContactForm setMailingCity(String newMailingCity) {
        this.driver = setTextFieldValue(mailingCity,newMailingCity);
        return this;
    }

    public ContactForm setMailingState(String newMailingState) {
        this.driver = setTextFieldValue(mailingState,newMailingState);
        return this;
    }

    public ContactForm setMailingZipPostal(String newMailingZipPostal) {
        this.driver = setTextFieldValue(mailingZipPostal,newMailingZipPostal);
        return this;
    }

    public ContactForm setMailingCountry(String newMailingCountry) {
        this.driver = setTextFieldValue(mailingCountry,newMailingCountry);
        return this;
    }

    public ContactForm setOtherStreet(String newOtherStreet) {
        this.driver = setTextFieldValue(otherStreet,newOtherStreet);
        return this;
    }

    public ContactForm setOtherCity(String newOtherCity) {
        this.driver = setTextFieldValue(otherCity,newOtherCity);
        return this;
    }

    public ContactForm setOtherState(String newOtherState) {
        this.driver = setTextFieldValue(otherState,newOtherState);
        return this;
    }

    public ContactForm setOtherZipPostal(String newOtherZipPostal) {
        this.driver = setTextFieldValue(otherZipPostal,newOtherZipPostal);
        return this;
    }

    public ContactForm setOtherCountry(String newOtherCountry) {
        this.driver = setTextFieldValue(otherCountry,newOtherCountry);
        return this;
    }

    public ContactForm setLanguages(String newLanguages) {
        this.driver = setTextFieldValue(languages,newLanguages);
        return this;
    }

    public ContactForm selectLevel(String newLevel) {
        this.driver = selectListValue(selectLevel, newLevel);
        return this;
    }

    public ContactForm setDescription(String newDescription) {
        this.driver = setTextFieldValue(description,newDescription);
        return this;
    }
}

