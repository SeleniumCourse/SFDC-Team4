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

    private OpportunityDetailsForm opportunityDetailsForm;


    String name, stage, date, type, leadSource, amount, nextstep;

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        TabBar tabBar = contentPage.goToTabBar();
        TabPage opportunitiesPage = tabBar.clickOpportunities();
        opportunitiesPage.clickNewBtn();
    }

    @Test
    public void testUntitled() {
        name = "NewOpportunity";
        stage = "Prospecting";
        date = "8/30/2015";
        type = "New Customer";
        leadSource = "Web";
        amount = "15";
        nextstep = "Step";

        WebDriver driver = WebDriverManager.getInstance().getDriver();

        opportunityDetailsForm = new OpportunityMainForm(driver)
                .setOpportunityName(name)
                .setOpportunityCloseDate(date)
                .setOpportunityStage(stage)
                .clickSaveOpportunity();

        assertTrue(opportunityDetailsForm.verifyNewOpportunity(name));
    }

    @AfterClass
    public void tearDown() {
        opportunityDetailsForm.deleteOpportunity();
    }
}
