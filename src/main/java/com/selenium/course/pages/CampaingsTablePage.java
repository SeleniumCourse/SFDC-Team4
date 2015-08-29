package com.selenium.course.pages;

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

public class CampaingsTablePage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "ext-gen11")
    @CacheLookup
	WebElement campaignsTable;
	
	public CampaingsTablePage() {
		wait = WebDriverManager.getInstance().getWait();
		driver = WebDriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(campaignsTable));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
		}
	}
	
	public CampaingDetail clickCampaing(String campaing) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(.,'" + campaing + "')]"))));
		driver.findElement(By.xpath("//span[contains(.,'" + campaing + "')]")).click();
		return new CampaingDetail();
	}
}
