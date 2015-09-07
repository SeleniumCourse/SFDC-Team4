package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Title:
 * Cretate Lead
 *
 * @author Elmer A.
 *
 */
 
public class CreateLead
{
	private LoginPage loginPage;
	private ContentPage contentPage;
	private TabPage leadTab;
	private LeadDetail leadDetail;
	private CampaignsMainForm campaignsMainForm;
	private LeadForm leadForm;

	private String campaingName;
	private final String firstName= "newLead";
	private final String lastName= "LastName";
	private final String companyName= "myCompany";
	private final String title="autoTitle";

	@BeforeClass
    public void setUp() {
    	loginPage = new LoginPage();
        campaingName = "newCampaing";
    	contentPage = loginPage.loginAsPrimaryUser();
    }

	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void CreateLeadTc() {
		//String salutation = "Mr.";
		String leadNameToVerify = firstName+" "+lastName;

		leadTab = contentPage.tabBar.clickLeadsTab();
		leadForm = new LeadForm(leadTab.clickNewBtn().getDriver());
		leadForm.setFisrtName(firstName)
				.setLastName(lastName)
				.setCompany(companyName).setTitle(title);
		leadDetail = new LeadDetail(leadForm.clickSaveBtn().getDriver());
		Assert.assertEquals(leadDetail.getObjectName(), leadNameToVerify);
	}

	@AfterClass
    public void tearDown() {
		leadTab = leadDetail.clickDeleteBtn();
		leadTab.navigationLinks.clickLogoutBtn();
    }
}
