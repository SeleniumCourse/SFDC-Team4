package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.*;

import com.selenium.course.pages.CampaingDetail;
import com.selenium.course.pages.CampaingsPage;
import com.selenium.course.pages.CampaingsTablePage;
import com.selenium.course.pages.LeadDetail;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.NewLeadBuilder;
import com.selenium.course.pages.NewLeadForm;
import com.selenium.course.pages.PageMenuBar;
import com.selenium.course.pages.ToolBar;
import com.selenium.course.pages.NewCampaignForm;
import com.selenium.course.pages.LeadsPage;

/**
 * Title:
 * Cretate Lead
 *
 * @author Gustavo Cavero 
 *
 */
 
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
	
	
	@BeforeClass
    public void setUp() {
    	loginPage = new LoginPage();
        campaingName = "newCampaing";
    	mainApp = loginPage.loginAsPrimaryUser();
        pageMenuBar = mainApp.goToPageMenuBar();
        campaignsPage = pageMenuBar.clickCampaings();
        newCampaignForm = campaignsPage.clickNewCampaign();
        campaingDetail = newCampaignForm.setCampaignName(campaingName)
				.setStatus(true)
				.clickSaveCampaign();
        toolBar = mainApp.goToTolBar();
		toolBar.goToSales();
		pageMenuBar = mainApp.goToPageMenuBar();
    }
	
	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void testUntitled() {
		String salutation = "Mr.";
		leadName = "newLead";
		companyName = "myCompany";
		
		leadsPage = pageMenuBar.clickLeadsTab();
		newLeadForm = leadsPage.clickNewLead();
		newLeadForm = new NewLeadBuilder(leadName, companyName)
										.setSalutation(salutation)
										.setCampaign(campaingName).build();
		leadDetail = newLeadForm.createLead();
//		leadDetail = newLeadForm.selectSalutation(salutation)
//								.setLastName(leadName)
//								.setCompany(companyName)
//								.setCampaing(campaingName).clickSaveLead();
		
		assertTrue(leadDetail.verifyName(salutation, leadName));
		assertTrue(leadDetail.verifyCompany(companyName));
		assertTrue(leadDetail.verifyCampaing(campaingName));
	}
	
	@AfterClass
    public void tearDown() {
		leadDetail.clickDelete();
		pageMenuBar = mainApp.goToPageMenuBar();		
		campaignsPage = pageMenuBar.clickCampaings();		
		campaignsTablePage = campaignsPage.clickGo();
		campaingDetail = campaignsTablePage.clickCampaing(campaingName);
		campaingDetail.deleteCampaign();	
    }
}
