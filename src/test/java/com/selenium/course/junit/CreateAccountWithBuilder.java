package com.selenium.course.junit;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.selenium.course.pages.AccountDetail;
import com.selenium.course.pages.AccountsPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.NewAccountBuilder;
import com.selenium.course.pages.NewAccountForm;
import com.selenium.course.pages.PageMenuBar;

public class CreateAccountWithBuilder {
	private LoginPage loginPage;
	private MainApp mainApp;
	private PageMenuBar pageMenuBar;
	private AccountsPage accountsPage;
	private AccountDetail accountDetail;
	private NewAccountForm newAccountForm;
	String accountName,accountNumber, phone;
	
	@Before
    public void setUp() {
		loginPage = new LoginPage();
		mainApp = loginPage.loginAsPrimaryUser();
        pageMenuBar = mainApp.goToPageMenuBar();
        accountsPage = pageMenuBar.clickAccounts();
    }
	
	@Test
    public void testUntitled() {
		accountName = "testing";
		accountNumber = "123";
		phone = "456";
		newAccountForm = accountsPage.clickNew();
		newAccountForm = new NewAccountBuilder(accountName)
							.setAccountNumber(accountNumber)
							.setPhone(phone).build();
		
		accountDetail = newAccountForm.createAccount();
		
		assertTrue(accountDetail.verifyNewUser(accountName));
	}
	
	@After
    public void tearDown() {
		accountDetail.deleteAccount();
    }
}
