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

import com.selenium.course.framework.DriverManager;

public class NavigationLinks {
	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(id = "userNavLabel")
   	@CacheLookup
   	WebElement userLabel;
    
    @FindBy(xpath = "//a[contains(@title,'Help')]")
   	@CacheLookup
   	WebElement helpTab;
    
    public NavigationLinks(WebDriver driver) {
    	this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        
        PageFactory.initElements(driver, this);
        
        try {
            wait.withTimeout(3, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(userLabel));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
    }
    
    public UserMenu clickUserMenu() {
    	userLabel.click();
    	return new UserMenu();
    }
    
    public HelpPage clickHelp() {
    	this.driver = driver;
    	helpTab.click();
    	return new HelpPage(driver);
    }

}
