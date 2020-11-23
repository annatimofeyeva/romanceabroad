import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainPageTests extends BaseUI {

    @Test
    public void testBookNowTab() {
        Assert.assertEquals(mainPage.clickBookNowTab(), Data.expectedUrlTours);
    }

    @Test
    public void testHowWeWorkTab() {
        mainPage.clickHowWeWorkTab();
        String currentUrlHowWeWork = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlHowWeWork, Data.expectedUrlHowWeWork);
    }

    @Test
    public void testSearchTab() {
        mainPage.clickSearchTab();
        String currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        //Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);
        // in case of soft assertion - if something is wrong = Error message provided, but TC moves to a next step;
        softAssert.assertEquals(Data.expectedUrlSearch, currentUrlSearch, "Url is wrong");
        softAssert.assertAll();
    }

    @Test
    public void testMediaTab() {
        mainPage.clickMediaTab();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_ADD_PHOTO));
        String currentUrlPhotos = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlPhotos, Data.expectedUrlPhotos);
    }

    @Test
    public void testGiftsTab() {
        mainPage.clickGiftsTab();
        String currentUrlGifts = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlGifts, Data.expectedUrlGifts);
    }

    @Test
    public void testTourToUkraineTab() {
        mainPage.clickTourToUkraineTab();
        String currentUrlTours = driver.getCurrentUrl();
        String searchToursToUkraineHeader =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.HEADER_TOURS_TO_UKRAINE))
                        .getText();
        Assert.assertEquals(Data.expectedToursToUkraineTitle, searchToursToUkraineHeader);
        Assert.assertEquals(currentUrlTours, Data.expectedUrlTours);
    }

    @Test
    public void testBlogTab() {
        mainPage.clickBlogTab();
        String currentUrlBlog = driver.getCurrentUrl();
//        Example of Implicit wait:
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        String blogTitle = driver.findElement(Locators.BLOG_TITLE).getText();
        String blogTitle =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BLOG_TITLE))
                        .getText();
        Assert.assertEquals(currentUrlBlog, Data.expectedUrlBlog);
        Assert.assertEquals(Data.expectedBlogPageTitle, blogTitle);
    }

    @Test
    public void testSighInTab() {
        mainPage.clickSignInTab();
    }

    @Test
    public void testRegistration() {
        mainPage.clickJoinButton();
    }

    @Test
    public void testYouTubeVideoPlaying() {
        mainPage.clickYouTubeVideoButton();
    }

    @Test
    public void testRequestTourButton() {
        mainPage.clickRequestTourButton();
    }

    @Test
    public void testFacebookIntegrationButton() {
        mainPage.clickFacebookRedirectionButton();
    }

    @Test
    public void testClickNavigationTabs() {
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_ALL_TOP_BAR_TABS));
        for (int i = 0; i < list.size(); i++) {
            String info = list.get(i).getText();
           /* resolving  StaleElementReferenceException;
            OpenQA.Selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document*/
            list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_ALL_TOP_BAR_TABS));
            list.get(i).click();
            if (info.equals("HOME")) {
                System.out.println(driver.getCurrentUrl());
                Assert.assertEquals(Data.expectedUrlHome, driver.getCurrentUrl());
            }
            if (info.contains("WORK")) {
                System.out.println(driver.getCurrentUrl());
                wait.until(ExpectedConditions.elementToBeClickable(Locators.PAGE_TITLE));
                String actualTitle = driver.findElement(Locators.PAGE_TITLE).getText();
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
                    String title = bestsellers.getText();
                    System.out.println(title);
                    Assert.assertEquals(Data.bestsellerTitle, title);
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
                String titleText = title.getText();
                if (payPalButton.isDisplayed() && title.isDisplayed()) {
                    Assert.assertEquals(Data.expectedToursToUkraineTitle, titleText);
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
            list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='collapse navbar-collapse']//ul//li")));
        }
    }
}



