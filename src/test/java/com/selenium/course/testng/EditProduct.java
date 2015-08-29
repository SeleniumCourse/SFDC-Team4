package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;
/**
 * Created by Andrea Castro on 6/29/2015.
 */
public class EditProduct {

    /**
     * Created by Andrea Castro on 6/12/2015.
     */

    private LoginPage loginPage;
    private ContentPage contentPage;
    private TabBar tabBar;
    private ProductsPage productsPage;
    private NewProductForm newProductForm;
    private ProductDetail productDetail;
    private ProductEditPage productEditPage;
    String productName,productDescription,productCode;

    @BeforeClass
    public void setUp() {

        productName = "Product1Test";
        productDescription = "This product is a test to create new products";
        productCode = "P2015";

        loginPage = new LoginPage();
        contentPage = loginPage.loginAsPrimaryUser();
        tabBar = contentPage.goToTabBar();
        //productsPage = tabBar.clickProducts();
        newProductForm = productsPage.clickNew();
        productDetail = newProductForm.setNewProductName(productName).
                setProductDescriptionField(productDescription).setProductCodeField(productCode).setStatus(true).clickSave();
    }

    @Test
    public void testUntitled() {

        String productName= "Newproductname";
        String productDescription = "new description this product is a test to create new products";
        String productCode= "NewP20151";


        productEditPage = productDetail.clickEdit();
        productDetail = productEditPage.setNewProductName(productName).setProductDescriptionField(productDescription)
                .setProductCodeField(productCode).setStatus(false).clickSave();


        assertTrue(productDetail.verifyName(productName));
        assertTrue(productDetail.verifyDescription(productDescription));


    }

    @AfterClass
    public void tearDown() {

        productDetail.clickDelete();
        tabBar = contentPage.goToTabBar();

    }
}



