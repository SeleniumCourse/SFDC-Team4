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

public class NewAccountForm extends CommonForm{
	private WebDriver driver;
	private WebDriverWait wait;
	private String accountName,parentAccount, accountNumber, accountSite, type, 
					Industry, revenue, rating, phone, fax, webSite, tickerSymbol, 
					ownership, employes,billCity, billState, billZip, billCountry,
					shipCity, shipState, shipZip, shipCountry;
	
	
	@FindBy(xpath = "//h2[contains(.,' New Account')]")
    @CacheLookup
	WebElement newAccountTitle;
	
	@FindBy(name = "save")
    @CacheLookup
	WebElement saveBtn;
	
	
	
	public NewAccountForm() {
		this.driver = driver;
		wait = DriverManager.getInstance().getWait();
		driver = DriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(3, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(newAccountTitle));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(15, TimeUnit.SECONDS);
		}
	}
	
	
	public AccountDetail createNewAccount(String accountName, String parentAccount, String accountNumber, String accountSite, 
							String type, String Industry, String revenue, String rating, String phone, String fax, String webSite, 
							String tickerSymbol, String ownership, String employes, String billCity, String  billState, String billZip, 
							String billCountry, String shipCity, String shipState, String shipZip, String shipCountry) {
		
		
		setAccountName(accountName);
		setParentAccount(parentAccount);
		setAccountNumber(accountNumber);
		setAccountSite(accountSite);
		selectType(type);
		selectIndustry(Industry);
		setAnnualRevenue(revenue);
		selectRating(rating);
		setPhone(phone);
		setFax(fax);
		setWebSite(webSite);
		setTickerSymbol(tickerSymbol);
		selectOwnership(ownership);
		setEmployees(employes);
		setBillingCity(billCity);
		setBillingState(billState);
		setBillingZip(billZip);
		setBillingCountry(billCountry);
		setShippingCity(shipCity);
		setShippingState(shipState);
		setShippingZip(shipZip);
		setShippingCountry(shipCountry);
		clickSaveAccount();
		
		return new AccountDetail();
	}
	
	public NewAccountForm(NewAccountBuilder builder) {
		this.accountName = builder.getAccount();
    }
	
	public AccountDetail createAccount() {
		if (!accountName.isEmpty()) {
			setAccountName(accountName);
			setParentAccount(parentAccount);
			setAccountNumber(accountNumber);
			setAccountSite(accountSite);
			selectType(type);
			selectIndustry(Industry);
			setAnnualRevenue(revenue);
			selectRating(rating);
			setPhone(phone);
			setFax(fax);
			setWebSite(webSite);
			setTickerSymbol(tickerSymbol);
			selectOwnership(ownership);
			setEmployees(employes);
			setBillingCity(billCity);
			setBillingState(billState);
			setBillingZip(billZip);
			setBillingCountry(billCountry);
			setShippingCity(shipCity);
			setShippingState(shipState);
			setShippingZip(shipZip);
			setShippingCountry(shipCountry);
		}
		return clickSaveAccount();
	}
}
