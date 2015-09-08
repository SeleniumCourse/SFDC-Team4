package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Elmer Alvarado on 9/7/2015.
 */
public class ChatterCommentPage extends ObjectFormPage
{
    protected WebElement container;
    protected WebElement commentLink;
    protected WebElement likeLink;
    protected WebElement shareLink;
    protected WebElement textArea;
    protected WebElement commentButton;

    private String containerXpath = "//*[@id='feedwrapper']//*[@class='cxfeeditem feeditem'][1]";
    private String commentLinkText = "Comment";
    private String likeLinkText="Like";
    private String shareLinkText = "Share";
    private String commentButtonXpath = "//button[@value='Comment']";
    private String CommentTextAreaXpath = "//textarea";

    public ChatterCommentPage(WebDriver driver)
    {
        super(driver);
        container=driver.findElement(By.xpath(containerXpath));
        commentLink=container.findElement(By.linkText(commentLinkText));
        likeLink=container.findElement(By.linkText(likeLinkText));
        shareLink=container.findElement(By.linkText(shareLinkText));
    }

    public ChatterCommentPage clickCommentLink()
    {
        commentLink.click();
        return this;
    }

    public ChatterCommentPage clickShareLink()
    {
        shareLink.click();
        return this;
    }

    public ChatterCommentPage clickLikeLink()
    {
        likeLink.click();
        return this;
    }

    public ChatterCommentPage setPostText(String post)
    {
        textArea=container.findElement(By.xpath(commentButtonXpath));
        setTextFieldValue(textArea, post);
        return this;
    }

    public ChatterCommentPage clickCommentButton()
    {
        commentButton=container.findElement(By.xpath(CommentTextAreaXpath));
        commentButton.click();
        return this;
    }
}
