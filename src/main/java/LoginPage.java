import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseActions {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void loginInvalidCredentials() {
        driver.findElement(Locators.LINK_SIGH_IN).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.EMAIL_TEXT_FIELD))
                .sendKeys(Data.Email);
        driver.findElement(Locators.PASSWORD_TEXT_FIELD)
                .sendKeys(Data.Password);
        driver.findElement(Locators.BUTTON_SIGN_IN).click();
    }
}
