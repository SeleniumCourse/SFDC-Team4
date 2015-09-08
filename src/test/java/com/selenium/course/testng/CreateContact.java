package com.selenium.course.testng;

import com.selenium.course.framework.RegisterData;
import com.selenium.course.pages.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Nelson Tapia on 9/5/2015.
 */

public class CreateContact {
    private ContactForm contactForm;
    private TabPage contactTab;
    private ContactDetail contactDetail;

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        contactTab = contentPage.tabBar.clickContacts();
        contactForm = new ContactForm(contactTab.clickNewBtn().getDriver());
    }

    @Test(dataProvider = "regData",dataProviderClass = RegisterData.class)
    public void testCreateContact(RegisterData registrationData) throws IOException {
        //contactForm.registerNewContact(registrationData);

        contactForm.setFirstName(registrationData.getFirstName())
                .setLastName(registrationData.getLastName())
                        //.setAccountName(registrationData.getAccountName())
                .setTitle(registrationData.getTitle())
                .setDepartment(registrationData.getDepartment())
                .selectLeadSource(registrationData.getLeadSource())
                .setPhone(registrationData.getPhone())
                .setHomePhone(registrationData.getHomePhone())
                .setMobile(registrationData.getMobile())
                .setOtherPhone(registrationData.getOtherPhone())
                .setFax(registrationData.getFax())
                .setEmail(registrationData.getEmail())
                .setAssistant(registrationData.getAssistant())
                .setAssistantPhone(registrationData.getAssistantPhone())
                .setMailingStreet(registrationData.getMailingStreet())
                .setMailingCity(registrationData.getMailingCity())
                .setMailingState(registrationData.getMailingState())
                .setMailingZipPostal(registrationData.getMailingZipPostal())
                .setMailingCountry(registrationData.getMailingCountry())
                .setOtherStreet(registrationData.getOtherStreet())
                .setOtherCity(registrationData.getOtherCity())
                .setOtherState(registrationData.getOtherState())
                .setOtherZipPostal(registrationData.getOtherZip())
                .setOtherCountry(registrationData.getOtherCountry())
                .setLanguages(registrationData.getLanguages())
                .selectLevel(registrationData.getLevel())
                .setDescription(registrationData.getDescription());
        contactDetail = new ContactDetail(contactForm.clickSaveBtn().getDriver());
        org.testng.Assert.assertEquals(contactDetail.getContactName(), registrationData.getFirstName() + " " + registrationData.getLastName());
        //org.testng.Assert.assertEquals(contactDetail.getAccountName(), registrationData.getAccountName());
        org.testng.Assert.assertEquals(contactDetail.getTitleName(), registrationData.getTitle());
        org.testng.Assert.assertEquals(contactDetail.getDepartamentName(), registrationData.getDepartment());
        org.testng.Assert.assertEquals(contactDetail.getLeadSourceName(), registrationData.getLeadSource());
        org.testng.Assert.assertEquals(contactDetail.getPhoneNumber(), registrationData.getPhone());
        org.testng.Assert.assertEquals(contactDetail.getHomePhoneNumber(), registrationData.getHomePhone());
        org.testng.Assert.assertEquals(contactDetail.getMobileNumber(), registrationData.getMobile());
        org.testng.Assert.assertEquals(contactDetail.getOtherPhoneNumber(), registrationData.getOtherPhone());
        org.testng.Assert.assertEquals(contactDetail.getFaxNumber(), registrationData.getFax());
        org.testng.Assert.assertEquals(contactDetail.getEmailName(), registrationData.getEmail());
        org.testng.Assert.assertEquals(contactDetail.getAssistantName(), registrationData.getAssistant());
        org.testng.Assert.assertEquals(contactDetail.getAssistantPhone(), registrationData.getAssistantPhone());
        org.testng.Assert.assertEquals(contactDetail.getLanguage(), registrationData.getLanguages());
        org.testng.Assert.assertEquals(contactDetail.getLevel(), registrationData.getLevel());
        org.testng.Assert.assertEquals(contactDetail.getDescription(), registrationData.getDescription());
    }

    @AfterClass
    public void tearDown() {
        contactTab = contactDetail.clickDeleteOppBtn();
        contactTab.goToNavigationLinks().clickLogoutBtn();
    }
}