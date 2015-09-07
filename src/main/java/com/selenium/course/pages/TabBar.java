package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

public class TabBar extends Page {

    @FindBy(linkText = "Home")
    @CacheLookup
    public WebElement home;

    @FindBy(id = "tabBar")
    @CacheLookup
    public WebElement tabBar;

    @FindBy(linkText = "Leads")
    @CacheLookup
    public WebElement leads;

    @FindBy(linkText = "Campaigns")
    @CacheLookup
    public WebElement campaigns;

    @FindBy(linkText = "Accounts")
    @CacheLookup
    public WebElement accounts;

    @FindBy(linkText = "Contacts")
    @CacheLookup
    public WebElement contacts;

    @FindBy(linkText = "Opportunities")
    @CacheLookup
    public WebElement opportunities;

    @FindBy(linkText = "Products")
    @CacheLookup
    public WebElement products;

    @FindBy(linkText = "Chatter")
    @CacheLookup
    public WebElement chatter;

    public TabBar(WebDriver driver) {
        super(driver);

        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(tabBar));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public boolean isTabBarDisplayed() {
        return tabBar.isDisplayed();
    }

    public TabPage clickLeadsTab() {
        leads.click();
        return new TabPage(driver);
    }

    public TabPage clickCampaigns() {
        campaigns.click();
        return new TabPage(driver);
    }

    public TabPage clickAccounts() {
        accounts.click();
        return new TabPage(driver);
    }

    public TabPage clickContacts() {
        contacts.click();
        return new TabPage(driver);
    }

    public TabPage clickOpportunities() {
        opportunities.click();
        return new TabPage(driver);
    }

    public TabPage clickProducts() {
        products.click();
        return new TabPage(driver);
    }

    public ChatterPage clickChatter() {
        chatter.click();
        return new ChatterPage(driver);
    }

}
