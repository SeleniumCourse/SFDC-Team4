package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.*;

import com.selenium.course.pages.LeadDetail;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.ContentPage;
import com.selenium.course.pages.NewLeadBuilder;
import com.selenium.course.pages.NewLeadForm;
import com.selenium.course.pages.TabBar;
import com.selenium.course.pages.ToolBar;
import com.selenium.course.pages.LeadsPage;

/**
 * Title:
 * Cretate Lead
 *
 * @author Gustavo Cavero 
 *
 */
 
public class CreateLead {/*
	private LoginPage loginPage;
	private ContentPage contentPage;
	private TabBar tabBar;
	private LeadsPage leadsPage;
	private ToolBar toolBar;
	private CampaignsPage campaignsPage;
	private NewCampaignForm newCampaignForm;
	private NewLeadForm newLeadForm;
	private LeadDetail leadDetail;
	private CampaingsTablePage campaignsTablePage;
	private CampaingDetail campaingDetail;
	String campaingName;
	String leadName;
	String companyName;
	
	
	@BeforeClass
    public void setUp() {
    	loginPage = new LoginPage();
        campaingName = "newCampaing";
    	contentPage = loginPage.loginAsPrimaryUser();
        tabBar = contentPage.goToTabBar();
        campaignsPage = tabBar.clickCampaigns();
        newCampaignForm = campaignsPage.clickNewCampaign();
        campaingDetail = newCampaignForm.setCampaignName(campaingName)
				.setStatus(true)
				.clickSaveCampaign();
        toolBar = contentPage.goToToolBar();
		toolBar.goToSales();
		tabBar = contentPage.goToTabBar();
    }
	
	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void testUntitled() {
		String salutation = "Mr.";
		leadName = "newLead";
		companyName = "myCompany";
		
		leadsPage = tabBar.clickLeadsTab();
		newLeadForm = leadsPage.clickNewLead();
		newLeadForm = new NewLeadBuilder(leadName, companyName)
										.setSalutation(salutation)
										.setCampaign(campaingName).build();
		leadDetail = newLeadForm.createLead();
		
		assertTrue(leadDetail.verifyName(salutation, leadName));
		assertTrue(leadDetail.verifyCompany(companyName));
		assertTrue(leadDetail.verifyCampaing(campaingName));
	}
	
	@AfterClass
    public void tearDown() {
		leadDetail.clickDelete();
		tabBar = contentPage.goToTabBar();
		campaignsPage = tabBar.clickCampaigns();
		campaignsTablePage = campaignsPage.clickGo();
		campaingDetail = campaignsTablePage.clickCampaing(campaingName);
		campaingDetail.deleteCampaign();	
    }*/
}
