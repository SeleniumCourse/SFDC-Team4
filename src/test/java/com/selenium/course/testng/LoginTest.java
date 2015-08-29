package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public class LoginTest {

    @Test
    public void testuntitled() {
        String primaryUsernameLoggedIn = "Sibone Espinoza";
        LoginPage loginPage = new LoginPage();
        MainApp mainApp = loginPage.loginAsPrimaryUser();
        Assert.assertEquals(mainApp.getLoginUsername(),primaryUsernameLoggedIn);
    }

    @AfterClass
    public void tearDown() {

    }


}
