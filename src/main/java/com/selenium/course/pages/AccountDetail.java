package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.selenium.course.common.Globals.*;

public class AccountDetail  extends ObjectDetailsPage{
		
	@FindBy(xpath = "//h2[contains(.,'Account Detail')]")
    @CacheLookup
	private WebElement accountDetailLabel;

	
	public AccountDetail(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(accountDetailLabel));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
		}
	}

}
