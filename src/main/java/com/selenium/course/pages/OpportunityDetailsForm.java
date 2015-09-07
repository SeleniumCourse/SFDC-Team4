package com.selenium.course.pages;

import com.selenium.course.framework.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

/**
 * Created for Joel Rodriguez
 */

public class OpportunityDetailsForm extends ObjectFormPage {


    @FindBy(xpath = "//h1[contains(.,'Opportunity:')]")
    @CacheLookup
    private WebElement opportunityDetailTable;

    @FindBy(id = "opp2_ileinner")
    @CacheLookup
    private WebElement opportunityPrivate;

    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    private WebElement opportunityName;

    @FindBy(id = "opp5_ileinner")
    @CacheLookup
    private WebElement opportunityType;

    @FindBy(id = "opp6_ileinner")
    @CacheLookup
    private WebElement opportunityLeadSource;

    @FindBy(id = "opp7_ileinner")
    @CacheLookup
    private WebElement opportunityAmount;

    @FindBy(id = "opp10_ileinner")
    @CacheLookup
    private WebElement opportunityStep;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    private WebElement opportunityStage;

    @FindBy(name = "del")
    @CacheLookup
    private WebElement deleteBtn;

    @FindBy(name = "edit")
    @CacheLookup
    private WebElement editBtn;

    public OpportunityDetailsForm(WebDriver driver) {
        super(driver);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(opportunityDetailTable));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public boolean verifyNewOpportunity(String name) {
        return this.opportunityName.getText().contains(name);
    }

    public TabPage deleteOpportunity() {
        deleteBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new TabPage(driver);
    }

    public OpportunityMainForm editOpportunity() {
        editBtn.click();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new OpportunityMainForm(driver);
    }
}
