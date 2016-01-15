package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Rina Espinoza on 8/29/2015.
 */
public class ObjectFormPage extends FormPage {

    public ObjectFormPage(WebDriver driver) {
        super(driver);
    }

    public ObjectFormPage clickSaveNewBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(saveNewBtn));
        saveNewBtn.click();
        return new ObjectFormPage(driver);
    }

    public ObjectDetailsPage clickSaveBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(saveBtn));
        saveBtn.click();
        return new ObjectDetailsPage(driver);
    }

}
