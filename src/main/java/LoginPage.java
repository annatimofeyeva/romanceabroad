import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseActions {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String loginInvalidCredentials() {
        getNavigate(Locators.LINK_SIGH_IN);
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.EMAIL_TEXT_FIELD))
                .sendKeys(Data.Email);
        driver.findElement(Locators.PASSWORD_TEXT_FIELD)
                .sendKeys(Data.Password);
        driver.findElement(Locators.BUTTON_SIGN_IN).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.ERROR_POP_UP));
        WebElement error_popUp = driver.findElement(Locators.ERROR_POP_UP);
        String errorMessageText = error_popUp.getText();
        return errorMessageText;
    }
}
