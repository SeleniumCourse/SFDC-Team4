package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Andrea Castro on 6/29/2015.
 */
public class CreateProduct {/*

   *
     * Created by Andrea Castro on 6/12/2015.
     

        private LoginPage loginPage;
        private ContentPage contentPage;
        private TabBar tabBar;
        private ProductsPage productsPage;
        private NewProductForm newProductForm;
        private ProductDetail productDetail;


        @BeforeClass
        public void setUp() {
            loginPage = new LoginPage();
            contentPage = loginPage.loginAsPrimaryUser();
            tabBar = contentPage.goToTabBar();
            productsPage = tabBar.clickProducts();
        }

            @Test
            public void testUntitled () {

                String productName = "Product1Test";
                String productDescription = "This product is a test to create new products";
                String productCode = "P2015";


                newProductForm = productsPage.clickNew();
                productDetail = newProductForm.setNewProductName(productName).setProductCodeField(productCode)
                        .setProductDescriptionField(productDescription).clickSave();

                assertTrue(productDetail.verifyName(productName));
                assertTrue(productDetail.verifyDescription(productDescription));

            }

            @AfterClass
            public void tearDown () {

                productDetail.clickDelete();
                tabBar = contentPage.goToTabBar();

            }*/
}




