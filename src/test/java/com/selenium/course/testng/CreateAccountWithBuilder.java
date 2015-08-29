package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.*;

import com.selenium.course.pages.AccountDetail;
import com.selenium.course.pages.AccountsPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.ContentPage;
import com.selenium.course.pages.NewAccountBuilder;
import com.selenium.course.pages.AccountForm;
import com.selenium.course.pages.TabBar;

/**
 * Title:
 * Create Account
 *
 * @author Gustavo Cavero 
 *
 */
public class CreateAccountWithBuilder {
	private LoginPage loginPage;
	private ContentPage contentPage;
	private TabBar tabBar;
	private AccountsPage accountsPage;
	private AccountDetail accountDetail;
	private AccountForm accountForm;
	String accountName, accountNumber, phone, webSite;

	@BeforeClass
	public void setUp() {
		loginPage = new LoginPage();
		contentPage = loginPage.loginAsPrimaryUser();
		tabBar = contentPage.goToTabBar();
		//accountsPage = tabBar.clickAccounts();
	}

	@Test (groups = {"BVT, Acceptance, Funcional"})
	public void testUntitled() {
		accountName = "testing";
		accountNumber = "123";
		phone = "456";
		webSite = "www.facebook.com";
		accountForm = accountsPage.clickNew();
		accountForm = new NewAccountBuilder(accountName)
				.setAccountNumber(accountNumber).setPhone(phone)
				.setWebSite(webSite).build();

		//accountDetail = accountForm.createAccount();

		assertTrue(accountDetail.verifyNewUser(accountName));
	}

	@AfterClass
	public void tearDown() {
		accountDetail.deleteAccount();
	}
}
