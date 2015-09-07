package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Title:
 * Cretate 
 *
 * @author Elmer A.
 *
 */
 
public class CreateLeadView
{
	private LoginPage loginPage;
	private ContentPage contentPage;
	private TabPage leadTab;
	private LeadViewForm leadViewForm;
	private LeadViewDetail leadViewDetail;
	private String viewName="AutoView01";
	private String viewUniqueName="AutoView01";
	
	@BeforeClass
    public void setUp() {
    	loginPage = new LoginPage();
    	contentPage = loginPage.loginAsPrimaryUser();
    }

	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void CreateLeadViewTc()
	{
		leadTab = contentPage.tabBar.clickLeadsTab();
		leadViewForm = new LeadViewForm(leadTab.clickCreateNewViewLink().getDriver());
		leadViewForm.setViewNameText(viewName).setViewUniqueNameText(viewUniqueName);

		leadViewDetail = new LeadViewDetail(leadViewForm.clickSaveView().getDriver());

		Assert.assertEquals(leadViewDetail.getViewName(), viewName);
	}

	@AfterClass
    public void tearDown() {
		leadTab = leadViewDetail.clickDeleteViewLink();
		leadTab.goToNavigationLinks().clickLogoutBtn();
    }
}
