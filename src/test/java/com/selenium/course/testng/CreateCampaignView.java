package com.selenium.course.testng;

import com.selenium.course.framework.WebDriverManager;
import com.selenium.course.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created for Joel Rodriguez
 */

public class CreateCampaignView {

    private CampaignsViewDetails campaignsViewDetails;
    private TabPage campaignsPage;

    String viewName = "ViewTesting123";
    String uniqueName = "UniqueViewTesting123";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        campaignsPage = contentPage.tabBar.clickCampaigns();
        campaignsPage.clickCreateNewViewLink();
    }

    @Test(groups = {"BVT, Acceptance, Funcional"})
    public void testCreateNewCampaign() {
        WebDriver driver = WebDriverManager.getInstance().getDriver();

        CampaignsViewForm campaignsViewForm = (CampaignsViewForm) new CampaignsViewForm(driver)
                .setViewName(viewName)
                .setUniqueViewName(uniqueName);
        campaignsViewDetails = new CampaignsViewDetails(campaignsViewForm.clickSaveView().getDriver());

        assertTrue(campaignsViewDetails.existViewName(viewName));
    }

    @AfterClass
    public void tearDown() {
        campaignsPage = campaignsViewDetails.clickDeleteViewLink();
        campaignsPage.goToNavigationLinks().clickLogoutBtn();
    }
}