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
    private int indexValue = 0;



    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(mainUrl);
        wait = (new WebDriverWait(driver, 20));
    }

    //MainPage all Tabs Test cases - HomeWork4:
    @Test
    public void testHomeTab() {
        driver.findElement(LINK_HOME).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrlHome);
    }

    @Test
    public void testHowWeWorkTab() {
        driver.findElement(LINK_HOW_WORK).click();
        String currentUrlHowWeWork = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlHowWeWork, expectedUrlHowWeWork);
    }

    @Test
    public void testPrettyWomanTab() {
        driver.findElement(LINK_SEARCH).click();
        String currentUrlSearch = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlSearch, expectedUrlSearch);
    }

    @Test
    public void testPhotosTab() {
        driver.findElement(LINK_PHOTOS).click();
        String currentUrlPhotos = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlPhotos, expectedUrlPhotos);
    }

    @Test
    public void testGiftsTab() {
        driver.findElement(LINK_GIFTS).click();
        String currentUrlGifts = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlGifts, expectedUrlGifts);
    }

    @Test
    public void testToutToUkraineTab() throws InterruptedException {
        driver.findElement(LINK_TOUR).click();
        String currentUrlTours = driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals(currentUrlTours, expectedUrlTours);
    }

    @Test
    public void testBlogTab() {
        driver.findElement(LINK_BLOG).click();
        String currentUrlBlog = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlBlog, expectedUrlBlog);
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
        System.out.println(currentBackgroundColor);
        Assert.assertEquals(currentBackgroundColor, expectedBackgroundColor);

        String errorPopUpText = error_popUp.getText();
        System.out.println(errorPopUpText);
        Assert.assertEquals(errorPopUpText, expectedLoginErrorPopUpText);

        List<WebElement> errorPopUp =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ERROR_POP_UP));
        System.out.println(errorPopUp.size());
        Assert.assertEquals(errorPopUp.size(), 1);
        Assert.assertTrue(errorPopUp.size() > 0);
    }

    @Test
    public void testBookNowTab() {
        driver.findElement(LINK_BOOK_NOW).click();
        String currentUrlBookNow = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlBookNow, expectedUrlTours);
    }

    @Test
    public void testJoinForFreeButton() {
        driver.findElement(BUTTON_JOIN_FOR_FREE).click();
        String emailFieldTitle = wait.until(ExpectedConditions.presenceOfElementLocated(TEXT_FIELD_EMAIL))
                .getText();
        //System.out.println(emailFieldTitle);
        Assert.assertEquals(expectedEmailFieldTitle, emailFieldTitle);
    }

    // ?? Verifying successfully file downloading ??
    // https://www.seleniumeasy.com/selenium-tutorials/verify-file-after-downloading-using-webdriver-java
    @Test
    public void testRequestTourButton() {
        WebElement requestTourButton = driver.findElement(BUTTON_REQUESR_TOUR);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        requestTourButton.click();
    }

    // How to make an Assertion that video is playing, how to stop/ replay video in IFrame ??
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
        driver.findElements(BUTTON_FACEBOOK_REDIRACTION).get(0).click();
    }

    @Test
    public void testCarousel() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElements(BUTTON_FACEBOOK_REDIRACTION).get(indexValue).click();
    }


