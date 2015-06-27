package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.course.framework.DriverManager;

public class MainApp {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private PageMenuBar pageMenuBar;
	private NavigationLinks navigationLinks;
	private ToolBar toolBar;

	@FindBy(id = "AppBodyHeader")
    @CacheLookup
	WebElement bodyPage; 
	
	public MainApp(WebDriver driver) {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
    }
	
	public PageMenuBar goToPageMenuBar() {
		return new PageMenuBar(driver);
    }
	
	public NavigationLinks goToNavigationLinks() {
		return new NavigationLinks(driver);
	}
	
	public ToolBar goToTolBar() {
		return new ToolBar(driver);
	}
	
	public boolean isMainPageDisplayed() {
    	return bodyPage.isDisplayed();
    }
}
