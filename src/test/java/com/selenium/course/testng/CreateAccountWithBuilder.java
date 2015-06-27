package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.*;

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
	String accountName, accountNumber, phone, webSite;

	@BeforeClass
	public void setUp() {
		loginPage = new LoginPage();
		mainApp = loginPage.loginAsPrimaryUser();
		pageMenuBar = mainApp.goToPageMenuBar();
		accountsPage = pageMenuBar.clickAccounts();
	}

	@Test (groups = {"BVT, Acceptance, Funcional"})
	public void testUntitled() {
		accountName = "testing";
		accountNumber = "123";
		phone = "456";
		webSite = "www.facebook.com";
		newAccountForm = accountsPage.clickNew();
		newAccountForm = new NewAccountBuilder(accountName)
				.setAccountNumber(accountNumber).setPhone(phone)
				.setWebSite(webSite).build();

		accountDetail = newAccountForm.createAccount();

		assertTrue(accountDetail.verifyNewUser(accountName));
	}

	@AfterClass
	public void tearDown() {
		accountDetail.deleteAccount();
	}
}
