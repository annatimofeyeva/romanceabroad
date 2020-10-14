//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseUI {
//    private String expectedUrlHome = "https://romanceabroad.com/#";
//    private By LINK_HOME = By.xpath("//a[@href='#']");
//    private By BUTTON_REQUEST_TOUR = By.xpath("//a[@class='btn btn-primary btn-xl js-scroll-trigger']");
//    private By BUTTON_PLAY_YOUTUBE = By.xpath("//button[@aria-label='Play']");
//    private By IFRAME = By.xpath("//iframe[contains(@src, 'https://www.youtube.com/embed/RRECuJzm3IY?start=85')]");
//    private By BUTTON_FACEBOOK_REDIRACTION = By.xpath("//img[@src='/img/facebook-ico.jpg']");
//    private By BUTTON_YouTube_REDIRACTION = By.xpath("//a[@href='https://www.youtube.com/channel/UCCmXAG1ToSyHymqYzzJcTfQ']");
//    private int indexValueForYouTubeVideoElement = 0;

    @Test
    public void testRegistration() {
        driver.findElement(Locators.BUTTON_JOIN_FOR_FREE).click();
        WebElement emailField =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TEXT_FIELD_EMAIL));
        emailField.sendKeys(Data.registrationEmail);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(Data.registrationPassword);
        driver.findElement(Locators.BUTTON_NEXT).click();
        driver.findElement(Locators.TEXT_FIELD_USER_NAME).click();
        driver.findElement(Locators.TEXT_FIELD_USER_PHONE).sendKeys(Data.UserPhone);
        driver.findElement(Locators.TEXT_FIELD_USER_LOCATION).sendKeys(Data.UserLocation);
        driver.findElement(Locators.CHECK_BOX_CONFIRMATION).click();
    }
//
//    @Test
//    public void testHomeTab() {
//        driver.findElement(LINK_HOME).click();
//        currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals(currentUrl, expectedUrlHome);
//    }
//
//    // ? How to assert file downloading
//    // https://www.seleniumeasy.com/selenium-tutorials/verify-file-after-downloading-using-webdriver-java
//    @Test
//    public void testRequestTourButton() {
//        WebElement requestTourButton = driver.findElement(BUTTON_REQUEST_TOUR);
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        requestTourButton.click();
//    }
//
//    // How to assert video playing, how to stop/ replay video in IFrame??
//    @Test
//    public void testYouTubeVideo() {
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,550)", "");
//        WebElement required_frame = driver.findElement(IFRAME);
//        driver.switchTo().frame(required_frame);
//        WebElement playButton = driver.findElement(BUTTON_PLAY_YOUTUBE);
//        playButton.click();
//    }
//
//    @Test
//    public void testFacebookRedirectionButton() {
//        WebElement facebookButton = driver.findElement(BUTTON_FACEBOOK_REDIRACTION);
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        facebookButton.click();
//    }
//
//    @Test
//    public void testYouTubeRedirectionButton() {
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        driver.findElements(BUTTON_YouTube_REDIRACTION).get(indexValueForYouTubeVideoElement).click();
//    }
}