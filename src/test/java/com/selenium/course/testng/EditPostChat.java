package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class EditPostChat {
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
		postContent = "--------This message will be edited------------";
		chatterPage = chatterPage.createAnewPost(postContent);
		chatterPage.waitToPublishedPost();
    }
	
	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void EditLatestPost() {
		String newMessage = "Text has already been edited";
		chatterPage.expandLatestDropDown();
		EditChatPage editChatPage = chatterPage.openEditDialog();
		editChatPage.modifyPostMessage(newMessage);
		chatterPage = editChatPage.clickSaveBtn();
		chatterPage.refreshPage();

		assertTrue(chatterPage.verifyNewPostIsThere(newMessage));
	}
	
	@AfterClass
    public void tearDown() {
		chatterPage.expandLatestDropDown();
		chatterPage.removeLatestPost();
		chatterPage.closeDialog();

    }

}
