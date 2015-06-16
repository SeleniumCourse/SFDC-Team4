package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.course.framework.DriverManager;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private PageMenuBar pageMenuBar;
	

	@FindBy(id = "Login")
	@CacheLookup
	WebElement loginBtn;

	@FindBy(id = "username")
	@CacheLookup
	WebElement userTxt;

	@FindBy(id = "password")
	@CacheLookup
	WebElement passwordTxt;

	public LoginPage() {
		driver = DriverManager.getInstance().getDriver();
		wait = DriverManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
		try {
			wait.until(ExpectedConditions.visibilityOf(userTxt));
			wait.until(ExpectedConditions.visibilityOf(passwordTxt));
			wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			
		}
	}
	
	 public MainApp loginAs(String email, String password) {
		 setEmailTxt(email);
		 setPasswordTxt(password);
		 return clickLoginBtn();

	    }
	
	public void setEmailTxt(String email) {
        try {
            
        	userTxt.clear();
        	userTxt.sendKeys(email);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }
	
	public void setPasswordTxt(String password) {
        try {
            passwordTxt.clear();
            passwordTxt.sendKeys(password);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

	public MainApp clickLoginBtn() {
        try {
        	loginBtn.click();
        	
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return new MainApp(driver);
    }
}
