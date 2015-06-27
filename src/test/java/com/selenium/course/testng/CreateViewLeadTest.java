package com.selenium.course.testng;

import static org.junit.Assert.*;
import org.testng.annotations.*;

import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.PageMenuBar;
import com.selenium.course.pages.ToolBar;
import com.selenium.course.pages.LeadsPage;

public class CreateViewLeadTest {
	
	private LoginPage loginPage;
	private MainApp mainApp;
	private PageMenuBar pageMenuBar;
	private LeadsPage leadsPage;
	private ToolBar toolBar;
	String viewName;
	
	@BeforeClass
    public void setUp() {
    	loginPage = new LoginPage();
    	String email = "gcavero@hotmail.com";
        String password = "Gus.jala1";
        mainApp = loginPage.loginAs(email, password);
        toolBar = mainApp.goToTolBar();
    }
	
	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void testUntitled() {
		toolBar.goToSales();
		pageMenuBar = mainApp.goToPageMenuBar();
		leadsPage = pageMenuBar.clickLeadsTab();
		leadsPage.clickOnCreateNewView();
		
		viewName = "MyView";
		leadsPage.setName(viewName);
		leadsPage.setOwner("1");
		leadsPage.SelectFields();
		leadsPage.clickSave();	
		assertTrue("The view was not created", leadsPage.verifyCreatedView(viewName));
	}
	
	@AfterClass
    public void tearDown() {
		leadsPage.deleteView(viewName);
    }
}
