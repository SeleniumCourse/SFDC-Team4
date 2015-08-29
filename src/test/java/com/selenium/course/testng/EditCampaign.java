package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.course.pages.CampaignEdit;
import com.selenium.course.pages.CampaingDetail;
import com.selenium.course.pages.CampaignsPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.ContentPage;
import com.selenium.course.pages.NewCampaignForm;
import com.selenium.course.pages.TabBar;

/**
 * Title:
 * Edit Campaign
 *
 * @author Gustavo Cavero 
 *
 */
 
public class EditCampaign {/*
	private LoginPage loginPage;
	private ContentPage contentPage;
	private TabBar tabBar;
	private CampaignsPage campaignsPage;
	private NewCampaignForm newCampaignForm;
	private CampaingDetail campaingDetail;
	private CampaignEdit campaignEdit;
	String campaingName;
	
	@BeforeClass
    public void setUp() {
		loginPage = new LoginPage();
		contentPage = loginPage.loginAsPrimaryUser();
        tabBar = contentPage.goToTabBar();
        campaignsPage = tabBar.clickCampaigns();
        
        campaingName = "NewCampaignTest";
		newCampaignForm = campaignsPage.clickNewCampaign();
		campaingDetail = newCampaignForm.setCampaignName(campaingName)
				.setStatus(true)
				.clickSaveCampaign();
    }
	
	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void testUntitled() {
		String editedCampaign = "NewCampaignEdited";
		campaignEdit = campaingDetail.clickEdit();
		campaingDetail = newCampaignForm.setCampaignName(editedCampaign)
				.setStatus(false)
				.clickSaveCampaign();			
		
		assertTrue(campaingDetail.verifyNewCampaign(editedCampaign));
	}
	
	@AfterClass
    public void tearDown() {
		campaingDetail.deleteCampaign();
    }
*/
}
