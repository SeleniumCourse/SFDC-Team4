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

public class CreateCampaignView {
    private LoginPage loginPage;
    private ContentPage contentPage;
    private TabBar tabBar;
    private TabPage campaignsPage;
    private ViewFormPage viewFormPage;
    private ViewDetailsForm viewDetailsForm;

    String viewName = "ViewTesting123";
    String uniqueName = "UniqueViewTesting123";

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage();
        contentPage = loginPage.loginAsPrimaryUser();
        tabBar = contentPage.goToTabBar();
        campaignsPage = tabBar.clickCampaigns();
        campaignsPage.clickCreateNewViewLink();
    }

    @Test(groups = {"BVT, Acceptance, Funcional"})
    public void testCreateNewCampaign() {
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