package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Title:
 * Edit Lead
 *
 * @author Elmer A.
 *
 */
 
public class EditLead
{
	private final String firstName= "Auto Lead";
	private final String lastName= "LastName";
	private final String companyName= "myCompany";

	private String firstNameEdited="Auto Lead Edited";

	private LoginPage loginPage;
	private ContentPage contentPage;
	private TabPage leadTab;
	private LeadDetail leadDetail;
	private CampaignsMainForm campaignsMainForm;
	private LeadForm leadForm;

	@BeforeClass
    public void setUp() {
    	loginPage = new LoginPage();
    	contentPage = loginPage.loginAsPrimaryUser();
		leadTab = contentPage.tabBar.clickLeadsTab();
		leadForm = new LeadForm(leadTab.clickNewBtn().getDriver());
		leadForm.setFisrtName(firstName)
				.setLastName(lastName)
				.setCompany(companyName);
		leadDetail = new LeadDetail(leadForm.clickSaveBtn().getDriver());
    }
	
	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void EditLeadTc() {
		String leadNameToVerify = firstNameEdited+" "+lastName;
		leadForm = new LeadForm(leadDetail.clickEdit().getDriver());
		leadForm.setFisrtName(firstNameEdited);
		leadDetail = new LeadDetail(leadForm.clickSaveBtn().getDriver());
		Assert.assertEquals(leadDetail.getObjectName(), leadNameToVerify);
	}
	
	@AfterClass
    public void tearDown() {
		leadTab = leadDetail.clickDeleteOppBtn();
		leadTab.navigationLinks.clickLogoutBtn();
    }
}
