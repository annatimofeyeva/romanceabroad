import org.openqa.selenium.By;
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
        clickSpecificListValue(Locators.LINKS_TITLES_FOOTER, "Contact us");
        WebElement dropDownReasons = driver.findElement(By.xpath("//select[@name='id_reason']"));
        getDropDownListByValue(dropDownReasons, "2");
        sendKeys(Locators.TEXT_FIELD_USER_NAME_CONTACT_US, "John Smith");
        sendKeys(Locators.TEXT_FIELD_USER_EMAIL_CONTACT_US, "JohnSmith@JohnSmith.com");
        //
        // autocomplete
        //
        sendKeys(Locators.TEXT_AREA, "Test message from John Smith");
        // it's impossible to automate captcha. There exists some tools like: 2Captcha.com’s API and some more.
        // The best way  - may be ask developer to disable captcha for testing env
        //WebElement captcha = driver.findElement(By.xpath("//span//following-sibling::img"));











    }
}
