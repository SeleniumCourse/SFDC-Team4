package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Predicate;

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

    private String containerXpath = "//*[@id='feedwrapper']/div/div[4]"; ////*[@class='cxfeeditem feeditem'][1]
    private String commentLinkXpath = "//*[@id='feedwrapper']/div/div[4]//*[text()='Comment']";
    private String likeLinkText="Like";
    private String shareLinkText = "Share";
    private String commentButtonXpath = "//*[@id='feedwrapper']/div//input[@value='Comment']";
    private String CommentTextAreaXpath = "//*[@id='feedwrapper']/div//*[@class='newcommenttextwrapper']//*";

    public ChatterCommentPage(WebDriver driver)
    {
        super(driver);
        container=driver.findElement(By.xpath(containerXpath));
        commentLink=driver.findElement(By.xpath(commentLinkXpath));
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
        textArea=driver.findElement(By.xpath(CommentTextAreaXpath));
        wait.until(ExpectedConditions.visibilityOf(textArea));
        textArea.sendKeys(post);
        return this;
    }

    public ChatterCommentPage clickCommentButton()
    {
        commentButton=driver.findElement(By.xpath(commentButtonXpath));
        commentButton.click();
        return this;
    }
}
