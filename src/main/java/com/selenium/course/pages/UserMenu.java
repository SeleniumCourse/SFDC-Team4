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

public class UserMenu {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "userNav-menuItems")
    @CacheLookup
	WebElement userMenuDropDown;
	
	@FindBy(xpath = "//a[contains(.,'Logout')]")
    @CacheLookup
	WebElement logoutTab;
	
	@FindBy(xpath = "//a[contains(.,'My Profile')]")
    @CacheLookup
	WebElement myProfileTab;
	
	public UserMenu() {
		wait = DriverManager.getInstance().getWait();
		driver = DriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(3, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(userMenuDropDown));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(15, TimeUnit.SECONDS);
		}
	}
	
	public LoginPage clickLogout() {
		logoutTab.click();
		return new LoginPage();
	}
	
	public MyProfilePage clickMyProfile() {
		myProfileTab.click();		
		return new MyProfilePage();
	}
}
