package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public class DeleteAccountView {
    private AccountViewForm accountViewForm;
    private TabPage accountTab;
    private AccountViewDetails accountViewDetails;
    private String accountViewName = "testView001";
    private String accountUniqueViewName = "testView001";


    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        accountTab = contentPage.tabBar.clickAccounts();
        accountViewForm = new AccountViewForm(accountTab.clickCreateNewViewLink().getDriver());
        accountViewForm.setViewNameText(accountViewName)
                .setViewUniqueNameText(accountUniqueViewName);
        accountViewDetails = new AccountViewDetails(accountViewForm.clickSaveView().getDriver());
    }


    @Test
    public void testCreateAccountView() {
        accountTab = accountViewDetails.clickDeleteViewLink();
        Assert.assertTrue(!accountViewDetails.existViewName(accountViewName));
    }

    @AfterClass
    public void tearDown() {
        accountTab.goToNavigationLinks().clickLogoutBtn();
    }


}
