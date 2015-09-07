package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Joel Rodriguez
 */
public class OpportunityViewForm extends ViewFormPage {

    @FindBy(id = "//input[@id='fscope1']")
    @CacheLookup
    private WebElement myCampaigns;

    @FindBy(id = "//input[@id='fscope0']")
    @CacheLookup
    private WebElement allCampaigns;

    @FindBy(id = "//select[@id='fcol1']")
    @CacheLookup
    private WebElement filter;

    public OpportunityViewForm(WebDriver driver) {
        super(driver);
    }

    public OpportunityViewForm setMyCampaigns(String name) {
        myCampaigns.click();
        return this;
    }

    public OpportunityViewForm setAllCampaigns() {
        allCampaigns.click();
        return this;
    }

    public OpportunityViewForm setFilter(String name) {
        new Select(filter).selectByVisibleText(name);
        return this;
    }

}
