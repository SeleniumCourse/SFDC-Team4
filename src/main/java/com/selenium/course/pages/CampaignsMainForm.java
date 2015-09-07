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

public class CampaignsMainForm extends ObjectFormPage {

    @FindBy(xpath = "//h2[contains(.,'Campaign Edit')]")
    @CacheLookup
    private WebElement newCampaignsTitle;

    @FindBy(name = "cpn1")
    @CacheLookup
    private WebElement nameField;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;

    @FindBy(id = "cpn16")
    @CacheLookup
    private WebElement isActiveCheckBox;

    @FindBy(id = "cpn2")
    @CacheLookup
    private WebElement campaignType;

    @FindBy(id = "cpn3")
    @CacheLookup
    private WebElement campaignStatus;

    @FindBy(id = "cpn5")
    @CacheLookup
    private WebElement campaignStartDate;

    @FindBy(id = "cpn6")
    @CacheLookup
    private WebElement campaignEndDate;

    public CampaignsMainForm(WebDriver driver) {
        super(driver);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(newCampaignsTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public CampaignsMainForm setCampaignType(String type) {
        new Select(campaignType).selectByVisibleText(type);
        return this;
    }

    public CampaignsMainForm setCampaignStatus(String status) {
        new Select(campaignStatus).selectByVisibleText(status);
        return this;
    }

    public CampaignsMainForm setCampaignName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public CampaignsMainForm setCampaignStartDate(String date) {
        campaignStartDate.clear();
        campaignStartDate.sendKeys(date);
        return this;
    }

    public CampaignsMainForm setCampaignEndDate(String date) {
        campaignEndDate.clear();
        campaignEndDate.sendKeys(date);
        return this;
    }

    public CampaignDetailsForm clickSaveCampaign() {
        saveBtn.click();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new CampaignDetailsForm(driver);
    }
}
