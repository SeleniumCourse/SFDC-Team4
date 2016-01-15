package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Joel Rodriguez
 */
public class CampaignsViewForm extends ViewFormPage {

    @FindBy(id = "//input[@id='fscope1']")
    @CacheLookup
    private WebElement myCampaigns;

    @FindBy(id = "//input[@id='fscope0']")
    @CacheLookup
    private WebElement allCampaigns;

    @FindBy(id = "//select[@id='fcol1']")
    @CacheLookup
    private WebElement filter;

    public CampaignsViewForm(WebDriver driver) {
        super(driver);
    }

    public CampaignsViewForm setMyCampaigns(String name) {
        myCampaigns.click();
        return this;
    }

    public CampaignsViewForm setAllCampaigns() {
        allCampaigns.click();
        return this;
    }

    public CampaignsViewForm setFilter(String name) {
        new Select(filter).selectByVisibleText(name);
        return this;
    }

}
