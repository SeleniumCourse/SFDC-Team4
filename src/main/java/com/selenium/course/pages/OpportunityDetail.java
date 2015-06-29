package com.selenium.course.pages;

import com.selenium.course.framework.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

import java.util.concurrent.TimeUnit;


public class OpportunityDetail {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1[contains(.,'Opportunity:')]")
    @CacheLookup
    WebElement opportunityDetailTable;

    @FindBy(id = "opp2_ileinner")
    @CacheLookup
    WebElement opportunityPrivate;

    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    WebElement opportunityName;

    @FindBy(id = "opp5_ileinner")
    @CacheLookup
    WebElement opportunityType;

    @FindBy(id = "opp6_ileinner")
    @CacheLookup
    WebElement opportunityLeadSource;

    @FindBy(id = "opp7_ileinner")
    @CacheLookup
    WebElement opportunityAmount;

    @FindBy(id = "opp10_ileinner")
    @CacheLookup
    WebElement opportunityStep;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    WebElement opportunityStage;

    @FindBy(name = "del")
    @CacheLookup
    WebElement deleteBtn;

    @FindBy(name = "edit")
    @CacheLookup
    WebElement editBtn;

    public OpportunityDetail() {
        wait = DriverManager.getInstance().getWait();
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(opportunityDetailTable));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public OpportunitiesPage deleteOpportunity() {
        deleteBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new OpportunitiesPage();
    }

    public OpportunityEdit clickEdit(){
        editBtn.click();
        return new OpportunityEdit();
    }

    public boolean verifyNewOpportunityName(String name) {
        return opportunityName.getText().contains(name);
    }

    public boolean verifyNewOpportunityPrivate() {
        return opportunityPrivate.isSelected();
    }

    public boolean verifyNewOpportunityType(String type) {
        return opportunityType.getText().contains(type);
    }

    public boolean verifyNewOpportunityLeadSource(String leadSource) {
        return opportunityLeadSource.getText().contains(leadSource);
    }

    public boolean verifyNewOpportunityAmount(String amount) {
        return opportunityAmount.getText().contains(amount);
    }

    public boolean verifyNewOpportunityStep(String step) {
        return opportunityStep.getText().contains(step);
    }

    public boolean verifyNewOpportunityStage(String stage) {
        return opportunityStage.getText().contains(stage);
    }


}
