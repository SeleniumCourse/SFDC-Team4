package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import com.selenium.course.framework.*;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

public class PageMenuBar {
	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(xpath = "//a[@title='Home Tab']")
    @CacheLookup
	WebElement homeTab;
    
    @FindBy(id = "tabBar")
    @CacheLookup
	WebElement tabBar;
    
    @FindBy(xpath = "//a[@title='Leads Tab']")
    @CacheLookup
	WebElement leadsTab;
    
    @FindBy(xpath = "//a[@title='Campaigns Tab']")
    @CacheLookup
	WebElement campaigns;
    
    @FindBy(xpath = "//a[@title='Accounts Tab']")
    @CacheLookup
	WebElement accounts;
    
    @FindBy(xpath = "//a[@title='Contacts Tab']")
    @CacheLookup
	WebElement contacts;
    
    @FindBy(xpath = "//a[@title='Opportunities Tab']")
    @CacheLookup
	WebElement opportunities;
    
    @FindBy(xpath = "//a[@title='Products Tab']")
    @CacheLookup
	WebElement products;

    @FindBy(xpath = "//a[@title='Chatter Tab']")
    @CacheLookup
    WebElement chatter;

    public PageMenuBar(WebDriver driver) {
    	this.driver = driver;
        this.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        
        try {
			wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(tabBar));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
		}
    }
    
    public void clickHomeTab() {
    	//addHome Page classS
    	homeTab.click();
    }
    
    public boolean isTabBarDisplayed() {
    	return tabBar.isDisplayed();
    }
    
    public LeadsPage clickLeadsTab() {
    	leadsTab.click();
    	return new LeadsPage();
    }
    
    public CampaingsPage clickCampaings() {
    	campaigns.click();
    	return new CampaingsPage();
    }
    
    public AccountsPage clickAccounts() {
    	accounts.click();
    	return new AccountsPage();
    }
    
    public ContactsPage clickContacts() {
    	contacts.click();
    	return new ContactsPage();
    }

    public OpportunitiesPage clickOpportunities() {
    	opportunities.click();
    	return new OpportunitiesPage();
    }
    
    public ProductsPage clickProducts() {
    	products.click();
    	return new ProductsPage();
    }

    public ChatterPage clickChatter() {
        chatter.click();
        return new ChatterPage();
    }

}
