package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Nelson Tapia on 9/4/2015.
 */
public class EditContactView {
    private ContactViewForm contactViewForm;
    private TabPage contactTab;
    private ContactViewDetails contactViewDetails;
    private String contactViewName = "ContactViewName";
    private String contactViewNameEdited = "ContactViewNameUpdated";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        contactTab = contentPage.tabBar.clickContacts();
        contactViewForm = new ContactViewForm(contactTab.clickCreateNewViewLink().getDriver());
        contactViewForm.setViewNameText(contactViewName);
        contactViewDetails = new ContactViewDetails(contactViewForm.clickSaveBtn().getDriver());
    }

    @Test
    public void testEditContactView() {
        contactViewForm = new ContactViewForm(contactViewDetails.clickEditViewLink().getDriver());
        contactViewForm.setViewNameText(contactViewNameEdited);
        contactViewDetails = new ContactViewDetails(contactViewForm.clickSaveBtn().getDriver());
        Assert.assertEquals(contactViewDetails.getViewName(), contactViewNameEdited);
    }

    @AfterClass
    public void tearDown() {
        contactTab = contactViewDetails.clickDeleteViewLink();
        contactTab.goToNavigationLinks().clickLogoutBtn();
    }
}

