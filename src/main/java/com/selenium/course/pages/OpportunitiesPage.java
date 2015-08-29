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
import com.selenium.course.framework.WebDriverManager;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

public class OpportunitiesPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//h1[contains(.,'Opportunities:')]")
    @CacheLookup
	WebElement opportunitiesTitle;

	@FindBy(xpath = "//input[@name='new']")
	@CacheLookup
	WebElement newBtn;

	@FindBy(name = "go")
	@CacheLookup
	WebElement goBtn;
	
	public OpportunitiesPage() {
		wait = WebDriverManager.getInstance().getWait();
		driver = WebDriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(opportunitiesTitle));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
		}
	}
	public NewOpportunityForm clickNewOpportunity() {
		newBtn.click();
		return new NewOpportunityForm();
	}

	public OpportunityTablePage clickGo() {
		goBtn.click();
		return new OpportunityTablePage();
	}

}
