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

    private OpportunityDetails opportunityDetails;
    private TabPage opportunitiesPage;

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
        opportunitiesPage = contentPage.tabBar.clickOpportunities();
        opportunitiesPage.clickNewBtn();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        opportunityDetails = new OpportunityForm(driver)
                .setOpportunityName(name)
                .setOpportunityCloseDate(date)
                .setOpportunityStage(stage)
                .setOpportunityType(type)
                .setOpportunityLeadSource(leadSource)
                .setOpportunityAmount(amount)
                .clickSaveOpportunity();
        opportunityDetails.editOpportunity();
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

        opportunityDetails = new OpportunityForm(driver)
                .setOpportunityName(name)
                .setOpportunityCloseDate(date)
                .setOpportunityStage(stage)
                .setOpportunityType(type)
                .setOpportunityLeadSource(leadSource)
                .setOpportunityAmount(amount)
                .clickSaveOpportunity();

        assertTrue(opportunityDetails.verifyNewOpportunity(name));
    }

    @AfterClass
    public void tearDown() {
        opportunitiesPage = opportunityDetails.deleteOpportunity();
        opportunitiesPage.goToNavigationLinks().clickLogoutBtn();
    }
}
