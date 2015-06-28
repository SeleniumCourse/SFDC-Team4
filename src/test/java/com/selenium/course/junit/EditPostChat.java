package com.selenium.course.junit;

import com.selenium.course.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EditPostChat {
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
		postContent = "--------This message will be edited------------";
		chatterPage = chatterPage.createAnewPost(postContent);
		chatterPage.waitToPublishedPost();
    }
	
	@Test
    public void EditLatestPost() {
		String newMessage = "Text has already been edited";
		chatterPage.expandLatestDropDown();
		EditChatPage editChatPage = chatterPage.openEditDialog();
		editChatPage.modifyPostMessage(newMessage);
		chatterPage = editChatPage.clickSaveBtn();
		chatterPage.refreshPage();

		assertTrue(chatterPage.verifyNewPostIsThere(newMessage));
	}
	
	@After
    public void tearDown() {
		chatterPage.expandLatestDropDown();
		chatterPage.removeLatestPost();
		chatterPage.closeDialog();

    }

}