//    // Xpath locators:
//    @Test
//    public void testPrettyWomenSearchTab() {
//        WebElement prettyWomenTab = driver.findElement(By.xpath("//a[text()='PRETTY WOMEN']"));
//        prettyWomenTab.click();
//        String currentUrlSearch = driver.getCurrentUrl();
//        Assert.assertEquals(currentUrlSearch, expectedUrlSearch);
//    }
//
//    @Test
//    public void testPrettyWomenSearchTabWithCssSelector() {
//        WebElement prettyWomenTab = driver.findElement(By.cssSelector("a[href='https://romanceabroad.com/users/search'"));
//        prettyWomenTab.click();
//        String expectedUrl = driver.getCurrentUrl();
//        Assert.assertEquals(expectedUrl, expectedUrlSearch);
//    }
//
//    @Test
//    public void testPhotosTab2() {
//        WebElement photosTab = driver.findElement(By.xpath("//a[text()='PHOTOS']"));
//        photosTab.click();
//        String currentUrlPhotos = driver.getCurrentUrl();
//        Assert.assertEquals(currentUrlPhotos, expectedUrlPhotos);
//    }
//
//    @Test
//    public void testGiftsTab2() {
//        WebElement giftsTab = driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']"));
//        giftsTab.click();
//        String currentUrlGifts = driver.getCurrentUrl();
//        List bestsellers = wait
//                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
//                        .xpath("//div[@class='g-users-gallery__item col-xs-4 col-md-3 col-lg-2 bestseller']")));
//        //System.out.println(bestsellers.size());
//        Assert.assertEquals(currentUrlGifts, expectedUrlGifts);
//        //Assert.assertTrue(bestsellers.size() > 0);
//    }
//
//    @Test
//    public void testTourToUkraineTab() {
//        WebElement tourToUkraineTab = driver.findElement(By.xpath("//a[contains(text(), 'TOUR TO')]"));
//        tourToUkraineTab.click();
//        String searchToursToUkraineHeader = wait
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='search-header']/h1")))
//                .getText();
//        //System.out.println(searchToursToUkraineHeader);
//        Assert.assertEquals(expectedToursToUkraineTitle, searchToursToUkraineHeader);
//    }
//
//    @Test
//    public void testBlogTab2() {
//        WebElement blogTab = driver.findElement(By.xpath("//a[text()='BLOG']"));
//        blogTab.click();
//        String currentUrlBlog = driver.getCurrentUrl();
//        String blogTitle = wait
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1")))
//                .getText();
//        //System.out.println(blogTitle);
//        Assert.assertEquals(currentUrlBlog, expectedUrlBlog);
//        Assert.assertEquals(expectedBlogPageTitle, blogTitle);
//    }
//
//    @Test
//    public void testBookNowTab2() {
//        WebElement bookNowTab = driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']"));
//        bookNowTab.click();
//        String discountNumbers = wait.until(ExpectedConditions.presenceOfElementLocated(By
//                .cssSelector(".mt20"))).getText();
//        //System.out.println(discountNumbers);
//        String tourDiscountPrice = driver.findElement(By.cssSelector(".bold.view-price.fs18")).getText();
//        //System.out.println(tourDiscountPrice);
//        Assert.assertEquals(expectedDiscount, tourDiscountPrice);
//    }
//
//    @Test
//    public void testHomeTabCss() {
//        WebElement homeTab = driver.findElement(By.xpath("//a[@href='#'][text()='HOME']"));
//        homeTab.click();
//        String homeTabUrl = driver.getCurrentUrl();
//        Assert.assertEquals(expectedUrlHome, homeTabUrl);
//    }
//
//    @Test
//    public void testJoinTodayButton() throws InterruptedException {
//        WebElement requestTourButton = driver.findElement(By.xpath("//a[@href='#'][text()='JOIN TODAY!']"));
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        Thread.sleep(5000);
//        requestTourButton.click();
//        String emailFieldTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='email']")))
//                .getText();
//        //System.out.println(emailFieldTitle);
//        Assert.assertEquals(expectedEmailFieldTitle, emailFieldTitle);
//    }
//
//    @Test
//    public void testFacebookIntegrationButton() {
//        WebElement facebookIntegrationButton = driver.findElement(By.xpath("//img[@src='/img/facebook-ico.jpg']"));
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        facebookIntegrationButton.click();
//    }
//
//    // CssSelector locators:
//    @Test
//    public void testSignInTab2() {
//        WebElement signInTab = driver.findElement(By.cssSelector("#ajax_login_link"));
//        signInTab.click();
//        WebElement loginFormTitleDynamicElement = wait
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='content-block load_content']/h1")));
//        String loginFormTitle = loginFormTitleDynamicElement.getText();
//        //System.out.println(loginFormTitle);
//        Assert.assertEquals(expectedLoginFormTitle, loginFormTitle);
//    }
//
//    @Test
//    public void testJoinForFreeButton2() {
//        WebElement joinForFreeButton = driver.findElement(By.cssSelector("#show-registration-block"));
//        joinForFreeButton.click();
//        String emailFieldTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='email']")))
//                .getText();
//        //System.out.println(emailFieldTitle);
//        Assert.assertEquals(expectedEmailFieldTitle, emailFieldTitle);
//    }
//
//    @Test
//    public void testSearchForGiftsTextField() {
//        driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']")).click();
//        WebElement giftSearchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#search_product")));
//        giftSearchField.sendKeys("Flower busket");
//    }
//
//    @Test
//    public void testSearchForExactGift() {
//        WebElement giftsTab = driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']"));
//        giftsTab.click();
//        WebElement giftSearchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#search_product")));
//        giftSearchField.sendKeys("Flower busket");
//        WebElement giftSearchButton = driver.findElement(By.cssSelector("#search_friend"));
//        giftSearchButton.click();
//    }
//
//    @Test
//    public void testSearchForGiftsAndClickOnNavBar() {
//        WebElement giftsTab = driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']"));
//        giftsTab.click();
//        WebElement navBarButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fa.fa-bars.fa-lg.item")));
//        navBarButton.click();
//    }
//
//    @Test
//    public void testPrettyWomenMinAgeChaneDropDown() {
//        WebElement prettyWomenTab = driver.findElement(By.xpath("//a[text()='PRETTY WOMEN']"));
//        prettyWomenTab.click();
//        WebElement dropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#age_min")));
//        dropDown.click();
//    }
//
//    @Test
//    public void testPrettyWomenMaxAgeChaneDropDown() {
//        WebElement prettyWomenTab = driver.findElement(By.xpath("//a[text()='PRETTY WOMEN']"));
//        prettyWomenTab.click();
//        WebElement dropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#age_max")));
//        dropDown.click();
//    }
//
//    @Test
//    public void testPrettyWomenTabMainSearchButton() {
//        WebElement prettyWomenTab = driver.findElement(By.xpath("//a[text()='PRETTY WOMEN']"));
//        prettyWomenTab.click();
//        WebElement mainSearchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main_search_button_user_advanced")));
//        mainSearchButton.click();
//    }
//
//    @Test
//    public void testAddPhotoButton() {
//        WebElement photosTab = driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/media/index']"));
//        photosTab.click();
//        WebElement addPhotoButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".caret")));
//        addPhotoButton.click();
//    }
//
//    @Test
//    public void testPhotosSorting() {
//        WebElement photosTab = driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/media/index']"));
//        photosTab.click();
//        WebElement sortingPhotoButton = wait
//                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".hidden-xs.fa.fa-arrow-down.pointer.plr5")));
//        sortingPhotoButton.click();
//    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
