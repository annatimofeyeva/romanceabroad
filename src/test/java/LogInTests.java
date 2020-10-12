import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LogInTests extends BaseUI {
    @Test
    public void testLogInInvalidCredentials() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.LINK_SIGH_IN)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.EMAIL_TEXT_FIELD))
                .sendKeys(Data.Email);
        driver.findElement(Locators.PASSWORD_TEXT_FIELD)
                .sendKeys(Data.Password);
        driver.findElement(Locators.BUTTON_SIGN_IN).click();
        WebElement error_popUp = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.ERROR_POP_UP));
        String currentBackgroundColor = error_popUp.getCssValue("border-color");
        Assert.assertEquals(currentBackgroundColor, Data.expectedBackgroundColor);
        String errorPopUpText = error_popUp.getText();
        Assert.assertEquals(errorPopUpText, Data.expectedLoginErrorPopUpText);
        List<WebElement> errorPopUp =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.ERROR_POP_UP));
        Assert.assertEquals(errorPopUp.size(), 1);
        Assert.assertTrue(errorPopUp.size() > 0);
    }
}
