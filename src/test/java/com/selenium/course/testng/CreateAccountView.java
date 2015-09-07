package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public class CreateAccountView {
    private AccountViewForm accountViewForm;
    private TabPage accountTab;
    private AccountViewDetails accountViewDetails;
    private String accountViewName = "testView001";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        accountTab = contentPage.tabBar.clickAccounts();
        accountViewForm = new AccountViewForm(accountTab.clickCreateNewViewLink().getDriver());
    }


    @Test
    public void testCreateAccountView() {
        accountViewForm.setViewNameText(accountViewName);
        accountViewDetails = new AccountViewDetails(accountViewForm.clickSaveView().getDriver());
        Assert.assertEquals(accountViewDetails.getViewName(), accountViewName);

    }

    @AfterClass
    public void tearDown() {
        accountTab = accountViewDetails.clickDeleteViewLink();
        accountTab.goToNavigationLinks().clickLogoutBtn();
    }


}
