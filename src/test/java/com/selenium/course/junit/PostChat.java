package com.selenium.course.junit;

import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.PageMenuBar;
import com.selenium.course.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PostChat {
	private LoginPage loginPage;
	private MainApp mainApp;
	private PageMenuBar pageMenuBar;
	private ChatterPage chatterPage;

	String postContent;
	
	@Before
    public void setUp() {
		loginPage = new LoginPage();
		mainApp = loginPage.loginAsPrimaryUser();
        pageMenuBar = mainApp.goToPageMenuBar();
		chatterPage = pageMenuBar.clickChatter();
    }
	
	@Test
    public void postChat() {
		postContent = "campos data Data to post from script";
		chatterPage.createAnewPost(postContent);
		chatterPage.refreshPage();
		assertTrue(chatterPage.verifyNewPostIsThere(postContent));
	}
	
	@After
    public void tearDown() {
		chatterPage.expandLatestDropDown();
		chatterPage.removeLatestPost();
    }

}
