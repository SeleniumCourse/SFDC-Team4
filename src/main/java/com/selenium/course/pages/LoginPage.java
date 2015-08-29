package com.selenium.course.pages;

import com.selenium.course.framework.Environment;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page {

    private TabBar tabBar;


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
        super();
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

    public ContentPage loginAs(String username, String password) {
        setUsernameTxt(username);
        setPasswordTxt(password);
        return clickLoginBtn();
    }

    public LoginPage setUsernameTxt(String username) {
        userTxt.clear();
        userTxt.sendKeys(username);
        return this;
    }

    public LoginPage setPasswordTxt(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public ContentPage clickLoginBtn() {
        loginBtn.click();
        return new ContentPage(driver);
    }

    public ContentPage loginAsPrimaryUser() {
        String username = Environment.getInstance()
                .getPrimaryUserName();
        String password = Environment.getInstance()
                .getPrimaryUserPassword();
        return loginAs(username, password);
    }
}
