package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

public class ToolBar extends Page{

    @FindBy(id = "tsidButton")
   	@CacheLookup
   	WebElement tsiButton;
    
    @FindBy(id = "tsid-menuItems")
   	@CacheLookup
   	WebElement menuItems;
    
    public ToolBar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(tsiButton));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }
    
    public void clickOptionButton() {
    	tsiButton.click();
    	wait.until(ExpectedConditions.visibilityOf(menuItems));
    }
    
    public void clickElementOfMenu(String tab) {
    	driver.findElement(By.xpath("//a[text()='" + tab + "']")).click();
    }
    
    public void goToSales() {
		if (!driver.findElement(By.xpath("//span[@id='tsidLabel']")).getText().equals("Sales")) {
			clickOptionButton();
			clickElementOfMenu("Sales");
		}
    }
    

}
