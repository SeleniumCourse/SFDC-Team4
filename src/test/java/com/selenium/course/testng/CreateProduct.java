package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Andrea Castro on 6/29/2015.
 */
public class CreateProduct {

   /**
     * Created by Andrea Castro on 6/12/2015.
     */

        private LoginPage loginPage;
        private MainApp mainApp;
        private PageMenuBar pageMenuBar;
        private ProductsPage productsPage;
        private NewProductForm newProductForm;
        private ProductDetail productDetail;


        @BeforeClass
        public void setUp() {
            loginPage = new LoginPage();
            mainApp = loginPage.loginAsPrimaryUser();
            pageMenuBar = mainApp.goToPageMenuBar();
            productsPage = pageMenuBar.clickProducts();
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
                pageMenuBar = mainApp.goToPageMenuBar();

            }}




