package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Elmer A. on 6/29/2015.
 */
public class CreateProduct
{
    private LoginPage loginPage;
    private ContentPage contentPage;
    private TabPage productTab;
    private ProductForm productForm;
    private ProductDetail productDetail;

    private final String productName= "Auto Prod";
    private final String productCode= "Auto Prod Code";
    private final String description= "Automation Product";

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage();
        contentPage = loginPage.loginAsPrimaryUser();
    }


    @Test (groups = {"BVT, Acceptance, Funcional"})
    public void testUntitled ()
    {
        productTab = contentPage.tabBar.clickProducts();
        productForm =  new ProductForm(productTab.clickNewBtn().getDriver());
        productForm.setProductName(productName)
                .setProductCode(productCode)
                .setDescription(description);
        productDetail = new ProductDetail(productForm.clickSaveBtn().getDriver());
        Assert.assertEquals(productDetail.getProductName(), productName);
    }

    @AfterClass
    public void tearDown() {
        productTab = productDetail.clickDeleteOppBtn();
        productTab.navigationLinks.clickLogoutBtn();
    }
}




