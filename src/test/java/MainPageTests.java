import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTests extends BaseUI {

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
    public void testBookNowTab() {
        mainPage.clickBookNowTab();
        String currentUrlBookNow = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlBookNow, Data.expectedUrlTours);
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
}
