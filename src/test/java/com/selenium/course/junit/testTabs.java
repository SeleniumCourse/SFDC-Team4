package com.selenium.course.junit;

import org.junit.Test;

import com.selenium.course.pages.AccountsPage;
import com.selenium.course.pages.CampaingsPage;
import com.selenium.course.pages.ContactsPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.OpportunitiesPage;
import com.selenium.course.pages.PageMenuBar;
import com.selenium.course.pages.ProductsPage;

public class testTabs {
	private LoginPage loginPage;
	private MainApp mainApp;
	private PageMenuBar pageMenuBar;
	private CampaingsPage campaignsPage;
	private AccountsPage accountsPage;
	private ContactsPage contactsPage;
	private OpportunitiesPage opportunitiesPage;
	private ProductsPage productsPage;
	
	
	@Test
    public void testUntitled() {
		loginPage = new LoginPage();
    	String email = "gcavero@hotmail.com";
        String password = "Gus.jala1";
        
        mainApp = loginPage.loginAs(email, password);
        pageMenuBar = mainApp.goToPageMenuBar();
        campaignsPage = pageMenuBar.clickCampaings();
        accountsPage = pageMenuBar.clickAccounts();
        contactsPage = pageMenuBar.clickContacts();
        opportunitiesPage = pageMenuBar.clickOpportunities();
        productsPage = pageMenuBar.clickProducts();
        
        
	}
}
