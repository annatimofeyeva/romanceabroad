package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class BlogTests extends BaseUI {
    @Test
    public void testVerifyBlogLinkUrl() {
        Assert.assertEquals(blogPage.verifyBlogLinkUrl(), Data.expectedUrlBlog);
        if (blogPage.verifyBlogLinkUrl().contains("#") || blogPage.verifyBlogLinkUrl().contains("???")) {
            Assert.fail("com.romanceabroad.ui.Algos.BlogPage URL contains wrong signs");
        }
    }

    @Test
    public void testArticlesAndTitles() {

        mainPage.getNavigate(Locators.LINK_BLOG);
        List<String> actualTitles = new ArrayList<>();
        List<WebElement> helpFooterLinks =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
        for (WebElement element : helpFooterLinks) {
            actualTitles.add(element.getText());
        }
        System.out.println(actualTitles);
        // i < actualFooterTitles.size() -1   because last array element is not displaying on the actual footer. it's <span>...<iframe> ..text()="Mobile"
        for (int i = 0; i < actualTitles.size() - 1; i++) {
            System.out.println("Title of the link: " + actualTitles.get(i));
        }
        Assert.assertEquals(Data.expectedallAllTopBarLinks, actualTitles);
    }
}



