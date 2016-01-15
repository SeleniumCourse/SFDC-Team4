package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Rina Espinoza on 8/30/2015.
 */
public class AccountViewDetails extends ViewDetailsPage {

    public AccountViewDetails(WebDriver driver) {
        super(driver);
    }
    public Boolean existColumnName(String value)
    {
        Boolean result = false;
        try {
            driver.findElement(By.cssSelector("[title='" + value + "']"));
            result = true;
        } catch (WebDriverException e) {
            result = false;
        } finally {
            return result;
        }
    }
    public Boolean existViewName(String value)
    {
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
