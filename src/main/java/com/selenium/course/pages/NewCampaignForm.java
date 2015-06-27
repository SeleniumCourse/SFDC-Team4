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

public class NewCampaignForm extends CommonForm{
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//h2[contains(.,'New Campaign')]")
    @CacheLookup
	WebElement newCampaignsTitle;
	
	@FindBy(name = "cpn1")
    @CacheLookup
	WebElement nameField;
	
	@FindBy(name = "save")
    @CacheLookup
	WebElement saveBtn;
	
	@FindBy(id = "cpn16")
	@CacheLookup
	WebElement isActiveCheckBox;
	
	public NewCampaignForm() {
		wait = DriverManager.getInstance().getWait();
		driver = DriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(3, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(newCampaignsTitle));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(15, TimeUnit.SECONDS);
		}
	}
	
	public CampaingDetail createNewCampaign(String name, boolean status) {
		setCampaignName(name);
		setStatus(status);
		clickSaveCampaign();
		return new CampaingDetail();
	}
	
	
	
	

}
