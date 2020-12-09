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

    public void completeFirstPartOfRegistration(String email, String password) {
        // For Opera browser needs to add implicit wait
        javaImplicitWaitSec(3);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);
        driver.findElement(Locators.BUTTON_NEXT).click();
    }

    public void completeSecondPartOfRegistration(String name, String month, String day, String year, String userPhone, String city, String location) {
        driver.findElement(Locators.TEXT_FIELD_USER_NAME).sendKeys(name);
        driver.findElement(Locators.DROP_DOWN_DATE_FIELD).click();
        clickListValue(Locators.DROP_DOWN_DATE_SELECTED, day);
        driver.findElement(Locators.DROP_DOWN_MONTH_FIELD).click();
        clickListValue(Locators.DROP_DOWN_MONTH_SELECTED, month);
        driver.findElement(Locators.DROP_DOWN_YEAR_FIELD).click();
        clickListValue(Locators.DROP_DOWN_YEAR_SELECTED, year);
        driver.findElement(Locators.TEXT_FIELD_USER_PHONE).sendKeys(userPhone);
        driver.findElement(Locators.AUTOFILE_FORM).clear();
        driver.findElement(Locators.AUTOFILE_FORM).sendKeys(city);
        List<WebElement> locations = driver.findElements(Locators.LIST_VALUE_LOCATION);
        System.out.println(locations.size());
        clickListValue(Locators.LIST_VALUE_LOCATION, location);
        WebElement checkboxConformation = driver.findElement(Locators.CHECK_BOX_CONFIRMATION);
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

        WebElement westWebArt = driver.findElement(Locators.LINK_WEST_WEB_ART);
        ajaxScroll(westWebArt);
        System.out.println(westWebArt.getText());

        WebElement presents = driver.findElement(Locators.LINK_PRESENTS);
        ajaxClick(presents);
        driver.get(Data.expectedUrlSearch);

        WebElement sortingArrow = driver.findElement(Locators.SORTING_ARROW);
        sortingArrow.click();

        driver.get(Data.expectedUrlSearch);
        WebElement pageName = driver.findElement(Locators.CURRENT_PAGE_NAME);
        System.out.println(pageName.getText());

        WebElement pageNumber = driver.findElement(Locators.CURRENT_PAGE_NUMBER);
        System.out.println(pageNumber.getText());

        WebElement miniLogo = driver.findElement(By.xpath("//a//img[@src='/application/views/flatty/logo/mini_logo.png']"));
        System.out.println(miniLogo);
    }
}



