package com.selenium.course.pages;

import com.selenium.course.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static com.selenium.course.common.CommonUIMethods.check;
import static com.selenium.course.common.CommonUIMethods.uncheck;
import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

/**
 * Created by Andrea Castro on 6/12/2015.
 */
public class NewProductForm {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//h1[contains(.,'Product Edit:')]")
    @CacheLookup
    WebElement ProductTitle;


    @FindBy(id = "Name")
    @CacheLookup
    WebElement productNAmeField;

    @FindBy(id = "ProductCode")
    @CacheLookup
    WebElement productCodeField;

    @FindBy(xpath = "//textarea[@id='Description']")
    @CacheLookup
    WebElement productDescriptionField;

    @FindBy(name = "save")
    @CacheLookup
    WebElement saveBtn;


    public NewProductForm() {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(ProductTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public NewProductForm setNewProductName(String productName) {
        productNAmeField.clear();
        productNAmeField.sendKeys(productName);
        return this;
    }

    public NewProductForm setProductDescriptionField(String productDescription) {
        productDescriptionField.clear();
        productDescriptionField.sendKeys(productDescription);
        return this;
    }

    public NewProductForm setProductCodeField(String productCode) {
        productCodeField.clear();
        productCodeField.sendKeys(productCode);
        return this;
    }

    public NewProductForm setStatus(boolean status) {
        if (status) {
            check(By.id("IsActive"));
        } else {
            uncheck(By.id("IsActive"));
        }
        return this;
    }

    public ProductDetail clickSave() {
        saveBtn.click();
        return new ProductDetail();
    }


}

