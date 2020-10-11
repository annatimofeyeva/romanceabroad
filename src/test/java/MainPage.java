import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MainPage {
    private String mainUrl = "https://romanceabroad.com/";
    private WebDriver driver;
    private WebDriverWait wait;
    private String currentUrl;
    private String expectedUrlHome = "https://romanceabroad.com/#";
    private String expectedUrlHowWeWork = "https://romanceabroad.com/content/view/how-it-works";
    private String expectedUrlSearch = "https://romanceabroad.com/users/search";
    private String expectedUrlPhotos = "https://romanceabroad.com/media/index";
    private String expectedUrlGifts = "https://romanceabroad.com/store/category-sweets";
    private String expectedUrlTours = "https://romanceabroad.com/store/sweets/20-tour_to_ukraine";
    private String expectedUrlBlog = "https://romanceabroad.com/content/view/blog";
    private String expectedFacebookInbtegrationUrl = "https://m.facebook.com/RomanceAbroad/?ref=bookmarks";
    private String expectedUrlSignIn = "https://romanceabroad.com/users/login_form";
    private String expectedToursToUkraineTitle = "TOURS TO UKRAINE";
    private String expectedLoginFormTitle = "Login";
    private String expectedBlogPageTitle = "Blog";
    private String expectedPayPalButtonText = "Pay with PayPal";
    private String expectedDiscount = "$4 999.00";
    private String expectedEmailFieldTitle = "Email :";
    private String expectedLoginErrorPopUpText = "Login or password are incorrect, please try again";
    private String expectedBackgroundColor = "rgb(235, 204, 209)";
    private By LINK_HOME = By.xpath("//a[@href='#']");
    private By LINK_HOW_WORK = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    private By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    private By LINK_PHOTOS = By.xpath("//a[@href='https://romanceabroad.com/media/index']");
    private By LINK_GIFTS = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");
    private By LINK_TOUR = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'][text()='TOUR TO UKRAINE']");
    private By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
    private By LINK_SIGH_IN = By.cssSelector("#ajax_login_link");
    private By EMAIL_TEXT_FIELD = By.xpath(" //input[@name='email']");
    private By PASSWORD_TEXT_FIELD = By.xpath(" //input[@name='password']");
    private By BUTTON_SIGN_IN = By.xpath("//button[@name='logbtn']");
    private By ERROR_POP_UP = By.xpath("//div[@class='error alert-danger alert-warning_pop_']");
    private By LINK_BOOK_NOW = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']");
    private By BUTTON_JOIN_FOR_FREE = By.xpath("//button[@id='show-registration-block']");
    private By TEXT_FIELD_EMAIL = By.xpath("//label[@for='email']");
    private By BUTTON_REQUESR_TOUR = By.xpath("//a[@class='btn btn-primary btn-xl js-scroll-trigger']");
    private By BUTTON_PLAY_YOUTUBE = By.xpath("//button[@aria-label='Play']");
    private By IFRAME = By.xpath("//iframe[contains(@src, 'https://www.youtube.com/embed/RRECuJzm3IY?start=85')]");
    private By BUTTON_FACEBOOK_REDIRACTION = By.xpath("//img[@src='/img/facebook-ico.jpg']");
    private By BUTTON_YouTube_REDIRACTION = By.xpath("//a[@href='https://www.youtube.com/channel/UCCmXAG1ToSyHymqYzzJcTfQ']");
    private By AGE_DROP_DOWN = By.cssSelector("#age_max");
    private By BUTTON_SORTING_PHOTOS = By.cssSelector(".hidden-xs.fa.fa-arrow-down.pointer.plr5");
    private By BUTTON_ADD_PHOTO = By.cssSelector(".caret");
    private By LIST_OF_BESTSELLERS = By.xpath("//div[@class='g-users-gallery__item col-xs-4 col-md-3 col-lg-2 bestseller']");
    private By TEXT_FIELD_GIFTS_SEARCH = By.cssSelector("#search_product");
    private By BUTTON_GIFTS_SEARCH = By.cssSelector("#search_friend");
    private By BUTTON_MAIN_NAV_BAR = By.cssSelector(".fa.fa-bars.fa-lg.item");
    private By HEADER_TOURS_TO_UKRAIN = By.xpath("//div[@class='search-header']/h1");
    private By BLOG_TITLE = By.xpath("//h1");
    private int indexValueForYouTubeVideoElement = 0;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(mainUrl);
        wait = (new WebDriverWait(driver, 20));
    }

    @Test
    public void testHomeTab() {
        driver.findElement(LINK_HOME).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrlHome);
    }

    @Test
    public void testHowWeWorkTab() {
        driver.findElement(LINK_HOW_WORK).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrlHowWeWork);
    }

    @Test
    public void testPrettyWomanTab() {
        driver.findElement(LINK_SEARCH).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrlSearch);
    }

    @Test
    public void testPrettyWomenMaxAgeChaneDropDown() {
        driver.findElement(LINK_SEARCH).click();
        WebElement dropDown =
                wait.until(ExpectedConditions.presenceOfElementLocated(AGE_DROP_DOWN));
        dropDown.click();
    }

    @Test
    public void testPhotosTab() {
        driver.findElement(LINK_PHOTOS).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrlPhotos);
    }

    @Test
    public void testPhotosSorting() {
        driver.findElement(LINK_PHOTOS).click();
        WebElement sortingPhotoButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_SORTING_PHOTOS));
        sortingPhotoButton.click();
    }

    @Test
    public void testAddPhotoButton() {
        driver.findElement(LINK_PHOTOS).click();
        WebElement addPhotoButton = wait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_ADD_PHOTO));
        addPhotoButton.click();
    }

    @Test
    public void testGiftsTab() {
        driver.findElement(LINK_GIFTS).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrlGifts);
    }

    @Test
    public void testGiftsTabBestsellersSelected() {
        driver.findElement(LINK_GIFTS).click();
        currentUrl = driver.getCurrentUrl();
        List bestsellers =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(LIST_OF_BESTSELLERS));
        //System.out.println(bestsellers.size());
        Assert.assertEquals(currentUrl, expectedUrlGifts);
        Assert.assertTrue(bestsellers.size() > 0);
    }

    @Test
    public void testSearchForExactGift() {
        driver.findElement(LINK_GIFTS).click();
        WebElement giftSearchField =
                wait.until(ExpectedConditions.presenceOfElementLocated(TEXT_FIELD_GIFTS_SEARCH));
        giftSearchField.sendKeys("Flower busket");
        WebElement giftSearchButton = driver.findElement(BUTTON_GIFTS_SEARCH);
        giftSearchButton.click();
    }

    @Test
    public void testSearchForGiftsAndClickMainNavBar() {
        driver.findElement(LINK_GIFTS).click();
        WebElement mainNavBarButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_MAIN_NAV_BAR));
        mainNavBarButton.click();
    }

    @Test
    public void testToutToUkraineTab() {
        driver.findElement(LINK_TOUR).click();
        currentUrl = driver.getCurrentUrl();
        String searchToursToUkraineHeader =
                wait.until(ExpectedConditions.presenceOfElementLocated(HEADER_TOURS_TO_UKRAIN))
                        .getText();
        Assert.assertEquals(expectedToursToUkraineTitle, searchToursToUkraineHeader);
        Assert.assertEquals(currentUrl, expectedUrlTours);

    }

    @Test
    public void testBlogTab() {
        driver.findElement(LINK_BLOG).click();
        currentUrl = driver.getCurrentUrl();
        String blogTitle =
                wait.until(ExpectedConditions.presenceOfElementLocated(BLOG_TITLE))
                        .getText();
        Assert.assertEquals(currentUrl, expectedUrlBlog);
        Assert.assertEquals(expectedBlogPageTitle, blogTitle);
    }

    @Test
    public void testSignInInvalidCredentials() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LINK_SIGH_IN)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(EMAIL_TEXT_FIELD))
                .sendKeys("test@test.com");
        driver.findElement(PASSWORD_TEXT_FIELD)
                .sendKeys("123456");
        driver.findElement(BUTTON_SIGN_IN).click();
        WebElement error_popUp = wait.until(ExpectedConditions.presenceOfElementLocated(ERROR_POP_UP));
        String currentBackgroundColor = error_popUp.getCssValue("border-color");
        //System.out.println(currentBackgroundColor);
        Assert.assertEquals(currentBackgroundColor, expectedBackgroundColor);
        String errorPopUpText = error_popUp.getText();
        //System.out.println(errorPopUpText);
        Assert.assertEquals(errorPopUpText, expectedLoginErrorPopUpText);
        List<WebElement> errorPopUp =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ERROR_POP_UP));
        //System.out.println(errorPopUp.size());
        Assert.assertEquals(errorPopUp.size(), 1);
        Assert.assertTrue(errorPopUp.size() > 0);
    }

    @Test
    public void testBookNowTab() {
        driver.findElement(LINK_BOOK_NOW).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrlTours);
    }

    @Test
    public void testJoinForFreeButton() {
        driver.findElement(BUTTON_JOIN_FOR_FREE).click();
        String emailFieldTitle =
                wait.until(ExpectedConditions.presenceOfElementLocated(TEXT_FIELD_EMAIL))
                        .getText();
        Assert.assertEquals(expectedEmailFieldTitle, emailFieldTitle);
    }

    // ? How to assert file downloading
    // https://www.seleniumeasy.com/selenium-tutorials/verify-file-after-downloading-using-webdriver-java
    @Test
    public void testRequestTourButton() {
        WebElement requestTourButton = driver.findElement(BUTTON_REQUESR_TOUR);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        requestTourButton.click();
    }

    // How to assert video playing, how to stop/ replay video in IFrame??
    @Test
    public void testPlayVideoButton() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,550)", "");
        WebElement required_frame = driver.findElement(IFRAME);
        driver.switchTo().frame(required_frame);
        WebElement playButton = driver.findElement(BUTTON_PLAY_YOUTUBE);
        playButton.click();
    }

    @Test
    public void testFacebookRedirectionButton() {
        WebElement facebookButton = driver.findElement(BUTTON_FACEBOOK_REDIRACTION);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        facebookButton.click();
    }

    @Test
    public void testYouTubeRedirectionButton() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElements(BUTTON_FACEBOOK_REDIRACTION).get(indexValueForYouTubeVideoElement).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
