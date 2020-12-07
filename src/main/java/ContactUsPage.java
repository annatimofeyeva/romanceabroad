import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BaseActions{
    public ContactUsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void completeContactForm() {
        getNavigate(Locators.LINK_SEARCH);
        scrollSmoothToBottom();
        clickSpecificListValue(Locators.LINKS_TITLES_FOOTER, "Contact us");
        javaImplicitWait(10);


    }
}
