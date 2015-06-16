package com.selenium.course.junit;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	
	@Before
    public void setUp() {
		loginPage = new LoginPage();
    	String email = "gcavero@hotmail.com";
        String password = "Gus.jala1";
        campaingName = "newCampaing";
        mainApp = loginPage.loginAs(email, password);
        pageMenuBar = mainApp.goToPageMenuBar();
        campaignsPage = pageMenuBar.clickCampaings();
    }
	
	@Test
    public void testUntitled() {
		newCampaignForm = campaignsPage.clickNewCampaign();
		campaingDetail = newCampaignForm.createNewCampaign(campaingName, true);
		
		assertTrue(campaingDetail.verifyNewCampaign(campaingName));
	}
	
	@After
    public void tearDown() {
		campaingDetail.deleteCampaign();
    }

}
