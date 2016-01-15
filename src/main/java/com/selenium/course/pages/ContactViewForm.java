package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Nelson Tapia on 9/4/2015.
 */
public class ContactViewForm extends ObjectFormPage {
    private Select selectField1;
    private Select selectField2;
    private Select selectField3;
    private Select selectField4;
    private Select selectField5;

    private Select selectOption1;
    private Select selectOption2;
    private Select selectOption3;
    private Select selectOption4;
    private Select selectOption5;

    @FindBy(id = "fname")
    @CacheLookup
    private WebElement viewNameText;

    @FindBy(id = "devname")
    @CacheLookup
    private WebElement viewUniqueNameText;

    @FindBy(id = "fscope0")
    @CacheLookup
    private WebElement allContacts;

    @FindBy(id = "fscope1")
    @CacheLookup
    private WebElement myContacts;

    @FindBy(id = "fentityvalue2")
    @CacheLookup
    private WebElement campaingName;

    @FindBy(id = "fcol1")
    @CacheLookup
    private WebElement field1;

    @FindBy(id = "fcol2")
    @CacheLookup
    private WebElement field2;

    @FindBy(id = "fcol3")
    @CacheLookup
    private WebElement field3;

    @FindBy(id = "fcol4")
    @CacheLookup
    private WebElement field4;

    @FindBy(id = "fcol5")
    @CacheLookup
    private WebElement field5;

    @FindBy(id = "fop1")
    @CacheLookup
    private WebElement option1;

    @FindBy(id = "fop1")
    @CacheLookup
    private WebElement option2;

    @FindBy(id = "fop1")
    @CacheLookup
    private WebElement option3;

    @FindBy(id = "fop1")
    @CacheLookup
    private WebElement option4;

    @FindBy(id = "fop1")
    @CacheLookup
    private WebElement option5;

    @FindBy(id = "fval1")
    @CacheLookup
    private WebElement value1;

    @FindBy(id = "fval1")
    @CacheLookup
    private WebElement value2;

    @FindBy(id = "fval1")
    @CacheLookup
    private WebElement value3;

    @FindBy(id = "fval1")
    @CacheLookup
    private WebElement value4;

    @FindBy(id = "fval1")
    @CacheLookup
    private WebElement value5;

    @FindBy(name = "del")
    @CacheLookup
    private WebElement deleteBtn;

    @FindBy(name = "edit")
    @CacheLookup
    private WebElement editBtn;

    public ContactViewForm(WebDriver driver) {
        super(driver);

//        try {
//            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
//                    ExpectedConditions.visibilityOf(newContactTitle));  //no encuentra newContacTitle
//        } catch (WebDriverException e) {
//            throw new WebDriverException(e);
//        } finally {
//            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
//        }

    }

    public ContactViewForm setViewNameText(String fieldValue){
        this.driver = setTextFieldValue(viewNameText,fieldValue);
        return  this;
    }

    public ContactViewForm setViewUniqueNameText(String fieldValue){
        this.driver = setTextFieldValue(viewUniqueNameText,fieldValue);
        return this;
    }

    public ContactViewForm setAllContact(){
        allContacts.click();
        return this;
    }

    public ContactViewForm setMyContact(){
        this.driver = setRadioButton(myContacts);
        return this;
    }

    public ContactViewForm setCampaingName(String fieldValue){
        campaingName.clear();
        campaingName.sendKeys(fieldValue);
        return this;
    }

    public ContactViewForm setField1(String fieldValue){
        this.driver = selectListValue(field1,fieldValue);
        return this;
    }

    public ContactViewForm setField2(String fieldValue){
        this.driver = selectListValue(field2,fieldValue);
        return this;
    }

    public ContactViewForm setOption1(String fieldValue){
        this.driver = selectListValue(option1,fieldValue);
        return this;
    }
    public ContactViewForm setOption2(String fieldValue){
        this.driver = selectListValue(option2,fieldValue);
        return this;
    }

    public ContactViewForm setValue1(String fieldValue){
        this.driver = setTextFieldValue(value1,fieldValue);
        return this;
    }
    public ContactViewForm setValue2(String fieldValue){
        this.driver = setTextFieldValue(value2,fieldValue);
        return this;
    }
}
