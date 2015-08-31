package com.selenium.course.testng;

import static org.junit.Assert.assertTrue;


/**
 * Title:
 * Create Account
 *
 * @author Gustavo Cavero 
 *
 */
public class CreateAccountWithBuilder {
	/*private LoginPage loginPage;
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

		assertTrue(accountDetail.verifyUserName(accountName));
	}

	@AfterClass
	public void tearDown() {
		accountDetail.deleteAccount();
	}*/
}
