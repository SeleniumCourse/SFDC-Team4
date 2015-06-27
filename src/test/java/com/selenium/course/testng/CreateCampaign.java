package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.*;

import com.selenium.course.pages.CampaingDetail;
import com.selenium.course.pages.CampaingsPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.NewCampaignForm;
import com.selenium.course.pages.PageMenuBar;

public class CreateCampaign {
	private LoginPage loginPage;
	private MainApp mainApp;
	private PageMenuBar pageMenuBar;
	private CampaingsPage campaignsPage;
	private NewCampaignForm newCampaignForm;
	private CampaingDetail campaingDetail;
	String campaingName;
	
	@BeforeClass
    public void setUp() {
		loginPage = new LoginPage();
		mainApp = loginPage.loginAsPrimaryUser();
        pageMenuBar = mainApp.goToPageMenuBar();
        campaignsPage = pageMenuBar.clickCampaings();
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
    }
}
