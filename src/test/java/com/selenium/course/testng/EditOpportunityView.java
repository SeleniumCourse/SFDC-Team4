package com.selenium.course.testng;

import com.selenium.course.framework.WebDriverManager;
import com.selenium.course.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created for Joel Rodriguez
 */

public class EditOpportunityView {

    private ViewDetailsForm viewDetailsForm;

    String viewName;
    String uniqueName;

    @BeforeClass
    public void setUp() {
        viewName = "NewOpportunityView123";
        uniqueName = "NewOpportunityView321";

        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        TabBar tabBar = contentPage.goToTabBar();
        TabPage campaignsPage = tabBar.clickOpportunities();
        campaignsPage.clickCreateNewViewLink();
        WebDriver driver = WebDriverManager.getInstance().getDriver();

        viewDetailsForm = new ViewFormPage(driver)
                .setViewName(viewName)
                .setUniqueViewName(uniqueName)
                .clickSaveView();
        viewDetailsForm.clickEditView();
    }

    @Test(groups = {"BVT, Acceptance, Funcional"})
    public void testCreateNewCampaign() {
        viewName = "OpportunityViewEdited123";
        uniqueName = "OpportunityViewEdited321";

        WebDriver driver = WebDriverManager.getInstance().getDriver();

        viewDetailsForm = new ViewFormPage(driver)
                .setViewName(viewName)
                .setUniqueViewName(uniqueName)
                .clickSaveView();

        assertTrue(viewDetailsForm.verifyNewView(viewName));
    }

    @AfterClass
    public void tearDown() {
        viewDetailsForm.clickDeleteView();
    }
}