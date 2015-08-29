package com.selenium.course.testng;

import com.selenium.course.pages.*;
import com.sun.jna.platform.win32.Advapi32Util;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public class LoginTest {
    AccountForm accountForm;
    @Test
    public void testuntitled() {
        String primaryUsernameLoggedIn = "Sibone Espinoza";
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        TabPage accountPage = contentPage.tabBar.clickAccounts();
        ObjectFormPage accountForm1 = accountPage.clickNewBtn();
        accountForm = new AccountForm(accountForm1.driver);
        accountForm.setAccountNameText("test001");
        accountForm.clickSaveBtn();

        //Assert.assertEquals(contentPage.getLoginUsername(),primaryUsernameLoggedIn);
    }

    @AfterClass
    public void tearDown() {
        accountForm.goToNavigationLinks().clickLogoutBtn();
    }


}
