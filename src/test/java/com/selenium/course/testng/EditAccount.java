package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.course.pages.AccountDetail;
import com.selenium.course.pages.AccountEdit;
import com.selenium.course.pages.AccountsPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.ContentPage;
import com.selenium.course.pages.NewAccountBuilder;
import com.selenium.course.pages.AccountForm;
import com.selenium.course.pages.TabBar;

/**
 * Title:
 * Edit Account
 *
 * @author Gustavo Cavero 
 *
 */
 
public class EditAccount {
	
	private LoginPage loginPage;
	private ContentPage contentPage;
	private TabBar tabBar;
	private AccountsPage accountsPage;
	private AccountDetail accountDetail;
	private AccountForm accountForm;
	private AccountEdit accountEdit;
	String accountName, accountNumber, phone, webSite;

	@BeforeClass
	public void setUp() {
		/*loginPage = new LoginPage();
		contentPage = loginPage.loginAsPrimaryUser();
		tabBar = contentPage.goToTabBar();
		accountsPage = tabBar.clickAccounts();
		accountName = "testing";
		accountNumber = "123";
		phone = "456";
		webSite = "www.facebook.com";
		accountForm = accountsPage.clickNew();
		accountForm = new NewAccountBuilder(accountName)
				.setAccountNumber(accountNumber).setPhone(phone)
				.setWebSite(webSite).build();

		accountDetail = accountForm.createAccount();*/
	}

	@Test (groups = {"BVT, Acceptance, Funcional"})
	public void testUntitled() {
		
		/*assertTrue(accountDetail.verifyNewUser(accountName));

		String accountName2 = "testingEdited";
		accountNumber = "321";
		phone = "654";
		webSite = "www.twiter.com";
		accountEdit = accountDetail.clickEdit();
		accountForm = new NewAccountBuilder(accountName2)
				.setAccountNumber(accountNumber).setPhone(phone)
				.setWebSite(webSite).build();

		accountDetail = accountForm.createAccount();
		assertTrue(accountDetail.verifyNewUser(accountName2));*/
	}

	@AfterClass
	public void tearDown() {
		//accountDetail.deleteAccount();
	}

}
