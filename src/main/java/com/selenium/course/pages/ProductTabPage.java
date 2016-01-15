package com.selenium.course.pages;

import com.selenium.course.pages.ObjectFormPage;
import com.selenium.course.pages.TabPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Nelson Tapia on 07/09/2015.
 */
public class ProductTabPage extends TabPage {

    @FindBy(xpath = "//a[contains(@href,'/ui/list/FilterEditPage?ftype=Product2&retURL=%2F01t&cancelURL=%2F01t%2Fo')]")
    @CacheLookup
    private WebElement createNewViewLinkProduct;

    public ProductTabPage(WebDriver driver) {
        super(driver);
    }

    public ObjectFormPage clickCreateNewViewLinkProduct() {
        wait.until(ExpectedConditions
                .visibilityOf(createNewViewLinkProduct));
        createNewViewLinkProduct.click();
        return new ObjectFormPage(driver);
    }

}
