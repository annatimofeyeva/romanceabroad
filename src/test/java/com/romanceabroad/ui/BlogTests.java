package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;


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
        Assert.assertEquals(blogPage.checkAllContentPagesLinks(), Data.expectedallAllTopBarLinks);
    }
}



