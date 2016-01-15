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

public class CreateCampaign {

    private CampaignDetails campaignDetails;
    private TabPage campaignsPage;

    String campaignName = "CampaignTesting123";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        campaignsPage = contentPage.tabBar.clickCampaigns();
        campaignsPage.clickNewBtn().getDriver();
    }

    @Test(groups = {"BVT, Acceptance, Funcional"})
    public void testCreateNewCampaign() {
        WebDriver driver = WebDriverManager.getInstance().getDriver();

        campaignDetails = new CampaignsForm(driver)
                .setCampaignName(campaignName)
                .clickSaveCampaign();

        assertTrue(campaignDetails.verifyNewCampaign(campaignName));
    }

    @AfterClass
    public void tearDown() {
        campaignsPage = campaignDetails.clickDeleteOppBtn();
        campaignsPage.goToNavigationLinks().clickLogoutBtn();
    }
}