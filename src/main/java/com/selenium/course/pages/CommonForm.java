package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.course.framework.DriverManager;

import static com.selenium.course.common.CommonUIMethods.check;
import static com.selenium.course.common.CommonUIMethods.uncheck;

public class CommonForm {
	private WebDriver driver;
	private WebDriverWait wait;
	private Select selectBox;
	private SearchWindow searchWindow;

	@FindBy(id = "acc2")
	@CacheLookup
	WebElement accountNameField;

	@FindBy(xpath = "//img[@title='Parent Account Lookup (New Window)']")
	@CacheLookup
	WebElement findAccountLookup;

	@FindBy(id = "acc5")
	@CacheLookup
	WebElement accountNumberField;

	@FindBy(id = "acc23")
	@CacheLookup
	WebElement accountSiteField;

	@FindBy(id = "acc6")
	@CacheLookup
	WebElement typeField;

	@FindBy(id = "acc7")
	@CacheLookup
	WebElement industryField;

	@FindBy(id = "acc8")
	@CacheLookup
	WebElement revenueField;

	@FindBy(id = "acc9")
	@CacheLookup
	WebElement ratingField;

	@FindBy(id = "acc10")
	@CacheLookup
	WebElement phoneField;

	@FindBy(id = "acc11")
	@CacheLookup
	WebElement faxField;

	@FindBy(id = "acc12")
	@CacheLookup
	WebElement webSiteField;

	@FindBy(id = "acc13")
	@CacheLookup
	WebElement tickerSymbolField;

	@FindBy(id = "acc14")
	@CacheLookup
	WebElement ownershipField;

	@FindBy(id = "acc15")
	@CacheLookup
	WebElement employeesField;

	@FindBy(id = "acc16")
	@CacheLookup
	WebElement sicCodeField;

	@FindBy(id = "acc17city")
	@CacheLookup
	WebElement billingCityField;

	@FindBy(id = "acc17state")
	@CacheLookup
	WebElement billingStateField;

	@FindBy(id = "acc17zip")
	@CacheLookup
	WebElement billingZipField;

	@FindBy(id = "acc17country")
	@CacheLookup
	WebElement billingCountryField;

	@FindBy(id = "acc18city")
	@CacheLookup
	WebElement shipCityField;

	@FindBy(id = "acc18state")
	@CacheLookup
	WebElement shipStateField;

	@FindBy(id = "acc18zip")
	@CacheLookup
	WebElement shipZipField;

	@FindBy(id = "acc18country")
	@CacheLookup
	WebElement shipCountryField;

	// Items to Create Leads
	@FindBy(name = "name_salutationlea2")
	@CacheLookup
	WebElement salutationOption;

	@FindBy(id = "name_lastlea2")
	@CacheLookup
	WebElement lastNameField;

	@FindBy(id = "lea3")
	@CacheLookup
	WebElement companyNameField;

	@FindBy(xpath = "//img[@title='Campaign Lookup (New Window)']")
	@CacheLookup
	WebElement findCampaingLookup;

	@FindBy(name = "save")
	@CacheLookup
	WebElement saveBtn;

	// Items to create Campaings
	@FindBy(name = "cpn1")
	@CacheLookup
	WebElement campaignNameField;

	@FindBy(id = "cpn16")
	@CacheLookup
	WebElement statusChbx;

	public CommonForm() {
		wait = DriverManager.getInstance().getWait();
		driver = DriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
	}

	public void setAccountName(String accountName) {
		accountNameField.clear();
		accountNameField.sendKeys(accountName);
	}

	public void setParentAccount(String parentAccount) {
		searchWindow = clickParentLookup();
		searchWindow.findObject(parentAccount);
	}

	private SearchWindow clickParentLookup() {
		findAccountLookup.click();
		return new SearchWindow(driver);
	}

	public void setAccountNumber(String accountNumber) {
		accountNumberField.clear();
		accountNumberField.sendKeys(accountNumber);
	}

	public void setAccountSite(String accountSite) {
		accountSiteField.clear();
		accountSiteField.sendKeys(accountSite);
	}

	public void selectType(String type) {
		selectBox = new Select(typeField);
		selectBox.selectByVisibleText(type);
	}

	public void selectIndustry(String industry) {
		selectBox = new Select(industryField);
		selectBox.selectByVisibleText(industry);
	}

	public void setAnnualRevenue(String revenue) {
		revenueField.clear();
		revenueField.sendKeys(revenue);
	}

	public void selectRating(String rating) {
		selectBox = new Select(ratingField);
		selectBox.selectByVisibleText(rating);
	}

	public void setPhone(String phone) {
		phoneField.clear();
		phoneField.sendKeys(phone);
	}

	public void setFax(String fax) {
		faxField.clear();
		faxField.sendKeys(fax);
	}

	public void setWebSite(String website) {
		webSiteField.clear();
		webSiteField.sendKeys(website);
	}

	public void setTickerSymbol(String tickerSymbol) {
		tickerSymbolField.clear();
		tickerSymbolField.sendKeys(tickerSymbol);
	}

	public void selectOwnership(String ownership) {
		selectBox = new Select(ownershipField);
		selectBox.selectByVisibleText(ownership);
	}

	public void setEmployees(String employees) {
		employeesField.clear();
		employeesField.sendKeys(employees);
	}

	public void setBillingCity(String billingCity) {
		billingCityField.clear();
		billingCityField.sendKeys(billingCity);
	}

	public void setBillingState(String billingState) {
		billingStateField.clear();
		billingStateField.sendKeys(billingState);
	}

	public void setBillingZip(String billingZip) {
		billingZipField.clear();
		billingZipField.sendKeys(billingZip);
	}

	public void setBillingCountry(String billingCountry) {
		billingCountryField.clear();
		billingCountryField.sendKeys(billingCountry);
	}

	public void setShippingCity(String shippingCity) {
		shipCityField.clear();
		shipCityField.sendKeys(shippingCity);
	}

	public void setShippingState(String shippingState) {
		shipStateField.clear();
		shipStateField.sendKeys(shippingState);
	}

	public void setShippingZip(String shippingZip) {
		shipZipField.clear();
		shipZipField.sendKeys(shippingZip);
	}

	public void setShippingCountry(String shippingCountry) {
		shipCountryField.clear();
		shipCountryField.sendKeys(shippingCountry);
	}

	public AccountDetail clickSaveAccount() {
		saveBtn.click();
		return new AccountDetail();
	}

	// Methods to create Leads
	public void selectSalutation(String salutation) {
		selectBox = new Select(salutationOption);
		selectBox.selectByVisibleText(salutation);
	}

	public void setLastName(String lastName) {
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
	}

	public void setCompany(String companyName) {
		companyNameField.clear();
		companyNameField.sendKeys(companyName);
	}

	public void setCampaing(String campaing) {
		searchWindow = clickCampaingLookup();
		searchWindow.findObject(campaing);
	}

	private SearchWindow clickCampaingLookup() {
		findCampaingLookup.click();
		return new SearchWindow(driver);
	}

	public LeadDetail clickSaveLead() {
		saveBtn.click();
		return new LeadDetail();
	}

	// Methods to create Campaings
	public void setCampaignName(String name) {
		campaignNameField.clear();
		campaignNameField.sendKeys(name);
	}

	public void setStatus(boolean status) {
		if (status) {
			check(By.id("cpn16"));
		} else {
			uncheck(By.id("cpn16"));
		}
	}

	public CampaingDetail clickSaveCampaign() {
		saveBtn.click();
		return new CampaingDetail();
	}
}
