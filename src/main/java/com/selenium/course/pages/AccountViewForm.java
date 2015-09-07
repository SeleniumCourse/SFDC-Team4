package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Rina Espinoza on 8/30/2015.
 */
public class AccountViewForm extends ViewFormPage {
    @FindBy(id = "fname")
    @CacheLookup
    private WebElement viewNameText;

    @FindBy(id = "devname")
    @CacheLookup
    private WebElement viewUniqueNameText;

    @FindBy(id = "fcol1")
    @CacheLookup
    private WebElement filterAccountName;

    @FindBy(id = "fop1")
    @CacheLookup
    private WebElement filterAccountOption;

    @FindBy(id = "fval1")
    @CacheLookup
    private WebElement filterAccountValue;

    @FindBy(id = "fscope1")
    @CacheLookup
    private WebElement myAccountsRadioBtn;

    @FindBy(id = "colselector_select_0")
    @CacheLookup
    private WebElement availableFields;

    @FindBy(id = "colselector_select_1")
    @CacheLookup
    private WebElement selectedFields;

    public AccountViewForm(WebDriver driver) {
        super(driver);
    }

    public AccountViewForm setViewNameText(String fieldValue) {
        this.driver = setTextFieldValue(viewNameText, fieldValue);
        return this;
    }

    public AccountViewForm setViewUniqueNameText(String fieldValue) {
        this.driver = setTextFieldValue(viewUniqueNameText, fieldValue);
        return this;
    }

    public AccountViewForm setFilterAccountName(String fieldValue) {
        this.driver = selectListValue(filterAccountName, "Account Name");
        this.driver = selectListValue(filterAccountOption, "contains");
        this.driver = setTextFieldValue(filterAccountValue, fieldValue);
        return this;
    }

    public AccountViewForm setMyAccounts() {
        this.driver = setRadioButton(myAccountsRadioBtn);
        return this;
    }

    public AccountViewForm setSelectedFields(List<String> selectedOptions) {
        this.driver = setMultiSelectValue(availableFields, selectedOptions);
        this.driver = clickAddMultiSelection();
        return this;
    }
}
