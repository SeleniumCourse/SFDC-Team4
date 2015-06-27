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

/**
 * Created by reyna ulaque on 15/06/2015.
 */
public class ContactDetail {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h2[contains(.,'Contact Detail')]")
    @CacheLookup
    WebElement contactDetailLabel;


    @FindBy(id = "con2_ileinner")
    @CacheLookup
    WebElement contactName;

    @FindBy(name = "del")
    @CacheLookup
    WebElement delBtn;

    @FindBy(name = "edit")
    @CacheLookup
    WebElement editBtn;

    public ContactDetail() {
        wait = DriverManager.getInstance().getWait();
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(3, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(contactDetailLabel));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
    }

    public String getContactName() {
        String fullName = "";
        fullName = contactName.getText();
        return fullName;
    }

    public void clickDeleteBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(delBtn));
        delBtn.click();
        Alert alert = this.driver.switchTo().alert();
        // Click the OK button in the Alert
        alert.accept();
    }
    public ContactForm clickEditBtn() {
        editBtn.click();
        return new ContactForm();
    }



}

