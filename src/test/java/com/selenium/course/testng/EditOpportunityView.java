package com.selenium.course.testng;

import com.selenium.course.framework.WebDriverManager;
import com.selenium.course.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created for Joel Rodriguez
 */

public class EditOpportunityView {

    private OpportunityViewDetails opportunityViewDetails;
    private TabPage opportunityPage;

    String viewName;
    String uniqueName;

    @BeforeClass
    public void setUp() {

        viewName = "NewOpportunityView123";
        uniqueName = "NewOpportunityView321";

        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        opportunityPage = contentPage.tabBar.clickOpportunities();
        opportunityPage.clickCreateNewViewLink();

        WebDriver driver = WebDriverManager.getInstance().getDriver();

        OpportunityViewForm opportunityViewForm = (OpportunityViewForm) new OpportunityViewForm(driver)
                .setViewName(viewName)
                .setUniqueViewName(uniqueName);
        opportunityViewDetails = new OpportunityViewDetails(opportunityViewForm.clickSaveView().getDriver());
        opportunityViewDetails.clickEditViewLink();
    }

    @Test(groups = {"BVT, Acceptance, Funcional"})
    public void testCreateNewCampaign() {

        viewName = "OpportunityViewEdited123";
        uniqueName = "OpportunityViewEdited321";

        WebDriver driver = WebDriverManager.getInstance().getDriver();

        OpportunityViewForm opportunityViewForm = (OpportunityViewForm) new OpportunityViewForm(driver)
                .setViewName(viewName)
                .setUniqueViewName(uniqueName);
        opportunityViewDetails = new OpportunityViewDetails(opportunityViewForm.clickSaveView().getDriver());

        junit.framework.Assert.assertTrue(opportunityViewDetails.existViewName(viewName));
    }

    @AfterClass
    public void tearDown() {
        opportunityPage = opportunityViewDetails.clickDeleteViewLink();
        opportunityPage.goToNavigationLinks().clickLogoutBtn();
    }
}