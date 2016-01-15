package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Elmer A. on 9/7/2015.
 */
public class ProductDetail extends ObjectDetailsPage
{
    @FindBy(id = "Name_ilecell")
    @CacheLookup
    private WebElement productName;

    @FindBy(id = "ProductCode_ileinner")
    @CacheLookup
    private WebElement productCode;


    public ProductDetail(WebDriver driver) {
        super(driver);
    }

    public String getProductName()
    {
        return productName.getText();
    }

    public String getProductCode()
    {
        return productCode.getText();
    }
}
