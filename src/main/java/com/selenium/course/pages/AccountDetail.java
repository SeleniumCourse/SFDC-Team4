package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.course.framework.DriverManager;

public class AccountDetail {
	private WebDriver driver;
	private WebDriverWait wait;
		
	@FindBy(xpath = "//h2[contains(.,'Account Detail')]")
    @CacheLookup
	WebElement accountDetailLabel;
	
	@FindBy(id = "acc2_ileinner")
    @CacheLookup
	WebElement accountName;
	
	@FindBy(name = "delete")
    @CacheLookup
	WebElement deleteBtn;
	
	public AccountDetail() {
		wait = DriverManager.getInstance().getWait();
		driver = DriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(3, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(accountDetailLabel));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(15, TimeUnit.SECONDS);
		}
	}
	
	public boolean verifyNewUser(String accName){
		return accountName.getText().contains(accName);
	}
	
	public AccountsPage deleteAccount() {
		deleteBtn.click();
		Alert alert = driver.switchTo().alert();
        alert.accept();
        return new AccountsPage();
	}

}
