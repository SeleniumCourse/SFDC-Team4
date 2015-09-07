package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;

import com.selenium.course.framework.WebDriverManager;

import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

public class LeadsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    Select selectBox;

    @FindBy(xpath = "//h1[contains(.,'Leads:')]")
    WebElement leadsTitle;

    @FindBy(xpath = "//a[contains(.,'Create New View')]")
    WebElement newViewLink;

    @FindBy(xpath = "//h2[contains(.,' Create New View')]")
    WebElement newNewLabel;

    @FindBy(xpath = "//input[@id='fname']")
    WebElement viewName;

    @FindBy(id = "colselector_select_0_right")
    WebElement addFields;

    @FindBy(xpath = "//input[@name='save']")
    WebElement saveBtn;

    @FindBy(linkText = "Delete")
    WebElement deleteView;

    @FindBy(name = "fcf")
    WebElement comboBox;

    @FindBy(name = "new")
    WebElement newBtn;

    public LeadsPage() {
        wait = WebDriverManager.getInstance().getWait();
        driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(leadsTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public void clickOnCreateNewView() {
        newViewLink.click();
        wait.until(ExpectedConditions.visibilityOf(newNewLabel));
    }

    public void setName(String name) {
        viewName.clear();
        viewName.sendKeys(name);
    }

    public void setOwner(String Scope) {
        WebElement myLeads =
                driver.findElement(By.xpath("//input[@id='fscope" + Scope + "']"));

        // Verify if the checkbox is already selected
        if (!myLeads.isSelected()) {
            myLeads.click();
        }
    }

    public void SelectFields() {
        selectBox =
                new Select(driver.findElement(By.id("colselector_select_0")));

        selectBox.selectByVisibleText("First Name");
        selectBox.selectByVisibleText("Last Name");

        addFields.click();
    }

    public void clickSave() {
        saveBtn.click();
        wait.until(ExpectedConditions.visibilityOf(comboBox));
    }

    public boolean verifyCreatedView(String viewName) {
        wait.until(ExpectedConditions.visibilityOf(comboBox));
        selectBox = new Select(comboBox);
        selectBox.selectByVisibleText(viewName);
        return selectBox.getFirstSelectedOption().getText().equals(viewName);
    }

    public void deleteView(String viewName) {
        selectBox = new Select(comboBox);
        selectBox.selectByVisibleText(viewName);
        deleteView.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public NewLeadForm clickNewLead() {
        newBtn.click();
        return new NewLeadForm();
    }

}
