package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.course.framework.WebDriverManager;

public class ContentPage extends Page{

	public TabBar tabBar;
	public NavigationLinks navigationLinks;
	public ToolBar toolBar;

	@FindBy(id = "AppBodyHeader")
    @CacheLookup
	public WebElement bodyPage;

	
	public ContentPage(WebDriver driver) {
        super(driver);
		tabBar = new TabBar(driver);
		navigationLinks = new NavigationLinks(driver);
		toolBar = new ToolBar(driver);
		PageFactory.initElements(driver, this);
    }
	
	public TabBar goToTabBar() {
		return new TabBar(driver);
	}
	
	public NavigationLinks goToNavigationLinks() {
		return new NavigationLinks(driver);
	}
	
	public ToolBar goToToolBar() {
		return new ToolBar(driver);
	}
	
	public boolean isMainPageDisplayed() {
    	return bodyPage.isDisplayed();
    }

}
