package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Nelson Tapia on 9/4/2015.
 */
public class EditProductView {
    private ProductViewForm productViewForm;
    private ProductTabPage productTab;
    private ProductViewDetails productViewDetails;
    private String productViewName = "ProductViewName";
    private String productUniqueViewName = "UniqueViewName";

    private String productViewUpdated = "ProductViewNameUpdated";
    private String productUniqueViewNameUpdated = "ProductUniqueViewNameUpdated";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        productTab = new ProductTabPage(contentPage.tabBar.clickProducts().getDriver());

        productViewForm = new ProductViewForm(productTab.clickCreateNewViewLinkProduct().getDriver());
        productViewForm.setViewNameText(productViewName)
                .setViewUniqueNameText(productUniqueViewName);

        productViewDetails = new ProductViewDetails(productViewForm.clickSaveBtn().getDriver());
    }

    @Test
    public void testEditProductView() {
        productViewForm = new ProductViewForm(productViewDetails.clickEditViewLink().getDriver());
        productViewForm.setViewNameText(productViewUpdated)
                .setViewUniqueNameText(productUniqueViewNameUpdated);

        productViewDetails = new ProductViewDetails(productViewForm.clickSaveBtn().getDriver());
        Assert.assertEquals(productViewDetails.getViewName(), productViewUpdated);
    }

    @AfterClass
    public void tearDown() {
        productViewDetails.clickDeleteViewLink();
        productTab.goToNavigationLinks().clickLogoutBtn();
    }
}
