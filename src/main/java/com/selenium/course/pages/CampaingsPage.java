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

public class CampaingsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//h1[contains(.,'Campaigns:')]")
    @CacheLookup
	WebElement campaignsTitle;
	
	@FindBy(name = "new")
    @CacheLookup
	WebElement newBtn;
	
	@FindBy(name = "go")
    @CacheLookup
	WebElement goBtn;
	
	
	public CampaingsPage() {
		wait = DriverManager.getInstance().getWait();
		driver = DriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(3, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(campaignsTitle));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(15, TimeUnit.SECONDS);
		}
	}
	
	public NewCampaignForm clickNewCampaign() {
		newBtn.click();
		return new NewCampaignForm();
	}
	
	public CampaingsTablePage clickGo() {
		goBtn.click();
		return new CampaingsTablePage();
	}

}
