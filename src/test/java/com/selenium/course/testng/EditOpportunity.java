package com.selenium.course.testng;

import com.selenium.course.framework.WebDriverManager;
import com.selenium.course.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 *  Created for Joel Rodriguez
 */

public class EditOpportunity {

    private OpportunityDetailsForm opportunityDetailsForm;

    String name, stage, date, type, leadSource, amount;

    @BeforeClass
    public void setUp() {
        name = "NewOpportunity01";
        stage = "Prospecting";
        date = "8/30/2015";
        type = "New Customer";
        leadSource = "Web";
        amount = "15";

        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        TabBar tabBar = contentPage.goToTabBar();
        TabPage opportunitiesPage = tabBar.clickOpportunities();
        opportunitiesPage.clickNewBtn();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        opportunityDetailsForm = new OpportunityMainForm(driver)
                .setOpportunityName(name)
                .setOpportunityCloseDate(date)
                .setOpportunityStage(stage)
                .setOpportunityType(type)
                .setOpportunityLeadSource(leadSource)
                .setOpportunityAmount(amount)
                .clickSaveOpportunity();
        opportunityDetailsForm.editOpportunity();
    }

    @Test
    public void testUntitled() {
        name = "OpportunityEdited";
        stage = "Qualification";
        date = "9/3/2015";
        type = "Existing Customer - Upgrade";
        leadSource = "Other";
        amount = "1500";

        WebDriver driver = WebDriverManager.getInstance().getDriver();

        opportunityDetailsForm = new OpportunityMainForm(driver)
                .setOpportunityName(name)
                .setOpportunityCloseDate(date)
                .setOpportunityStage(stage)
                .setOpportunityType(type)
                .setOpportunityLeadSource(leadSource)
                .setOpportunityAmount(amount)
                .clickSaveOpportunity();

        assertTrue(opportunityDetailsForm.verifyNewOpportunity(name));
    }

    @AfterClass
    public void tearDown() {
        opportunityDetailsForm.deleteOpportunity();
    }
}
