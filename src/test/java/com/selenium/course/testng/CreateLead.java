package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;

import com.selenium.course.pages.*;
import org.testng.annotations.*;

/**
 * Title:
 * Cretate Lead
 *
 * @author
 *
 */
 
public class CreateLead {


	private LoginPage loginPage;
	private ContentPage contentPage;
	private TabBar tabBar;
	private LeadsPage leadsPage;
	private ToolBar toolBar;
	private CampaignsPage campaignsPage;

	private LeadForm leadForm;
	/*
	private NewCampaignForm newCampaignForm;
	private NewLeadForm newLeadForm;
	private LeadDetail leadDetail;
	private CampaingsTablePage campaignsTablePage;
	private CampaingDetail campaingDetail;
	*/
	String campaingName;
	String firstName;
	String lastName;
	String companyName;

	@BeforeClass
    public void setUp() {
    	loginPage = new LoginPage();
        campaingName = "newCampaing";
    	contentPage = loginPage.loginAsPrimaryUser();
        tabBar = contentPage.goToTabBar();
        /*
		campaignsPage = tabBar.clickCampaigns();
        newCampaignForm = campaignsPage.clickNewCampaign();
        campaingDetail = newCampaignForm.setCampaignName(campaingName)
				.setStatus(true)
				.clickSaveCampaign();
        toolBar = contentPage.goToToolBar();
		toolBar.goToSales();
		tabBar = contentPage.goToTabBar();
		*/
    }

	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void testUntitled() {
		String salutation = "Mr.";
		firstName = "newLead";
		lastName = "last Name";
		companyName = "myCompany";

		TabPage tabPage = tabBar.clickLeadsTab();
		leadForm = leadsPage.clickNewLead();
		leadForm.setFisrtName(firstName).setLastName(lastName);
		/*
		newLeadForm = new NewLeadBuilder(leadName, companyName)
										.setSalutation(salutation)
										.setCampaign(campaingName).build();
		*/
		/*leadDetail = newLeadForm.createLead();
		
		assertTrue(leadDetail.verifyName(salutation, leadName));
		assertTrue(leadDetail.verifyCompany(companyName));
		assertTrue(leadDetail.verifyCampaing(campaingName));*/
	}
	/*
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
