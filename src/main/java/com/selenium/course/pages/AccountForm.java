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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;
import com.selenium.course.framework.WebDriverManager;
import com.selenium.course.pages.EnumsList.Steps;

public class AccountForm extends ObjectFormPage{

	@FindBy(xpath = "//h1[contains(.,'Account Edit:')]")
    @CacheLookup
	public WebElement newAccountTitle;

	@FindBy(id = "acc2")
	@CacheLookup
	public WebElement accountNameField;

	@FindBy(xpath = "//img[@title='Parent Account Lookup (New Window)']")
	@CacheLookup
	public WebElement findAccountLookup;

	@FindBy(id = "acc5")
	@CacheLookup
	public WebElement accountNumberField;

	@FindBy(id = "acc23")
	@CacheLookup
	public WebElement accountSiteField;

	@FindBy(id = "acc6")
	@CacheLookup
	public WebElement typeField;

	@FindBy(id = "acc7")
	@CacheLookup
	public WebElement industryField;

	@FindBy(id = "acc8")
	@CacheLookup
	public WebElement revenueField;

	@FindBy(id = "acc9")
	@CacheLookup
	public WebElement ratingField;

	@FindBy(id = "acc10")
	@CacheLookup
	public WebElement phoneField;

	@FindBy(id = "acc11")
	@CacheLookup
	public WebElement faxField;

	@FindBy(id = "acc12")
	@CacheLookup
	public WebElement webSiteField;

	@FindBy(id = "acc13")
	@CacheLookup
	public WebElement tickerSymbolField;

	@FindBy(id = "acc14")
	@CacheLookup
	public WebElement ownershipField;

	@FindBy(id = "acc15")
	@CacheLookup
	public WebElement employeesField;

	@FindBy(id = "acc16")
	@CacheLookup
	public WebElement sicCodeField;

	@FindBy(id = "acc17city")
	@CacheLookup
	public WebElement billingCityField;

	@FindBy(id = "acc17state")
	@CacheLookup
	public WebElement billingStateField;

	@FindBy(id = "acc17zip")
	@CacheLookup
	public WebElement billingZipField;

	@FindBy(id = "acc17country")
	@CacheLookup
	public WebElement billingCountryField;

	@FindBy(id = "acc18city")
	@CacheLookup
	public WebElement shipCityField;

	@FindBy(id = "acc18state")
	@CacheLookup
	public WebElement shipStateField;

	@FindBy(id = "acc18zip")
	@CacheLookup
	public WebElement shipZipField;

	@FindBy(id = "acc18country")
	@CacheLookup
	public WebElement shipCountryField;

	public AccountForm(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(newAccountTitle));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
		}
	}

	public AccountForm setAccountNameText(String fieldValue){

		accountNameField.clear();
		accountNameField.sendKeys(fieldValue);
		return  this;
	}


}
