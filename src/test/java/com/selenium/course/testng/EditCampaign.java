package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.course.pages.CampaignEdit;
import com.selenium.course.pages.CampaingDetail;
import com.selenium.course.pages.CampaingsPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.NewCampaignForm;
import com.selenium.course.pages.PageMenuBar;

/**
 * Title:
 * Edit Campaign
 *
 * @author Gustavo Cavero 
 *
 */
 
public class EditCampaign {
	private LoginPage loginPage;
	private MainApp mainApp;
	private PageMenuBar pageMenuBar;
	private CampaingsPage campaignsPage;
	private NewCampaignForm newCampaignForm;
	private CampaingDetail campaingDetail;
	private CampaignEdit campaignEdit;
	String campaingName;
	
	@BeforeClass
    public void setUp() {
		loginPage = new LoginPage();
		mainApp = loginPage.loginAsPrimaryUser();
        pageMenuBar = mainApp.goToPageMenuBar();
        campaignsPage = pageMenuBar.clickCampaings();
        
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

}
