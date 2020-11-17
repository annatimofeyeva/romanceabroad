import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='navbar-nav']//li")));
        for (int i = 0; i < list.size(); i++) {
           /* resolving  StaleElementReferenceException;
            OpenQA.Selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document*/
            list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='navbar-nav']//li")));
            String info = list.get(i).getText();
            list.get(i).click();

            if (info.equals("HOME")) {
                System.out.println(driver.getCurrentUrl());
                Assert.assertEquals(Data.expectedUrlHome, driver.getCurrentUrl());

            }
            // +
            if (info.contains("WORK")) {
                System.out.println(driver.getCurrentUrl());
                wait.until(ExpectedConditions.elementToBeClickable(Locators.PAGE_TITLE));
                String actualTitle = driver.findElement(Locators.PAGE_TITLE).getText();
                Assert.assertEquals(Data.expectedTitleHowItWoks, actualTitle);
            }

            if (info.equals("PRETTY WOMEN")) {
                System.out.println(driver.getCurrentUrl());
                WebElement firstImage =
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Tanua']")));
                //firstImage.click();
                System.out.println(firstImage);
                boolean firstPhoto = firstImage.isDisplayed();
                if (firstPhoto) {
                    Assert.assertEquals(Data.expectedUrlSearch, driver.getCurrentUrl());
                } else {
                    Assert.fail("Photos are not displayed");
            }


            driver.get(Data.mainUrl);
            list = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));

        }

    }

} // end of class
