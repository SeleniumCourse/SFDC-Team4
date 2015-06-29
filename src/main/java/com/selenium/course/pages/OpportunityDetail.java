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

    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    WebElement opportunityName;

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

    public boolean verifyNewOpportunity(String name) {
        return opportunityName.getText().contains(name);
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
}
