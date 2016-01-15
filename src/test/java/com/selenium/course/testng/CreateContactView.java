package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Nelson Tapia on 9/4/2015.
 */
public class CreateContactView {
    private ContactViewForm contactViewForm;
    private TabPage contacTab;
    private ContactViewDetails contactViewDetails;
    private String contactNameViewName = "ContactNameView";
    private String contactUniqueViewName = "ContactUniqueNameView";

    private String contactField1ViewName = "Salutation";
    private String contactField2ViewName = "Name";

    private String contactOption1ViewName = "equals";
    private String contactOption2ViewName = "contains";

    private String contactValue1ViewName = "Value1View";
    private String contactValue2ViewName = "Value2View";


    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        contacTab = contentPage.tabBar.clickContacts();
        contactViewForm = new ContactViewForm(contacTab.clickCreateNewViewLink().getDriver());
    }

    @Test
    public void testCreateContactView() {
        contactViewForm.setViewNameText(contactNameViewName);
        contactViewForm.setViewUniqueNameText(contactUniqueViewName);
        contactViewForm.setField1(contactField1ViewName);
        contactViewForm.setField2(contactField2ViewName);
        contactViewForm.setOption1(contactOption1ViewName);
        contactViewForm.setOption2(contactOption2ViewName);
        contactViewForm.setValue1(contactValue1ViewName);
        contactViewForm.setValue2(contactValue2ViewName);
        contactViewForm.setMyContact();

        contactViewDetails = new ContactViewDetails(contactViewForm.clickSaveBtn().getDriver());
        Assert.assertEquals(contactViewDetails.getViewName(), contactNameViewName);
    }

    @AfterClass
    public void tearDown() {
        contacTab = contactViewDetails.clickDeleteViewLink();
        contacTab.goToNavigationLinks().clickLogoutBtn();
    }
}

