package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FooterPageTests extends BaseUI {

    @Test
    public void testFooterLinkTitles() {
        mainPage.clickHowWeWorkTab();
        List<String> actualFooterTitles = new ArrayList<>();
        List<WebElement> helpFooterLinks =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINKS_TITLES_FOOTER));
        for (WebElement element : helpFooterLinks) {
            actualFooterTitles.add(element.getText());
        }
        System.out.println(actualFooterTitles);
        // i < actualFooterTitles.size() -1   because last array element is not displaying on the actual footer. it's <span>...<iframe> ..text()="Mobile"
        for (int i = 0; i < actualFooterTitles.size() - 1; i++) {
            System.out.println("Title of Footers link: " + actualFooterTitles.get(i));
        }
        Assert.assertEquals(Data.expectedFooterTitles, actualFooterTitles);
    }

    @Test
    public void testAllFooterLinks() {
        mainPage.clickHowWeWorkTab();
        List<String> footerLinksUrls = new ArrayList<>();
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINKS_TITLES_FOOTER));
        // i < list.size() -1   because last array element is not displaying on the footer. it's <span>...<iframe> ..text()="Mobile"
        for (int j = 0; j < list.size() - 1; j++) {
            list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINKS_TITLES_FOOTER));
            footerPage.ajaxClick(list.get(j));
            footerLinksUrls.add(driver.getCurrentUrl());
        }
        System.out.println("All footer's URLs: ");
        footerLinksUrls.stream().forEach(System.out::println);
        Assert.assertEquals(Data.expectedFooterLinksUrls, footerLinksUrls);
    }

    @Test
    public void testClickOnSelectedFooterLink() {
        mainPage.clickHowWeWorkTab();
        String selectedFooterLink = footerPage.getSelectedFooterLink();
        List<WebElement> footerLinksUrlsList =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINKS_TITLES_FOOTER));
        for (int k = 0; k < footerLinksUrlsList.size() - 1; k++) {
            String actualFooterLinkText = footerLinksUrlsList.get(k).getText();
            if (actualFooterLinkText.contains(selectedFooterLink)) {
                footerLinksUrlsList.get(k).click();
            }
        }
        String actualSelectedFooterUrl = driver.getCurrentUrl();
        System.out.println(actualSelectedFooterUrl);
        Assert.assertEquals(Data.expectedSelectedFooterUrl, actualSelectedFooterUrl);
    }
}
