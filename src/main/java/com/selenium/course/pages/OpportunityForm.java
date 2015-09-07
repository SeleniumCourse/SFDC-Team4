package com.selenium.course.pages;


import com.selenium.course.framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

/**
 * Created for Joel Rodriguez
 */

public class OpportunityForm extends ObjectFormPage {

    @FindBy(xpath = "//h2[contains(.,'Opportunity Edit')]")
    @CacheLookup
    private WebElement editOpportunityTitle;

    @FindBy(id = "opp3")
    @CacheLookup
    private WebElement opportunityName;

    @FindBy(id = "opp9")
    @CacheLookup
    private WebElement opportunityCloseDate;

    @FindBy(id = "opp11")
    @CacheLookup
    private WebElement opportunityStage;

    @FindBy(id = "opp5")
    @CacheLookup
    private WebElement opportunityType;

    @FindBy(id = "opp6")
    @CacheLookup
    private WebElement opportunityLeadSource;

    @FindBy(id = "opp7")
    @CacheLookup
    private WebElement opportunityAmount;


    public OpportunityForm(WebDriver driver) {
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

    public OpportunityForm setOpportunityName(String name) {
        opportunityName.clear();
        opportunityName.sendKeys(name);
        return this;
    }

    public OpportunityForm setOpportunityCloseDate(String date) {
        opportunityCloseDate.clear();
        opportunityCloseDate.sendKeys(date);
        return this;
    }

    public OpportunityForm setOpportunityAmount(String amount) {
        opportunityAmount.clear();
        opportunityAmount.sendKeys(amount);
        return this;
    }

    public OpportunityForm setOpportunityStage(String stage) {
        new Select(opportunityStage).selectByVisibleText(stage);
        return this;
    }

    public OpportunityForm setOpportunityType(String type) {
        new Select(opportunityType).selectByVisibleText(type);
        return this;
    }

    public OpportunityForm setOpportunityLeadSource(String leadSource) {
        new Select(opportunityLeadSource).selectByVisibleText(leadSource);
        return this;
    }

    public OpportunityDetails clickSaveOpportunity() {
        saveBtn.click();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new OpportunityDetails(driver);
    }
}