package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.annotations.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class EditOpportunity {
    private LoginPage loginPage;
    private ContentPage contentPage;
    private TabBar tabBar;
    private OpportunitiesPage opportunitiesPage;
    private NewOpportunityForm newOpportunityForm;
    private OpportunityTablePage opportunityTablePage;
    private OpportunityDetail opportunityDetail;
    private OpportunityEdit opportunityEdit;
    String name,newName,type, leadSource,amount,nextStep;
    String stage,newStage,newType, newLeadSource, newAmount, newNextStep;


    @BeforeClass
    public void setUp() {
        name = "LastOpportunity";
        stage = "Prospecting";
        type ="New Customer";
        leadSource = "Web";
        amount = "20";
        nextStep = "Step";
        loginPage = new LoginPage();
        contentPage = loginPage.loginAsPrimaryUser();
        tabBar = contentPage.goToTabBar();
       // opportunitiesPage = tabBar.clickOpportunities();
        newOpportunityForm = opportunitiesPage.clickNewOpportunity();
        opportunityDetail = newOpportunityForm.setName(name)
                .setPrivate()
                .setType(type)
                .setLeadSource(leadSource)
                .setAmount(amount)
                .setCloseDate()
                .setNextStep(nextStep)
                .setStage(stage)
                .clickSaveOpportunity();
    }

    @Test (groups = {"BVT, Acceptance, Funcional"})
    public void testUntitled() {
        newName = "ModifiedOpportunity";
        newStage = "Qualification";
        newType ="Existing Customer - Upgrade";
        newLeadSource = "Other";
        newAmount = "50";
        newNextStep = "StepModified";
        opportunityEdit = opportunityDetail.clickEdit();
        opportunityDetail = opportunityEdit.setName(newName)
                .setPrivate()
                .setType(newType)
                .setLeadSource(newLeadSource)
                .setAmount(newAmount)
                .setCloseDate()
                .setNextStep(newNextStep)
                .setStage(stage)
                .clickSaveOpportunity();
        assertTrue("Verification Failed:The opportunity name was not correctly changed",opportunityDetail.verifyNewOpportunityName(newName));
        assertFalse("Verification Failed:The opportunity private data was not correctly changed",opportunityDetail.verifyNewOpportunityPrivate());
        assertTrue("Verification Failed:The opportunity type was not correctly changed",opportunityDetail.verifyNewOpportunityType(newType));
        assertTrue("Verification Failed:The opportunity lead source was not correctly changed",opportunityDetail.verifyNewOpportunityLeadSource(newLeadSource));
        assertTrue("Verification Failed:The opportunity amount was not correctly changed",opportunityDetail.verifyNewOpportunityAmount(newAmount));
        assertTrue("Verification Failed:The opportunity step data was not correctly changed",opportunityDetail.verifyNewOpportunityStep(newNextStep));

    }

    @AfterClass
    public void tearDown() {
        opportunityDetail.deleteOpportunity();
    }
}
