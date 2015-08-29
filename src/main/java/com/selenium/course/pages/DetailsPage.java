package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public class DetailsPage extends ContentPage {
    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    // this can be used to send the webelements find by id or name
    public String getFieldValue(WebElement field) {
        return field.getText();
    }
}
