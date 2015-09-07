package com.selenium.course.testng;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.course.pages.LeadDetail;
import com.selenium.course.pages.LeadEdit;
import com.selenium.course.pages.LeadsPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.ContentPage;
import com.selenium.course.pages.NewLeadBuilder;
import com.selenium.course.pages.NewLeadForm;
import com.selenium.course.pages.TabBar;
import com.selenium.course.pages.ToolBar;

/**
 * Title:
 * Edit Lead
 *
 * @author Gustavo Cavero 
 *
 */
 
public class EditLead {/*
	
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
	private LeadEdit leadEdit;
	String campaingName;
	String leadName;
	String companyName;
	
	
	@BeforeClass
    public void setUp() {
    	loginPage = new LoginPage();
        campaingName = "newCampaing";
    	contentPage = loginPage.loginAsPrimaryUser();
        tabBar = contentPage.goToTabBar();
        //campaignsPage = tabBar.clickCampaigns();
        newCampaignForm = campaignsPage.clickNewCampaign();
        campaingDetail = newCampaignForm.setCampaignName(campaingName)
				.setStatus(true)
				.clickSaveCampaign();
        toolBar = contentPage.goToToolBar();
		toolBar.goToSales();
		tabBar = contentPage.goToTabBar();
		
		String salutation = "Mr.";
		leadName = "newLead";
		companyName = "myCompany";
		
		//leadsPage = tabBar.clickLeadsTab();
		newLeadForm = leadsPage.clickNewLead();
		newLeadForm = new NewLeadBuilder(leadName, companyName)
										.setSalutation(salutation)
										.setCampaign(campaingName).build();
		leadDetail = newLeadForm.createLead();
    }
	
	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void testUntitled() {
		String salutationEdited = "Ms.";
		String leadNameEdited = "newLeadEdited";
		String companyNameEdited = "myCompanyEdited";
		
		leadEdit = leadDetail.clickEdit();
		newLeadForm = new NewLeadBuilder(leadNameEdited, companyNameEdited)
										.setSalutation(salutationEdited).build();
		leadDetail = newLeadForm.createLead();
		
		assertTrue(leadDetail.verifyName(salutationEdited, leadNameEdited));
		assertTrue(leadDetail.verifyCompany(companyNameEdited));
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
