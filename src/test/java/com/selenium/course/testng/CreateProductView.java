package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Nelson Tapia on 9/4/2015.
 */
public class CreateProductView {
    private ProductViewForm productViewForm;
    private TabPage productTab;
    private ProductTabPage productTabPage;
    private ProductViewDetails productViewDetails;
    private String productNameViewName = "ViewForTesting";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        productTabPage = new ProductTabPage(contentPage.tabBar.clickProducts().getDriver());
        productViewForm = new ProductViewForm(productTabPage.clickCreateNewViewLinkProduct().getDriver());
    }

    @Test
    public void testCreateProductView() {
        productViewForm.setViewNameText(productNameViewName);
        productViewDetails = new ProductViewDetails(productViewForm.clickSaveBtn().getDriver());
        Assert.assertEquals(productViewDetails.getViewName(), productNameViewName);
    }

    @AfterClass
    public void tearDown() {
        productTab = productViewDetails.clickDeleteViewLink();
        productTab.goToNavigationLinks().clickLogoutBtn();
    }
}

