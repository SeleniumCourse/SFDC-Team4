package com.selenium.course.testng;

import com.selenium.course.framework.WebDriverManager;
import com.selenium.course.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created for Joel Rodriguez
 */

public class CreateOpportunity {

    private OpportunityDetails opportunityDetails;
    private TabPage opportunitiesPage;

    String name, stage, date, type, leadSource, amount, nextStep;

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        opportunitiesPage = contentPage.tabBar.clickOpportunities();
        opportunitiesPage.clickNewBtn();
    }

    @Test
    public void testUntitled() {
        name = "NewOpportunity";
        stage = "Prospecting";
        date = "8/8/2015";
        type = "New Customer";
        leadSource = "Web";
        amount = "15";
        nextStep = "Step";

        WebDriver driver = WebDriverManager.getInstance().getDriver();

        opportunityDetails = new OpportunityForm(driver)
                .setOpportunityName(name)
                .setOpportunityCloseDate(date)
                .setOpportunityStage(stage)
                .clickSaveOpportunity();

        assertTrue(opportunityDetails.verifyNewOpportunity(name));
    }

    @AfterClass
    public void tearDown() {
        opportunitiesPage = opportunityDetails.deleteOpportunity();
        opportunitiesPage.goToNavigationLinks().clickLogoutBtn();
    }
}
