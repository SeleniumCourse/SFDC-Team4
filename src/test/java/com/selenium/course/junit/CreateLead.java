package com.selenium.course.junit;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.selenium.course.pages.CampaingDetail;
import com.selenium.course.pages.CampaingsPage;
import com.selenium.course.pages.CampaingsTablePage;
import com.selenium.course.pages.LeadDetail;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.NewLeadForm;
import com.selenium.course.pages.PageMenuBar;
import com.selenium.course.pages.ToolBar;
import com.selenium.course.pages.NewCampaignForm;
import com.selenium.course.pages.LeadsPage;

public class CreateLead {
	private LoginPage loginPage;
	private MainApp mainApp;
	private PageMenuBar pageMenuBar;
	private LeadsPage leadsPage;
	private ToolBar toolBar;
	private CampaingsPage campaignsPage;
	private NewCampaignForm newCampaignForm;
	private NewLeadForm newLeadForm;
	private LeadDetail leadDetail;
	private CampaingsTablePage campaignsTablePage;
	private CampaingDetail campaingDetail;
	String campaingName;
	String leadName;
	String companyName;
	
	
	@Before
    public void setUp() {
    	loginPage = new LoginPage();
    	String email = "gcavero@hotmail.com";
        String password = "Gus.jala1";
        campaingName = "newCampaing";
        mainApp = loginPage.loginAs(email, password);
        pageMenuBar = mainApp.goToPageMenuBar();
        campaignsPage = pageMenuBar.clickCampaings();
        newCampaignForm = campaignsPage.clickNewCampaign();
        campaingDetail = newCampaignForm.createNewCampaign(campaingName, true);
        toolBar = mainApp.goToTolBar();
		toolBar.goToSales();
		pageMenuBar = mainApp.goToPageMenuBar();
    }
	
	@Test
    public void testUntitled() {
		String salutation = "Mr.";
		leadName = "newLead";
		companyName = "myCompany";
		
		leadsPage = pageMenuBar.clickLeadsTab();
		newLeadForm = leadsPage.clickNewLead();
		leadDetail = newLeadForm.createNewLead(salutation, leadName, companyName, campaingName);
		
		assertTrue(leadDetail.verifyName(salutation, leadName));
		assertTrue(leadDetail.verifyCompany(companyName));
		assertTrue(leadDetail.verifyCampaing(campaingName));
	}
	
	@After
    public void tearDown() {
		leadDetail.clickDelete();
		pageMenuBar = mainApp.goToPageMenuBar();		
		campaignsPage = pageMenuBar.clickCampaings();		
		campaignsTablePage = campaignsPage.clickGo();
		campaingDetail = campaignsTablePage.clickCampaing(campaingName);
		campaingDetail.deleteCampaign();
		
    }
}
