package com.selenium.course.testng;

import com.selenium.course.framework.WebDriverManager;
import com.selenium.course.pages.ChatterPage;
import com.selenium.course.pages.ContentPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.TabBar;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Joel Rodriguez
 */

public class CreatePostChat {
    private ChatterPage chatterPageForm;
    private ChatterPage chatterPage;

    String text;

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        TabBar tabBar = contentPage.goToTabBar();
        tabBar.clickChatter();
    }

    @Test(groups = {"BVT, Acceptance, Funcional"})
    public void testCreateNewCampaign() {

        text = "***************New post to create ***********";

        WebDriver driver = WebDriverManager.getInstance().getDriver();

        chatterPageForm = new ChatterPage(driver)
                .setTestToShare(text)
                .shareText();

        Assert.assertTrue(chatterPageForm.verifyNewSharedPost(text));
    }

    @AfterClass
    public void tearDown() {
        chatterPage = chatterPageForm.setTestToShare("");
        chatterPage.goToNavigationLinks().clickLogoutBtn();
    }
}
