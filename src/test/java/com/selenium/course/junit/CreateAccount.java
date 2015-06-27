package com.selenium.course.junit;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.selenium.course.pages.*;

public class CreateAccount {
	private LoginPage loginPage;
	private MainApp mainApp;
	private PageMenuBar pageMenuBar;
	private AccountsPage accountsPage;
	private NewAccountForm newAccountForm;
	private AccountDetail accountDetail;
	String campaingName;
	
	@Before
    public void setUp() {
    	loginPage = new LoginPage();
    	String email = "gcavero@hotmail.com";
        String password = "Gus.jala1";
        campaingName = "newCampaing";
        mainApp = loginPage.loginAs(email, password);
        pageMenuBar = mainApp.goToPageMenuBar();
        accountsPage = pageMenuBar.clickAccounts();
    }
	
	@Test
    public void testUntitled() {
		String accountName = "test1";
		String parentAccount = "GusCavero";
		String accountNumber = "123";
		String accountSite = "512";
		String type = "Prospect";
		String Industry = "Engineering";
		String revenue = "5000";
		String rating = "Hot";
		String phone = "123";
		String fax = "456";
		String webSite = "me.com";
		String tickerSymbol = "Aquarus";
		String ownership = "Private";
		String employes = "4";
		String billCity = "bCity";
		String billState = "bState";
		String billZip = "591";
		String billCountry = "Bol";
		String shipCity = "LA";
		String shipState = "Cal";
		String shipZip = "+1";
		String shipCountry = "AU";
		
		newAccountForm = accountsPage.clickNew();
		accountDetail = newAccountForm.createNewAccount(accountName, parentAccount,
														accountNumber, accountSite, type, Industry, revenue, rating, phone, 
														fax, webSite, tickerSymbol, ownership, employes, billCity, 
														billState, billZip, billCountry, shipCity, shipState, shipZip, shipCountry);
		assertTrue(accountDetail.verifyNewUser(accountName));
	}
	
	@After
    public void tearDown() {
		accountDetail.deleteAccount();
    }
}




















