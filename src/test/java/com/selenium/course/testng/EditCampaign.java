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

public class EditCampaign {

    private CampaignDetails campaignDetails;
    private TabPage campaignsPage;

    String campaignName, type, status, startDate, endDate;

    @BeforeClass
    public void setUp() {
        campaignName = "CampaignTesting123";
        type = "Conference";
        status = "Planned";
        startDate = "6/29/2009";
        endDate = "7/29/2009";

        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        campaignsPage = contentPage.tabBar.clickCampaigns();
        campaignsPage.clickNewBtn();
        WebDriver driver = WebDriverManager.getInstance().getDriver();
        campaignDetails = new CampaignsForm(driver)
                .setCampaignName(campaignName)
                .setCampaignType(type)
                .setCampaignStatus(status)
                .setCampaignStartDate(startDate)
                .setCampaignEndDate(endDate)
                .clickSaveCampaign();
        campaignDetails.editCampaign();

    }

    @Test(groups = {"BVT, Acceptance, Funcional"})
    public void testCreateNewCampaign() {
        campaignName = "CampaignEdited123";
        type = "Webinar";
        status = "In Progress";
        startDate = "6/29/2010";
        endDate = "7/29/2012";

        WebDriver driver = WebDriverManager.getInstance().getDriver();

        campaignDetails = new CampaignsForm(driver)
                .setCampaignName(campaignName)
                .setCampaignType(type)
                .setCampaignStatus(status)
                .setCampaignStartDate(startDate)
                .setCampaignEndDate(endDate)
                .clickSaveCampaign();

        assertTrue(campaignDetails.verifyNewCampaign(campaignName));
    }

    @AfterClass
    public void tearDown() {
        campaignsPage = campaignDetails.clickDeleteOppBtn();
        campaignsPage.goToNavigationLinks().clickLogoutBtn();
    }
}