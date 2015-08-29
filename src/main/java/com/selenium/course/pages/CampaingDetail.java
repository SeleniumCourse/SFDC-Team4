package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class CampaingDetail {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//h1[contains(.,'Campaign:')]")
    @CacheLookup
	WebElement campaignDetailTable;
	
	@FindBy(id = "cpn1_ileinner")
    @CacheLookup
	WebElement campaignName;
	
	@FindBy(name = "del")
    @CacheLookup
	WebElement deleteBtn;
	
	@FindBy(name = "edit")
    @CacheLookup
	WebElement editBtn;
	
	public CampaingDetail() {
		wait = WebDriverManager.getInstance().getWait();
		driver = WebDriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(campaignDetailTable));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
		}
	}
	
	public boolean verifyNewCampaign(String campName) {
		return campaignName.getText().contains(campName);
	}
	
	public CampaingsPage deleteCampaign() {
		deleteBtn.click();
		Alert alert = driver.switchTo().alert();
        alert.accept();
        return new CampaingsPage();
	}
	
	public CampaignEdit clickEdit() {
		editBtn.click();
		return new CampaignEdit();
	}

}
