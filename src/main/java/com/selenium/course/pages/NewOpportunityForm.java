package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import com.selenium.course.framework.WebDriverManager;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by Gretta Rocha on 6/27/2015.
 */
public class NewOpportunityForm extends CommonForm{

    private WebDriver driver;
    private WebDriverWait wait;
    private Select selectBox;

    @FindBy(xpath = "//h1[contains(.,'Opportunity Edit:')]")
    @CacheLookup
    WebElement newOpportunityTitle;

    @FindBy(id = "opp3")
    @CacheLookup
    WebElement nameField;

    @FindBy(id = "opp2")
    @CacheLookup
    WebElement isPrivate;

    @FindBy(id = "opp5")
    @CacheLookup
    WebElement type;

    @FindBy(id = "opp6")
    @CacheLookup
    WebElement leadSource;

    @FindBy(id = "opp7")
    @CacheLookup
    WebElement amount;

    @FindBy(id = "opp9")
    @CacheLookup
    WebElement closeDate;

    @FindBy(id = "opp10")
    @CacheLookup
    WebElement nextStep;

    @FindBy(xpath ="//a[contains(@tabindex,'7')]")
    @CacheLookup
    WebElement currentDate;

    @FindBy(id = "opp11")
    @CacheLookup
    WebElement stage;

    public NewOpportunityForm() {
        wait = WebDriverManager.getInstance().getWait();
        driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(newOpportunityTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    //methods to create  Opportunity
    public NewOpportunityForm setName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public NewOpportunityForm setPrivate(){
        isPrivate.click();
        return this;
    }

    public NewOpportunityForm setType (String typeOption){
        selectBox = new Select(type);
        selectBox.selectByVisibleText(typeOption);
        return this;
    }

    public NewOpportunityForm setLeadSource (String leadSourceOption) {
        selectBox = new Select(leadSource);
        selectBox.selectByVisibleText(leadSourceOption);
        return this;
    }

    public NewOpportunityForm setAmount(String amountValue) {
        amount.clear();
        amount.sendKeys(amountValue);
        return this;
    }

    public NewOpportunityForm setNextStep(String stepValue) {
        nextStep.clear();
        nextStep.sendKeys(stepValue);
        return this;
    }

    public NewOpportunityForm setCloseDate(){
        currentDate.click();
        return this;
    }

    public NewOpportunityForm setStage(String stageOption){
        selectBox = new Select(stage);
        selectBox.selectByVisibleText(stageOption);
        return this;

    }

    public OpportunityDetail clickSaveOpportunity() {
        saveBtn.click();
        return new OpportunityDetail();
    }
}