import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainPageTests extends BaseUI {

    @Test
    public void testSmokeMainPage() {
        mainPage.smokeMainPage();
    }

    @Test
    public void testClickNavigationTabs() {
        String actualTitle;
        String info;
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_ALL_TOP_BAR_TABS));
        for (int i = 0; i < list.size(); i++) {
            info = list.get(i).getText();
           /* resolving  StaleElementReferenceException;
            OpenQA.Selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document*/
            list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_ALL_TOP_BAR_TABS));
            //list.get(i).click();
            mainPage.ajaxClick(list.get(i));

            if (info.equals("HOME")) {
                System.out.println(driver.getCurrentUrl());
                Assert.assertEquals(Data.expectedUrlHome, driver.getCurrentUrl());
            }
            if (info.contains("WORK")) {
                System.out.println(driver.getCurrentUrl());
                wait.until(ExpectedConditions.elementToBeClickable(Locators.PAGE_TITLE));
                actualTitle = driver.findElement(Locators.PAGE_TITLE).getText();
                Assert.assertEquals(Data.expectedTitleHowItWoks, actualTitle);
            }

            if (info.equals("PRETTY WOMEN")) {
                System.out.println(driver.getCurrentUrl());
                WebElement firstImage =
                        wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_SEARCH_FIRST_IMAGE_TITLE));
                //firstImage.click();
                System.out.println(firstImage);
                boolean firstPhoto = firstImage.isDisplayed();
                if (firstPhoto) {
                    Assert.assertEquals(Data.expectedUrlSearch, driver.getCurrentUrl());
                } else {
                    Assert.fail("Photos are not displayed");
                }
            }
            if (info.equals("PHOTOS")) {
                System.out.println(driver.getCurrentUrl());
                List<WebElement> links =
                        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_PHOTOS_ALL));
                int linksSize = links.size();
                System.out.println(links.size());
                if (linksSize == 4) {
                    System.out.println("All links are displayed");
                } else {
                    Assert.fail("Not all links displayed in top page navBar");
                }
                System.out.println(driver.getCurrentUrl());
                Assert.assertEquals(Data.expectedUrlPhotos, driver.getCurrentUrl());
            }
            if (info.equals("GIFTS")) {
                WebElement bestsellers =
                        wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_BESTSELLERS));
                if (bestsellers.isDisplayed()) {
                    actualTitle = bestsellers.getText();
                    System.out.println(actualTitle);
                    Assert.assertEquals(Data.expectedbestsellerTitle, actualTitle);
                } else {
                    Assert.fail("No bestsellers displays");
                }
            }
            if (info.equals("TOUR TO UKRAINE")) {
                WebElement payPalButton =
                        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_PAY_PAL));
                System.out.println(payPalButton.getText());
                WebElement title =
                        wait.until(ExpectedConditions.elementToBeClickable(Locators.TOURS_TO_UKRAINE_TITLE));
                actualTitle = title.getText();
                if (payPalButton.isDisplayed() && title.isDisplayed()) {
                    Assert.assertEquals(Data.expectedToursToUkraineTitle, actualTitle);
                }
            }
            if (info.equals("BLOG")) {
                System.out.println("Blog");
                List<WebElement> blogList =
                        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_ALL));
                System.out.println(blogList.size());
                int size = blogList.size();
                if (size == 24) {
                    Assert.assertEquals(Data.expectedUrlBlog, driver.getCurrentUrl());
                } else {
                    Assert.fail("Some dating agencyes are missing in the list");
                }
            }
            if (info.equals("SIGN IN")) {
                if (driver.findElement(Locators.SIGH_IN_TITLE).isDisplayed()) {
                    System.out.println("Login form is displays");
                } else {
                    Assert.fail("Login for is not displayed");
                }
            }
            driver.get(Data.mainUrl);
            list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_ALL_TOP_BAR_TABS));
        }
    }

    @Test
    public void testClickTopBarTab() {
        String actualSelectedTabUrl = mainPage.clickTopBarTab();
        Assert.assertEquals(actualSelectedTabUrl, Data.expectedUrlSearch);
    }

    @Test
    public void testAjaxClickUsingLocator() {
        mainPage.ajaxClick(driver.findElement(Locators.LINK_JOIN_US));
    }

    @Test
    public void testAjaxClickOnMainPageTopTabUsingIndex() {
        mainPage.ajaxClick(Locators.LINK_ALL_TOP_BAR_TABS, 2);
        //mainPage.performedClick(Locators.LINK_ALL_TOP_BAR_TABS, 2);
        //mainPage.scrollToBottomOfPage();
    }

    @Test
    public void testAjaxSendKeys() {
        mainPage.ajaxSendKeys();
    }

    @Test
    public void testCheckAllLinksAndImages() {
        mainPage.checkAllLinksAndImagesMainPage();
    }

    @Test
    public void testVerifyLinkBlogActive() {
        mainPage.verifyLinkBlogActive();
    }
}



