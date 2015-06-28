package com.selenium.course.testng;

import com.selenium.course.pages.ChatterPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.PageMenuBar;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class CreatePostChat {
	private LoginPage loginPage;
	private MainApp mainApp;
	private PageMenuBar pageMenuBar;
	private ChatterPage chatterPage;

	String postContent;
	
	@BeforeClass
    public void setUp() {
		loginPage = new LoginPage();
		mainApp = loginPage.loginAsPrimaryUser();
        pageMenuBar = mainApp.goToPageMenuBar();
		chatterPage = pageMenuBar.clickChatter();
    }

	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void postChat() {
		postContent = "***************New post to create ***********";
		chatterPage.createAnewPost(postContent);
		chatterPage.refreshPage();
		assertTrue(chatterPage.verifyNewPostIsThere(postContent));
	}
	
	@AfterClass
    public void tearDown() {
		chatterPage.expandLatestDropDown();
		chatterPage.removeLatestPost();
		chatterPage.closeDialog();
    }

}
