package com.selenium.course.pages;

import com.selenium.course.framework.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static com.selenium.course.common.CommonUIMethods.check;
import static com.selenium.course.common.CommonUIMethods.uncheck;
import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

/**
 * Created for Joel Rodriguez
 */

public class CampaignsMainForm extends ObjectFormPage {

    @FindBy(xpath = "//h2[contains(.,'New Campaign')]")
    @CacheLookup
    WebElement newCampaignsTitle;

    @FindBy(name = "cpn1")
    @CacheLookup
    WebElement nameField;

    @FindBy(name = "save")
    @CacheLookup
    WebElement saveBtn;

    @FindBy(id = "cpn16")
    @CacheLookup
    WebElement isActiveCheckBox;

    public CampaignsMainForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(newCampaignsTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public CampaignsMainForm setCampaignName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public CampaignsMainForm setStatus(boolean status) {
        if (status) {
            check(By.id("cpn16"));
        } else {
            uncheck(By.id("cpn16"));
        }
        return this;
    }

    public CampaignDetailsForm clickSaveCampaign() {
        saveBtn.click();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new CampaignDetailsForm(driver);
    }
}
