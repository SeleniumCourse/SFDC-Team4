package com.selenium.course.testng;

import org.junit.Assert;
import org.testng.annotations.*;

import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.PageMenuBar;
import com.selenium.course.pages.ContactsPage;
import com.selenium.course.pages.ContactForm;
import com.selenium.course.pages.ContactDetail;

/**
 * Created by reyna ulaque on 27/06/2015.
 */

public class CreateContact {
    private LoginPage loginPage;
    private MainApp mainApp;
    private PageMenuBar pageMenuBar;
    private ContactsPage contactsPage;
    private ContactForm contactForm;
    private ContactDetail contactDetail;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage();
        //String email = "rmeryuc@gmail.com";
        //String password = "Control123";
        //mainApp = loginPage.loginAs(email, password);
        mainApp = loginPage.loginAsPrimaryUser();
        pageMenuBar = mainApp.goToPageMenuBar();
        contactsPage = pageMenuBar.clickContacts();
        contactForm = contactsPage.clickNewBtn();
    }

    @Test
    public void testUntitled() {
        String tittleFirstName = "Ms.";
        String firstName = "Rosa";
        String lastName = "Quiroz";
        String title = "QE";
        String department = "QE";
        String leadSource = "Phone Inquiry";
        String phone = "1234567";
        String homePhone = "1234567";
        String mobile = "1234567";
        String otherPhone = "1234567";
        String fax = "1234567";
        String email = "jhoana@gmail.com";
        String assistant = "Kimberly";
        String assistantPhone = "1234567";
        String mailingStreet = "mailingStreet";
        String mailingCity = "mailingCity";
        String mailingState = "mailingState";
        String mailingZip = "mailingZipPostal";
        String mailingCountry = "mailingCountry";
        String otherStreet = "otherStreet";
        String otherCity = "otherCity";
        String otherState = "otherState";
        String otherZip = "otherZip";
        String otherCountry = "otherCountry";
        String languages = "Spanish";
        String level = "Primary";
        String description = "true information";

        contactDetail = contactForm.selectTitle(tittleFirstName)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setTitle(title)
                .setDepartment(department)
                .selectLeadSource(leadSource)
                .setPhone(phone)
                .setHomePhone(homePhone)
                .setMobile(mobile)
                .setOtherPhone(otherPhone)
                .setFax(fax)
                .setEmail(email)
                .setAssistant(assistant)
                .setAssistantPhone(assistantPhone)
                .setMailingStreet(mailingStreet)
                .setMailingCity(mailingCity)
                .setMailingState(mailingState)
                .setMailingZipPostal(mailingZip)
                .setMobile(mailingCountry)
                .setOtherStreet(otherStreet)
                .setOtherCity(otherCity)
                .setOtherState(otherState)
                .setOtherZipPostal(otherZip)
                .setOtherCountry(otherCountry)
                .setLanguages(languages)
                .selectLevel(level)
                .setDescription(description)
                .clickSaveBtn();

        Assert.assertEquals("Contact Name", tittleFirstName + ' ' + firstName + ' ' + lastName,
                contactDetail.getContactName());
    }

    @AfterClass
    public void tearDown() {
        contactDetail.clickDeleteBtn();
    }
}



