import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage extends BaseActions {
    // Constructor
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickBookNowTab() {
        driver.findElement(Locators.LINK_BOOK_NOW).click();
        String currentUrlBookNow = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlBookNow, Data.expectedUrlTours);
        driver.navigate().back();
        String mainUrl = driver.getCurrentUrl();
        Assert.assertEquals(mainUrl, Data.mainUrl);
    }

    public void clickTourToUkraineTab() {
        driver.findElement(Locators.LINK_TOUR).click();
        String currentUrlTours = driver.getCurrentUrl();
        String searchToursToUkraineHeader =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.HEADER_TOURS_TO_UKRAINE))
                        .getText();
        Assert.assertEquals(Data.expectedToursToUkraineTitle, searchToursToUkraineHeader);
        Assert.assertEquals(currentUrlTours, Data.expectedUrlTours);
    }

    public void clickGiftsTab() {
        driver.findElement(Locators.LINK_GIFTS).click();
        String currentUrlGifts = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlGifts, Data.expectedUrlGifts);
    }

    public void clickMediaTab() {
        driver.findElement(Locators.LINK_PHOTOS).click();
        String currentUrlPhotos = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlPhotos, Data.expectedUrlPhotos);
    }

    public void clickHowWeWorkTab() {
        driver.findElement(Locators.LINK_HOW_WORK).click();
        String currentUrlHowWeWork = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlHowWeWork, Data.expectedUrlHowWeWork);
    }

    public void clickSearchTab() {
        driver.findElement(Locators.LINK_SEARCH).click();
        String currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);
    }

    public void clickBlogTab() {
        driver.findElement(Locators.LINK_BLOG).click();
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

    public void clickSignInTab() {
        driver.findElement(Locators.LINK_SIGH_IN).click();
        //Assertion
    }

    public void clickJoinButton() {
        driver.findElement(Locators.BUTTON_JOIN_FOR_FREE).click();
        //Assertion
    }

    public void completeFirstPartOfRegistration() {
        WebElement emailField =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TEXT_FIELD_EMAIL));
        emailField.sendKeys(Data.registrationEmail);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(Data.registrationPassword);
        driver.findElement(Locators.BUTTON_NEXT).click();
    }

    public void completeSecondPartOfRegistration() {
        driver.findElement(Locators.TEXT_FIELD_USER_NAME).sendKeys(generateUniqueUserName(Data.UserName, 2));
        driver.findElement(Locators.DROP_DOWN_DATE_FIELD).click();
        driver.findElement(Locators.DROP_DOWN_DATE_SELECTED).click();
        driver.findElement(Locators.DROP_DOWN_MONTH_FIELD).click();
        driver.findElement(Locators.DROP_DOWN_MONTH_SELECTED).click();
        driver.findElement(Locators.DROP_DOWN_YEAR_FIELD).click();
        driver.findElement(Locators.DROP_DOWN_YEAR_SELECTED).click();
        driver.findElement(Locators.TEXT_FIELD_USER_PHONE).sendKeys(Data.UserPhone);
        driver.findElement(Locators.TEXT_FIELD_USER_LOCATION).sendKeys(Data.UserLocation);
        WebElement checkboxConformation = driver.findElement(Locators.CHECK_BOX_CONFIRMATION);
        boolean selectedcheckbox = checkboxConformation.isSelected();
        System.out.println("State of the checkbox: " + selectedcheckbox);
        checkboxConformation.click();
    }

    public void clickYouTubeVideoButton() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,550)", "");
        WebElement youTubeFrame = driver.findElement(Locators.IFRAME_YOUTUBE_VIDEO);
        driver.switchTo().frame(youTubeFrame);
        WebElement playButton = driver.findElement(Locators.BUTTON_PLAY_YOUTUBE);
        playButton.click();
    }

    public void clickRequestTourButton() {
        WebElement requestTourButton = driver.findElement(Locators.BUTTON_REQUEST_TOUR_INFO);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        requestTourButton.click();
    }

    public void clickFacebookRedirectionButton() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_FACEBOOK_REDIRECTION));
                element.click();
        String facebookIntegrationURL = driver.getCurrentUrl();
        System.out.println(facebookIntegrationURL);
//        Assert.assertEquals(Data.expectedUrlFacebookIntegration, facebookIntegrationURL);
    }
}


