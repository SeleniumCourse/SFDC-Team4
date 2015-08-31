package com.selenium.course.pages;

import static com.selenium.course.common.CommonUIMethods.check;
import static com.selenium.course.common.CommonUIMethods.uncheck;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import com.selenium.course.framework.WebDriverManager;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

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
		wait = WebDriverManager.getInstance().getWait();
		driver = WebDriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(newCampaignsTitle));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
		}
	}
	
	// Methods to create Campaings
	public NewCampaignForm setCampaignName(String name) {
		campaignNameField.clear();
		campaignNameField.sendKeys(name);
		return this;
	}

	public NewCampaignForm setStatus(boolean status) {
		if (status) {
			check(By.id("cpn16"));
		} else {
			uncheck(By.id("cpn16"));
		}
		return this;
	}


	

}
