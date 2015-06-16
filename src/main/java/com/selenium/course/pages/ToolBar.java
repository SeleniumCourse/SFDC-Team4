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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.course.framework.DriverManager;

public class ToolBar {
	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(id = "tsidButton")
   	@CacheLookup
   	WebElement tsiButton;
    
    @FindBy(id = "tsid-menuItems")
   	@CacheLookup
   	WebElement menuItems;
    
    public ToolBar(WebDriver driver) {
    	this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        

        try {
            wait.withTimeout(3, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(tsiButton));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
    }
    
    public void clickOptionButton() {
    	tsiButton.click();
    	wait.until(ExpectedConditions.visibilityOf(menuItems));
    }
    
    public void clickElemntOfMenu(String tab) {
    	driver.findElement(By.xpath("//a[text()='" + tab + "']")).click();
    }
    
    public void goToSales() {
		if (!driver.findElement(By.xpath("//span[@id='tsidLabel']")).getText().equals("Sales")) {
			clickOptionButton();
			clickElemntOfMenu("Sales");
		}
    }
    

}
