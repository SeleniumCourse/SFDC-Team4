package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Joel Rodriguez
 */

public class OpportunityViewDetails extends ViewDetailsPage {

    public OpportunityViewDetails(WebDriver driver) {
        super(driver);
    }

    public Boolean existViewName(String value) {
        Boolean result = false;
        try {
            Select select = new Select(driver.findElement(By.className("title")));
            select.selectByVisibleText(value);
            result = true;
        } catch (WebDriverException e) {
            result = false;
        } finally {
            return result;
        }
    }
}
