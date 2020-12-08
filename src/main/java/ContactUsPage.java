import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactUsPage extends BaseActions{
    public ContactUsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void completeContactForm() {
        getNavigate(Locators.LINK_SEARCH);
        scrollSmoothToBottom();
        clickSpecificListValue(Locators.LINKS_TITLES_FOOTER, Data.nameLinkContactUs);
        WebElement dropDownReasons = driver.findElement(Locators.DROP_DOWN_REASONS);
        getDropDownListByValue(dropDownReasons, Data.dropDownValueText);
        sendKeys(Locators.TEXT_FIELD_USER_NAME_CONTACT_US, Data.userNameContactUs);
        sendKeys(Locators.TEXT_FIELD_USER_EMAIL_CONTACT_US, Data.userEmailContactUs);
        sendKeys(Locators.TEXT_FIELD_SUBJECT, Data.subjectText);
        sendKeys(Locators.TEXT_AREA_MESSAGE, Data.messageText);
        // it's impossible to automate captcha. There exists some tools like: 2Captcha.com’s API and some more - not sure it's good to use it.
        // The best way  - may be ask developer to disable captcha for testing env
        //WebElement captcha = driver.findElement(By.xpath("//span//following-sibling::img"));
        clickElement(Locators.BUTTON_SUBMIT);
    }
}
