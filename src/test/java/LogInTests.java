import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LogInTests extends BaseUI {
    private String expectedLoginErrorPopUpText = "Login or password are incorrect, please try again";
    private String expectedBackgroundColor = "rgb(235, 204, 209)";

    @Test
    public void testLogInInvalidCredentials() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.LINK_SIGH_IN)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.EMAIL_TEXT_FIELD))
                .sendKeys("test@test.com");
        driver.findElement(Locators.PASSWORD_TEXT_FIELD)
                .sendKeys("123456");
        driver.findElement(Locators.BUTTON_SIGN_IN).click();
        WebElement error_popUp = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.ERROR_POP_UP));
        String currentBackgroundColor = error_popUp.getCssValue("border-color");
        Assert.assertEquals(currentBackgroundColor, expectedBackgroundColor);
        String errorPopUpText = error_popUp.getText();
        Assert.assertEquals(errorPopUpText, expectedLoginErrorPopUpText);
        List<WebElement> errorPopUp =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.ERROR_POP_UP));
        Assert.assertEquals(errorPopUp.size(), 1);
        Assert.assertTrue(errorPopUp.size() > 0);
    }
}
