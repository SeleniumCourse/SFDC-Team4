package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class LeadDetail {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//h2[@class='topName']")
    @CacheLookup
	WebElement newLeadsTitle;
	
	@FindBy(id = "lea2_ileinner")
    @CacheLookup
	WebElement lead;
	
	@FindBy(id = "lea3_ileinner")
    @CacheLookup
	WebElement companyName;
	
	@FindBy(name = "del")
    @CacheLookup
	WebElement deleteBtn;
	
	@FindBy(name = "edit")
    @CacheLookup
	WebElement editBtn;
	
	public LeadDetail() {
		this.driver = driver;
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
	
	public boolean verifyName(String salutation ,String leadName) {
		wait.until(ExpectedConditions.visibilityOf(lead));
		return lead.getText().equals(salutation + " " + leadName);
	}
	
	public boolean verifyCompany(String company) {
		wait.until(ExpectedConditions.visibilityOf(companyName));
		return companyName.getText().equals(company);
	}
	
	public boolean verifyCampaing(String campaingName) {
		return driver.findElement(By.xpath("//a[contains(text(),'" + campaingName + "')]")).isDisplayed();
	}
	
	public LeadsPage clickDelete() {
		deleteBtn.click();
		Alert alert = driver.switchTo().alert();
        alert.accept();
        return new LeadsPage();
	}
	
	public LeadEdit clickEdit() {
		editBtn.click();
		return new LeadEdit();
	}
}
