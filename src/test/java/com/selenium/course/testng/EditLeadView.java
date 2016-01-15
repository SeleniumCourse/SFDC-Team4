package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by AutomationUser on 9/7/2015.
 */
public class EditLeadView
{
    private LoginPage loginPage;
    private ContentPage contentPage;
    private TabPage leadTab;
    private LeadViewForm leadViewForm;
    private LeadViewDetail leadViewDetail;
    private String viewName="AutoView01";
    private String viewUniqueName="AutoView01";

    private String viewNameEdited = "AutoView01Edited";

    @BeforeClass
    public void setUp()
    {
        loginPage = new LoginPage();
        contentPage = loginPage.loginAsPrimaryUser();
        leadTab = contentPage.tabBar.clickLeadsTab();
        leadViewForm = new LeadViewForm(leadTab.clickCreateNewViewLink().getDriver());
        leadViewForm.setViewNameText(viewName)
                .setViewUniqueNameText(viewUniqueName);

        leadViewDetail = new LeadViewDetail(leadViewForm.clickSaveView().getDriver());
    }

    @Test(groups = {"BVT, Acceptance, Funcional"})
    public void EditLeadViewTc()
    {
        leadViewForm = new LeadViewForm(leadViewDetail.clickEditViewLink().getDriver());
        leadViewForm.setViewNameText(viewNameEdited)
                .setViewUniqueNameText(viewNameEdited);

        leadViewDetail = new LeadViewDetail(leadViewForm.clickSaveView().getDriver());
        Assert.assertEquals(leadViewDetail.getViewName(), viewNameEdited);
    }

    @AfterClass
    public void tearDown() {
        leadTab = leadViewDetail.clickDeleteViewLink();
        leadTab.goToNavigationLinks().clickLogoutBtn();
    }
}
