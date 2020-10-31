import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTests extends BaseUI {

    @Test
    public void testHowWeWorkTab() {
        mainPage.clickHowWeWorkTab();
    }

    @Test
    public void testSearchTab() {
        mainPage.clickSearchTab();
        String currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        //Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);

        // in case of soft assertion - if smth is wrong = Error message provided, but TC moves to a next step;
        softAssert.assertEquals(Data.expectedUrlSearch, currentUrlSearch, "Url is wrong");
        softAssert.assertAll();
    }

    @Test
    public void testMediaTab() {
        mainPage.clickMediaTab();
    }

    @Test
    public void testGiftsTab() {mainPage.clickGiftsTab();}

    @Test
    public void testTourToUkraineTab() {
        mainPage.clickTourToUkraineTab();
    }

    @Test
    public void testBlogTab() {
        mainPage.clickBlogTab();
    }

    @Test
    public void testSighInTab() {mainPage.clickSignInTab(); }

    @Test
    public void testBookNowTab() {
        mainPage.clickBookNowTab();
    }

    @Test
    public void testRegistration() {mainPage.clickJoinButton(); }

    @Test
    public void testYouTubeVideoPlaying() {
        mainPage.clickYouTubeVideoButton();
    }

    @Test
    public void testRequestTourButton() {
        mainPage.clickRequestTourButton();
    }

    @Test
    public void testFacebookIntegrationButton() {mainPage.clickFacebookRedirectionButton(); }
}
