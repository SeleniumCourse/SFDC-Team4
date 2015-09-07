package com.selenium.course.pages;


import com.selenium.course.framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

/**
 * Created for Joel Rodriguez
 */

public class OpportunityMainForm extends ObjectFormPage {

    @FindBy(xpath = "//h2[contains(.,'Opportunity Edit')]")
    @CacheLookup
    WebElement editOpportunityTitle;

    @FindBy(id = "opp3")
    @CacheLookup
    WebElement opportunityName;

    @FindBy(id = "opp9")
    @CacheLookup
    WebElement opportunityCloseDate;

    @FindBy(id = "opp11")
    @CacheLookup
    WebElement opportunityStage;

    @FindBy(id = "opp5")
    @CacheLookup
    WebElement opportunityType;

    @FindBy(id = "opp6")
    @CacheLookup
    WebElement opportunityLeadSource;

    @FindBy(id = "opp7")
    @CacheLookup
    WebElement opportunityAmount;


    public OpportunityMainForm(WebDriver driver) {
        super(driver);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(editOpportunityTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public OpportunityMainForm setOpportunityName(String name) {
        opportunityName.clear();
        opportunityName.sendKeys(name);
        return this;
    }

    public OpportunityMainForm setOpportunityCloseDate(String date) {
        opportunityCloseDate.clear();
        opportunityCloseDate.sendKeys(date);
        return this;
    }

    public OpportunityMainForm setOpportunityAmount(String amount) {
        opportunityAmount.clear();
        opportunityAmount.sendKeys(amount);
        return this;
    }

    public OpportunityMainForm setOpportunityStage(String stage) {
        new Select(opportunityStage).selectByVisibleText(stage);
        return this;
    }

    public OpportunityMainForm setOpportunityType(String type) {
        new Select(opportunityType).selectByVisibleText(type);
        return this;
    }

    public OpportunityMainForm setOpportunityLeadSource(String leadSource) {
        new Select(opportunityLeadSource).selectByVisibleText(leadSource);
        return this;
    }

    public OpportunityDetailsForm clickSaveOpportunity() {
        saveBtn.click();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new OpportunityDetailsForm(driver);
    }


}

