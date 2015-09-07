package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public class DeleteAccount {
    private AccountForm accountForm;
    private TabPage accountTab;
    private AccountDetail accountDetail;
    private String name = "test001";


    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        accountTab = contentPage.tabBar.clickAccounts();
        accountForm = new AccountForm(accountTab.clickNewBtn().getDriver());
        accountForm.setAccountNameText(name);
        accountDetail = new AccountDetail(accountForm.clickSaveBtn().getDriver());
    }


    @Test
    public void testDeleteAccount() {

        accountTab = accountDetail.clickDeleteBtn();
        Assert.assertTrue(!accountTab.existByLinkText(name));

    }

    @AfterClass
    public void tearDown() {

        accountTab.goToNavigationLinks().clickLogoutBtn();
    }


}
