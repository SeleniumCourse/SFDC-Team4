package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.*;

import com.selenium.course.pages.CampaingDetail;
import com.selenium.course.pages.CampaignsPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.ContentPage;
import com.selenium.course.pages.NewCampaignForm;
import com.selenium.course.pages.TabBar;

/**
 * Title:
 * Cretate Campaign
 *
 * @author Gustavo Cavero 
 *
 */
 
public class CreateCampaign {/*
	private LoginPage loginPage;
	private ContentPage contentPage;
	private TabBar tabBar;
	private CampaignsPage campaignsPage;
	private NewCampaignForm newCampaignForm;
	private CampaingDetail campaingDetail;
	String campaingName;
	
	@BeforeClass
    public void setUp() {
		loginPage = new LoginPage();
		contentPage = loginPage.loginAsPrimaryUser();
        tabBar = contentPage.goToTabBar();
        campaignsPage = tabBar.clickCampaigns();
    }
	
	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void testUntitled() {
		campaingName = "NewCampaign";
		newCampaignForm = campaignsPage.clickNewCampaign();
		campaingDetail = newCampaignForm.setCampaignName(campaingName)
				.setStatus(true)
				.clickSaveCampaign();
		
		assertTrue(campaingDetail.verifyNewCampaign(campaingName));
	}
	
	@AfterClass
    public void tearDown() {
		campaingDetail.deleteCampaign();
    }*/
}
