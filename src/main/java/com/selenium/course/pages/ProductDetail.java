package com.selenium.course.pages;

import com.selenium.course.framework.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrea Castro on 6/12/2015.
 */
public class ProductDetail {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h2[@class='pageDescription']")
    @CacheLookup
    WebElement newProductTitle;

    @FindBy(id = "Name_ileinner")
    @CacheLookup
    WebElement product;

    @FindBy(id = "ProductCode_ileinner")
    @CacheLookup
    WebElement code;

    @FindBy(id = "Description_ileinner")
    @CacheLookup
    WebElement productDescription;

    @FindBy(id = "IsActive_chkbox")
    @CacheLookup
    WebElement checkBox;

    @FindBy(name = "edit")
    @CacheLookup
    WebElement editBtn;


    @FindBy(name = "del")
    @CacheLookup
    WebElement deleteBtn;

    public ProductDetail() {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(3, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(newProductTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
    }

    public boolean verifyName(String productName) {
        wait.until(ExpectedConditions.visibilityOf(product));
        return product.getText().equals(productName);
    }


    public boolean verifyDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(productDescription));
        return productDescription.getText().equals(description);
    }

    public ProductEditPage clickEdit() {
        editBtn.click();
        return new ProductEditPage();
    }

    public ProductsPage clickDelete() {
        deleteBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new ProductsPage();
    }

}
