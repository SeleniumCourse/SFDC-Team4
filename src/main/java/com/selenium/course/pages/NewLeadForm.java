package com.selenium.course.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import com.selenium.course.framework.WebDriverManager;
import com.selenium.course.pages.EnumsList.Steps;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

public class NewLeadForm extends CommonForm{
	
	@FindBy(xpath = "//h1[contains(.,'Lead Edit:')]")
    @CacheLookup
	WebElement newLeadsTitle;
	
	private SearchWindow searchWindow;
	private Select selectBox;
	private Map<Steps, IAutomationStep> strategyMap;
	private NewLeadBuilder newLeadBuilder;
	List<Steps> strategies;
	
	public NewLeadForm() {
		wait = WebDriverManager.getInstance().getWait();
		driver = WebDriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(newLeadsTitle));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
		}
	}
	
	
	public NewLeadForm(NewLeadBuilder builder) {
		this.newLeadBuilder = builder;
		this.strategies = builder.strategies;
		
		//this.strategyMap = new HashMap<>();
		/*strategyMap.put(Steps.SALUTATION, () -> selectSalutation(builder.salutation));
		strategyMap.put(Steps.LAST_NAME, () -> setLastName(builder.lastName));
		strategyMap.put(Steps.COMPANY_NAME, () -> setCompany(builder.companyName));
		strategyMap.put(Steps.CAMPAIGN, () -> setCampaing(builder.campaign));*/
	}
	
	public LeadDetail createLead() {
		//strategies.forEach(elem -> strategyMap.get(elem).performTask());
		return clickSaveLead();
	}
	
	
}
