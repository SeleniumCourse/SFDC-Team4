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

public class EditCampaignView {
    private ViewFormPage viewFormPage;
    private ViewDetailsForm viewDetailsForm;

    String viewName;
    String uniqueName;

    @BeforeClass
    public void setUp() {
        viewName = "NewCampaignView";
        uniqueName = "NewCampaignView123";

        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        TabBar tabBar = contentPage.goToTabBar();
        TabPage campaignsPage = tabBar.clickCampaigns();
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
        viewName = "CampaignViewEdited";
        uniqueName = "NewCampaignEdited321";

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