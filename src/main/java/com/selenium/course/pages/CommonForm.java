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
	protected WebDriver driver;
	protected WebDriverWait wait;
	private Select selectBox;
	private SearchWindow searchWindow;

	@FindBy(id = "acc2")
	WebElement accountNameField;

	@FindBy(xpath = "//img[@title='Parent Account Lookup (New Window)']")
	WebElement findAccountLookup;

	@FindBy(id = "acc5")
	WebElement accountNumberField;

	@FindBy(id = "acc23")
	WebElement accountSiteField;

	@FindBy(id = "acc6")
	WebElement typeField;

	@FindBy(id = "acc7")
	WebElement industryField;

	@FindBy(id = "acc8")
	WebElement revenueField;

	@FindBy(id = "acc9")
	WebElement ratingField;

	@FindBy(id = "acc10")
	WebElement phoneField;

	@FindBy(id = "acc11")
	WebElement faxField;

	@FindBy(id = "acc12")
	WebElement webSiteField;

	@FindBy(id = "acc13")
	WebElement tickerSymbolField;

	@FindBy(id = "acc14")
	WebElement ownershipField;

	@FindBy(id = "acc15")
	WebElement employeesField;

	@FindBy(id = "acc16")
	WebElement sicCodeField;

	@FindBy(id = "acc17city")
	WebElement billingCityField;

	@FindBy(id = "acc17state")
	WebElement billingStateField;

	@FindBy(id = "acc17zip")
	WebElement billingZipField;

	@FindBy(id = "acc17country")
	WebElement billingCountryField;

	@FindBy(id = "acc18city")
	WebElement shipCityField;

	@FindBy(id = "acc18state")
	WebElement shipStateField;

	@FindBy(id = "acc18zip")
	WebElement shipZipField;

	@FindBy(id = "acc18country")
	WebElement shipCountryField;

	// Items to create Campaings
	@FindBy(name = "cpn1")
	WebElement campaignNameField;

	@FindBy(id = "cpn16")
	WebElement statusChbx;
	
	@FindBy(name = "save")
	WebElement saveBtn;
	
	//Locator for Leads
	@FindBy(id = "name_lastlea2")
	WebElement lastNameField;

	@FindBy(name = "name_salutationlea2")
	WebElement salutationOption;

	@FindBy(id = "lea3")
	WebElement companyNameField;

	@FindBy(xpath = "//img[@title='Campaign Lookup (New Window)']")
	WebElement findCampaingLookup;

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
}
