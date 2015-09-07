package com.selenium.course.testng;

import com.selenium.course.pages.*;
import com.sun.jna.platform.win32.Advapi32Util;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public class CreateAccount {
    private AccountForm accountForm;
    private TabPage accountTab;
    private AccountDetail accountDetail;
    private String accountName = "test001";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        accountTab = contentPage.tabBar.clickAccounts();
        accountForm = new AccountForm(accountTab.clickNewBtn().getDriver());
    }


    @Test
    public void testCreateAccount() {
        accountForm.setAccountNameText(accountName)
                .setAccountNumberField(accountName)
                .setAccountSiteField(accountName);
        accountDetail = new AccountDetail(accountForm.clickSaveBtn().getDriver());
        Assert.assertEquals(accountDetail.getObjectName(), accountName);

    }

    @AfterClass
    public void tearDown() {
        accountTab = accountDetail.clickDeleteBtn();
        accountTab.goToNavigationLinks().clickLogoutBtn();
    }


}
