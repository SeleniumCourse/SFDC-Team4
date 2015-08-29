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

public class NewAccountForm extends CommonForm{
	private WebDriver driver;
	private WebDriverWait wait;
	private Map<Steps, IAutomationStep> strategyMap;
	
	private NewAccountBuilder newAccountBuilder;
	List<Steps> strategies;
	
	@FindBy(xpath = "//h1[contains(.,'Account Edit:')]")
    @CacheLookup
	WebElement newAccountTitle;
	
	@FindBy(name = "save")
    @CacheLookup
	WebElement saveBtn;
	
	public NewAccountForm() {
		this.driver = driver;
		wait = WebDriverManager.getInstance().getWait();
		driver = WebDriverManager.getInstance().getDriver();
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
	
	public NewAccountForm(NewAccountBuilder builder) {
		this.newAccountBuilder = builder;
		this.strategies = builder.strategies;
		
		/*this.strategyMap = new HashMap<>();
		strategyMap.put(Steps.ACCOUNT, () -> setAccountName(builder.account));
		strategyMap.put(Steps.PARENT_ACCOUNT, () -> setParentAccount(builder.parentAccount));
		strategyMap.put(Steps.NUMBER, () -> setAccountNumber(builder.accountNumber));
		strategyMap.put(Steps.ACCOUNT_SITE, () -> setAccountSite(builder.accountSite));
		strategyMap.put(Steps.TYPE, () -> selectType(builder.type));
		strategyMap.put(Steps.INDUSTRY, () -> selectIndustry(builder.Industry));
		strategyMap.put(Steps.REVENUE, () -> setAnnualRevenue(builder.revenue));
		strategyMap.put(Steps.RATING, () -> selectRating(builder.rating));
		strategyMap.put(Steps.PHONE, () -> setPhone(builder.phone));
		strategyMap.put(Steps.WEBSITE, () -> setWebSite(builder.webSite));
		strategyMap.put(Steps.FAX, () -> setFax(builder.fax));
		strategyMap.put(Steps.TICKERSYMBOL, () -> setTickerSymbol(builder.tickerSymbol));
		strategyMap.put(Steps.OWNERSHIP, () -> selectOwnership(builder.ownership));
		strategyMap.put(Steps.EMPLOYES, () -> setEmployees(builder.employes));
		strategyMap.put(Steps.BILLCITY, () -> setBillingCity(builder.billCity));
		strategyMap.put(Steps.BILLSTATE, () -> setBillingState(builder.billState));
		strategyMap.put(Steps.BILLZIP, () -> setBillingZip(builder.billZip));
		strategyMap.put(Steps.BILLCOUNTRY, () -> setBillingCountry(builder.billCountry));
		strategyMap.put(Steps.SHIPCITY, () -> setShippingCity(builder.shipCity));
		strategyMap.put(Steps.SHIPSTATE, () -> setShippingState(builder.shipState));
		strategyMap.put(Steps.SHIPZIP, () -> setShippingZip(builder.shipZip));
		strategyMap.put(Steps.SHIPCOUNTRY, () -> setShippingCountry(builder.shipCountry));*/
    }
	
	public AccountDetail createAccount() {
		//strategies.forEach(elem -> strategyMap.get(elem).performTask());
		return clickSaveAccount();
	}
}
