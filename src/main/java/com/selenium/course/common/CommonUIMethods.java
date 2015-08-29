package com.selenium.course.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.course.framework.WebDriverManager;

public class CommonUIMethods {

	/**
	 * This method check an element
	 * 
	 * @param locator
	 */
	public static void check(By locator) {
		WebElement checkBox = WebDriverManager.getInstance().getDriver()
				.findElement(locator);
		if (!checkBox.isSelected()) {
			checkBox.click();
		}
	}

	/**
	 * This method uncheck an element
	 * 
	 * @param locator
	 */
	public static void uncheck(By locator) {
		WebElement checkBox = WebDriverManager.getInstance().getDriver()
				.findElement(locator);
		if (checkBox.isSelected()) {
			checkBox.click();
		}
	}
	
	/**
     * This method select a RadiosButton
     * @param by
     */
    public static void selectRadioButton(By by)
    {
    	/*Conditional to verify that a radio button is not selected, then, select radio button */ 
        if (!WebDriverManager.getInstance().getDriver().findElement(by).isSelected())
        {
            WebDriverManager.getInstance().getDriver().findElement(by).click();
        }
    }
}
