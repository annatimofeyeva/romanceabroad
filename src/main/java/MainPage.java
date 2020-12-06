import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MainPage extends BaseActions {
    WebDriverWait wait;

    // Constructor
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void smokeMainPage() {
        List<WebElement> mainTabs = driver.findElements(Locators.NAVBAR_LINKS);
        for (int i = 0; i < mainTabs.size(); i++) {
            mainTabs.get(i).click();
            driver.get(Data.mainUrl);
            mainTabs = driver.findElements(Locators.NAVBAR_LINKS);
        }
    }

    public void clickJoinButton() {
        driver.findElement(Locators.BUTTON_JOIN_FOR_FREE).click();
    }

    public void clickHowWeWorkTab() {
        driver.findElement(Locators.LINK_HOW_WORK).click();
    }

    public void completeFirstPartOfRegistration() {
        // For Opera browser need to add implicit wait
        javaImplicitWaitSec(3);
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

    public void checkAllLinksAndImagesMainPage() {
        checkLinksOnWebPage("//a", "href");
        checkLinksOnWebPage("//img", "src");
    }

    public void verifyLinkBlogActive() {
        verifyLinkActive(Data.expectedUrlBlog);
    }

    // checking advanced locators
    public void advancedLocators() {

        ajaxClick(Locators.LINK_TOP);
        driver.get(Data.mainUrl);
        WebElement topLogoImage = driver.findElement(Locators.TOP_LOGO_IMAGE);
        System.out.println(topLogoImage);
        if (topLogoImage.isDisplayed()) {
            System.out.println("Logo image is displayed");
        }
        WebElement divideBar = driver.findElement(Locators.HR_DIVIDED_BAR);
        if (divideBar.isDisplayed()) {
            System.out.println("Middle page divideBar is displayed");
        }
        WebElement middlePageText =
                driver.findElement(Locators.MIDDLE_PAGE_TEXT);
        System.out.println(middlePageText.getText());
        WebElement tourButton =
                driver.findElement(Locators.BUTTON_TOUR);
        System.out.println(tourButton.getText());

        WebElement iFrame =
                driver.findElement(Locators.IFRAME);
        System.out.println("Iframe width in px: " + iFrame.getAttribute("width"));

        WebElement linkGetInTouch =
                driver.findElement(Locators.LINK_GET_IN_TOUCH);
        ajaxScroll(linkGetInTouch);
        System.out.println(linkGetInTouch.getText());

        WebElement linkSupport =
                driver.findElement(Locators.LINK_SUPPORT);
        ajaxScroll(linkSupport);
        System.out.println(linkSupport.getText());
        driver.get(Data.expectedUrlSearch);
        javaImplicitWaitSec(2);

        WebElement buttonLogin = driver.findElement(Locators.LINK_LOGIN);
        buttonLogin.click();
        javaImplicitWaitSec(2);
        WebElement loginCrossButton = driver.findElement(Locators.BUTTON_LOGIN_FORM_CLOSE);
        System.out.println(loginCrossButton);
        loginCrossButton.click();

        WebElement paginationTab2 = driver.findElement(Locators.LINK_PAGINATION_TAB2);
        paginationTab2.click();
        WebElement paginationTab1 = driver.findElement(Locators.LINK_PAGINATION_TAB1);
        paginationTab1.click();

        WebElement languageActiveForSelection = driver.findElement(Locators.LINK_LANGUAGE_ACTIVE_FOR_SELECTION);
        languageActiveForSelection.click();
        System.out.println(languageActiveForSelection.getText());

        List<WebElement> languages = driver.findElements(Locators.LINKS_FOOTER_LANGUAGES);
        for (int i = 0; i < languages.size(); i++) {
            System.out.println("Available language: " + languages.get(i).getText());
        }
        System.out.println("Amount of available languages: " + languages.size());
    }
}



