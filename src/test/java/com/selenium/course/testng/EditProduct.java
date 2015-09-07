package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;
/**
 * Created by Elmer Alvarado on 6/29/2015.
 */
public class EditProduct {


    private LoginPage loginPage;
    private ContentPage contentPage;
    private TabPage productTab;
    private ProductForm productForm;
    private ProductDetail productDetail;

    private final String productName= "Auto Prod";
    private final String productCode= "Auto Prod Code";
    private final String description= "Automation Product";
    private final String productNameEdited= "Auto Prod Edit";

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage();
        contentPage = loginPage.loginAsPrimaryUser();
        productTab = contentPage.tabBar.clickProducts();
        productForm =  new ProductForm(productTab.clickNewBtn().getDriver());
        productForm.setProductName(productName)
                .setProductCode(productCode)
                .setDescription(description);
        productDetail = new ProductDetail(productForm.clickSaveBtn().getDriver());
    }

    @Test
    public void EditProductTc()
    {
        productForm =  new ProductForm(productDetail.clickEditBtn().getDriver());
        productForm.setProductName(productNameEdited);
        productDetail = new ProductDetail(productForm.clickSaveBtn().getDriver());
        Assert.assertEquals(productDetail.getProductName(), productNameEdited);
    }

    @AfterClass
    public void tearDown() {
        productTab = productDetail.clickDeleteOppBtn();
        productTab.navigationLinks.clickLogoutBtn();
    }
}



