package com.selenium.course.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.selenium.course.framework.DriverManager;
import com.selenium.course.pages.HelpPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.MyProfilePage;
import com.selenium.course.pages.NavigationLinks;
import com.selenium.course.pages.PageMenuBar;
import com.selenium.course.pages.UserMenu;

public class Login {
	private LoginPage loginPage;
	private UserMenu userMenu;
	private MyProfilePage myProfilePage;
	private PageMenuBar pageMenuBar;
	private MainApp mainApp;
	private NavigationLinks navigationLinks;
	private HelpPage helpPage;

    @Before
    public void setUp() {
    	loginPage = new LoginPage();
    }
    
    @Test
    public void testUntitled() {
        String email = "gcavero@hotmail.com";
        String password = "Gus.jala1";
        
        mainApp = loginPage.loginAs(email, password);
        navigationLinks = mainApp.goToNavigationLinks();
        userMenu = navigationLinks.clickUserMenu();
        loginPage = userMenu.clickLogout();
        mainApp = loginPage.loginAs(email, password);
        
        navigationLinks = mainApp.goToNavigationLinks();
        userMenu = navigationLinks.clickUserMenu();
        myProfilePage = userMenu.clickMyProfile();
        assertTrue(myProfilePage.MyProfilePageIsDisplayed());
        
        pageMenuBar = mainApp.goToPageMenuBar();
        pageMenuBar.clickHomeTab();
        
        navigationLinks = mainApp.goToNavigationLinks();
        helpPage = navigationLinks.clickHelp();
        
        assertTrue(helpPage.isHelpPageDisplayed());
        
        mainApp = helpPage.closeHelpPage();

    }

    @After
    public void tearDown() {
    	
    }
}
