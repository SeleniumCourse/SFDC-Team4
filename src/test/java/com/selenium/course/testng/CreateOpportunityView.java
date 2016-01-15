package com.selenium.course.testng;

import com.selenium.course.framework.WebDriverManager;
import com.selenium.course.pages.*;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created for Joel Rodriguez
 */

public class CreateOpportunityView {
    private OpportunityViewDetails opportunityViewDetails;
    private TabPage opportunityPage;

    String viewName = "ViewTesting123";
    String uniqueName = "UniqueViewTesting123";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        opportunityPage = contentPage.tabBar.clickOpportunities();
        opportunityPage.clickCreateNewViewLink();
    }

    @Test(groups = {"BVT, Acceptance, Funcional"})
    public void testCreateNewCampaign() {
        WebDriver driver = WebDriverManager.getInstance().getDriver();

        OpportunityViewForm opportunityViewForm = (OpportunityViewForm) new OpportunityViewForm(driver)
                .setViewName(viewName)
                .setUniqueViewName(uniqueName);
        opportunityViewDetails = new OpportunityViewDetails(opportunityViewForm.clickSaveView().getDriver());

        Assert.assertTrue(opportunityViewDetails.existViewName(viewName));
    }

    @AfterClass
    public void tearDown() {
        opportunityPage = opportunityViewDetails.clickDeleteViewLink();
        opportunityPage.goToNavigationLinks().clickLogoutBtn();
    }
}