package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.annotations.*;
import static org.junit.Assert.assertTrue;


public class EditOpportunity {
    private LoginPage loginPage;
    private MainApp mainApp;
    private PageMenuBar pageMenuBar;
    private OpportunitiesPage opportunitiesPage;
    private NewOpportunityForm newOpportunityForm;
    private OpportunityTablePage opportunityTablePage;
    private OpportunityDetail opportunityDetail;
    private OpportunityEdit opportunityEdit;
    String name,newName;
    String stage,newStage,type, leadSource, amount, nextstep;


    @BeforeClass
    public void setUp() {
        name = "LastOpportunity";
        stage = "Prospecting";
        type ="New Customer";
        leadSource = "Web";
        amount = "20";
        nextstep = "Step";
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        pageMenuBar = mainApp.goToPageMenuBar();
        opportunitiesPage = pageMenuBar.clickOpportunities();
        newOpportunityForm = opportunitiesPage.clickNewOpportunity();
        opportunityDetail = newOpportunityForm.setName(name)
                .setPrivate()
                .setType(type)
                .setLeadSource(leadSource)
                .setAmount(amount)
                .setCloseDate()
                .setNextStep(nextstep)
                .setStage(stage)
                .clickSaveOpportunity();
    }

    @Test (groups = {"BVT, Acceptance, Funcional"})
    public void testUntitled() {
        newName = "ModifiedOpportunity";
        newStage = "Qualification";
        type ="Existing Customer - Upgrade";
        leadSource = "Other";
        amount = "50";
        nextstep = "StepModified";
        opportunityEdit = opportunityDetail.clickEdit();
        opportunityDetail = opportunityEdit.setName(newName)
                .setPrivate()
                .setType(type)
                .setLeadSource(leadSource)
                .setAmount(amount)
                .setCloseDate()
                .setNextStep(nextstep)
                .setStage(stage)
                .clickSaveOpportunity();
        assertTrue(opportunityDetail.verifyNewOpportunity(newName));
    }

    @AfterClass
    public void tearDown() {
        opportunityDetail.deleteOpportunity();
    }
}
