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
public class CreateAccountView {
    private AccountViewForm accountViewForm;
    private TabPage accountTab;
    private AccountViewDetails accountViewDetails;
    private String accountViewName = "testView001";
    private String accountUniqueViewName = "testView001";
    private String accountContains = "test";
    private List<String> multiselectOption = new ArrayList<String>();


    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        accountTab = contentPage.tabBar.clickAccounts();
        accountViewForm = new AccountViewForm(accountTab.clickCreateNewViewLink().getDriver());
    }


    @Test
    public void testCreateAccountView() {
        multiselectOption.add("Fax");
        multiselectOption.add("Website");
        accountViewForm.setViewNameText(accountViewName)
                .setViewUniqueNameText(accountUniqueViewName)
                .setFilterAccountName(accountContains)
                .setMyAccounts()
                .setSelectedFields(multiselectOption);
        accountViewDetails = new AccountViewDetails(accountViewForm.clickSaveView().getDriver());
        Assert.assertEquals(accountViewDetails.getViewName(), accountViewName);
        Assert.assertTrue(accountViewDetails.existColumnName("Fax"));
        Assert.assertTrue(accountViewDetails.existColumnName("Website"));
    }

    @AfterClass
    public void tearDown() {
        accountTab = accountViewDetails.clickDeleteViewLink();
        accountTab.goToNavigationLinks().clickLogoutBtn();
    }


}
