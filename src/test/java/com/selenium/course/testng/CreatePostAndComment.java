package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Elmer Alvarado on 9/7/2015.
 */
public class CreatePostAndComment
{
    private ChatterPage chatterPageForm;
    private LoginPage loginPage;
    private ContentPage contentPage;
    private ChatterCommentPage chatterCommentPage;

    private String postTitle="Text Case02";
    private String commentText="Adding New Steps";

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage();
        contentPage = loginPage.loginAsPrimaryUser();
        chatterPageForm = contentPage.tabBar.clickChatter();
        chatterPageForm.setTestToShare(postTitle);
        chatterCommentPage = new ChatterCommentPage(chatterPageForm.shareText().getDriver());
    }

    @Test(groups = {"BVT, Acceptance, Funcional"})
    public void CreatePostCommentTc()
    {
        chatterCommentPage.clickCommentLink()
                .setPostText(commentText)
                .clickCommentButton();
    }
}
