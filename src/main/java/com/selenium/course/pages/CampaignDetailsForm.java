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

public class CampaignDetailsForm extends ObjectFormPage {

    @FindBy(xpath = "//h2[contains(.,'Campaign Detail')]")
    @CacheLookup
    private WebElement campaignDetailTable;

    @FindBy(id = "cpn1_ileinner")
    @CacheLookup
    private WebElement campaignName;

    @FindBy(name = "del")
    @CacheLookup
    private WebElement deleteBtn;

    @FindBy(name = "edit")
    @CacheLookup
    private WebElement editBtn;

    public CampaignDetailsForm(WebDriver driver) {
        super(driver);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(campaignDetailTable));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public boolean verifyNewCampaign(String campName) {
        return campaignName.getText().contains(campName);
    }

    public TabPage deleteCampaign() {
        deleteBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new TabPage(driver);
    }

    public CampaignsMainForm editCampaign() {
        editBtn.click();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        return new CampaignsMainForm(driver);
    }

}
