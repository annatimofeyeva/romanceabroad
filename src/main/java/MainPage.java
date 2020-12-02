import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.stream.ImageInputStream;

public class MainPage extends BaseActions {
    WebDriverWait wait;

    // Constructor
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickJoinButton() {
        driver.findElement(Locators.BUTTON_JOIN_FOR_FREE).click();
    }

    public void clickHowWeWorkTab() {
        driver.findElement(Locators.LINK_HOW_WORK).click();
    }

    public void completeFirstPartOfRegistration() {
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(Data.registrationEmail);
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
        WebElement element = driver.findElement(Locators.BUTTON_FACEBOOK_REDIRECTION);
        element.click();
    }

    public String clickTopBarTab() {
        String actualURL = clickValueOfList(Locators.LINK_ALL_TOP_BAR_TABS, "PRETTY WOMEN");
        return actualURL;
    }

    public void ajaxSendKeys() {
        getNavigate(Locators.BUTTON_JOIN_FOR_FREE);
        javaImplicitWaitSec(3);
        WebElement element = driver.findElement(Locators.TEXT_FIELD_EMAIL);
        ajaxSendKeys(element, "test@test.com");
    }

    public void checkAllLinks() {
        checkLinksOnWebPage("//a", "href");
    }

    public void verifyLinkBlogActive() {
        verifyLinkActive(Data.expectedUrlBlog);
    }

}



