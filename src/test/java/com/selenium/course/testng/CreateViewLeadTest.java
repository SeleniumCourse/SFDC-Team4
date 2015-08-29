package com.selenium.course.testng;

import static org.junit.Assert.*;
import org.testng.annotations.*;

import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.ContentPage;
import com.selenium.course.pages.TabBar;
import com.selenium.course.pages.ToolBar;
import com.selenium.course.pages.LeadsPage;

/**
 * Title:
 * Cretate 
 *
 * @author Gustavo Cavero 
 *
 */
 
public class CreateViewLeadTest {/*
	
	private LoginPage loginPage;
	private ContentPage contentPage;
	private TabBar tabBar;
	private LeadsPage leadsPage;
	private ToolBar toolBar;
	String viewName;
	
	@BeforeClass
    public void setUp() {
    	loginPage = new LoginPage();
    	String email = "gcavero@hotmail.com";
        String password = "Gus.jala1";
        contentPage = loginPage.loginAs(email, password);
        toolBar = contentPage.goToToolBar();
    }
	
	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void testUntitled() {
		toolBar.goToSales();
		tabBar = contentPage.goToTabBar();
		leadsPage = tabBar.clickLeadsTab();
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
    }*/
}
