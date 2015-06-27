package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.course.pages.AccountDetail;
import com.selenium.course.pages.AccountEdit;
import com.selenium.course.pages.AccountsPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.NewAccountBuilder;
import com.selenium.course.pages.NewAccountForm;
import com.selenium.course.pages.PageMenuBar;

/**
 * Title:
 * Edit Account
 *
 * @author Gustavo Cavero 
 *
 */
 
public class EditAccount {
	
	private LoginPage loginPage;
	private MainApp mainApp;
	private PageMenuBar pageMenuBar;
	private AccountsPage accountsPage;
	private AccountDetail accountDetail;
	private NewAccountForm newAccountForm;
	private AccountEdit accountEdit;
	String accountName, accountNumber, phone, webSite;

	@BeforeClass
	public void setUp() {
		loginPage = new LoginPage();
		mainApp = loginPage.loginAsPrimaryUser();
		pageMenuBar = mainApp.goToPageMenuBar();
		accountsPage = pageMenuBar.clickAccounts();
		accountName = "testing";
		accountNumber = "123";
		phone = "456";
		webSite = "www.facebook.com";
		newAccountForm = accountsPage.clickNew();
		newAccountForm = new NewAccountBuilder(accountName)
				.setAccountNumber(accountNumber).setPhone(phone)
				.setWebSite(webSite).build();

		accountDetail = newAccountForm.createAccount();
	}

	@Test (groups = {"BVT, Acceptance, Funcional"})
	public void testUntitled() {
		
		assertTrue(accountDetail.verifyNewUser(accountName));

		String accountName2 = "testingEdited";
		accountNumber = "321";
		phone = "654";
		webSite = "www.twiter.com";
		accountEdit = accountDetail.clickEdit();
		newAccountForm = new NewAccountBuilder(accountName2)
				.setAccountNumber(accountNumber).setPhone(phone)
				.setWebSite(webSite).build();

		accountDetail = newAccountForm.createAccount();
		assertTrue(accountDetail.verifyNewUser(accountName2));
	}

	@AfterClass
	public void tearDown() {
		accountDetail.deleteAccount();
	}

}
