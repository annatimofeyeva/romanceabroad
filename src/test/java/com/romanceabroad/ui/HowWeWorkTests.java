package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;


public class HowWeWorkTests extends BaseUI {
    @Test
    public void testClickOnFooterLink() {
        mainPage.clickHowWeWorkTab();
        Assert.assertEquals(howWeWorkPage.getSelectedFooterLink(), Data.expectedSelectedFooterUrl);
    }

    @Test
    public void testClickOnSelectedContentPageLink() {
        mainPage.clickHowWeWorkTab();
        Assert.assertEquals(howWeWorkPage.getSelectedContentPageLinkUrl(), Data.expectedContentLinkUrl);
    }

    @Test
    public void testGetContentPagesTitles() {
        mainPage.clickHowWeWorkTab();
        Assert.assertEquals(howWeWorkPage.getContentPagesTitles(), Data.expectedContentPageTitles);
    }

    @Test
    public void testGetContentPageNumber() {
        mainPage.clickHowWeWorkTab();
        Assert.assertEquals(howWeWorkPage.getNumberOfContentPages(), Data.expectedNumberOfContentPages);
    }

    @Test
    public void testGetFooterLinkTitles() {
        mainPage.clickHowWeWorkTab();
        Assert.assertEquals(howWeWorkPage.getFooterLinkTitles(), Data.expectedFooterTitles);
    }

    @Test
    public void testClickOnAllFooterLink() {
        mainPage.clickHowWeWorkTab();
        Assert.assertEquals(howWeWorkPage.checkAllFooterLinks(), Data.expectedFooterLinksUrls);
    }

    @Test
    public void testClickOnContentPagesTitles() {
        mainPage.clickHowWeWorkTab();
        howWeWorkPage.clickOnContentPagesTitles();
    }
}
