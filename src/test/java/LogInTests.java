import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LogInTests extends BaseUI {
    private String expectedLoginErrorPopUpText = "Login or password are incorrect, please try again";
    private String expectedBackgroundColor = "rgb(235, 204, 209)";
    private By LINK_SIGH_IN = By.cssSelector("#ajax_login_link");
    private By EMAIL_TEXT_FIELD = By.xpath(" //input[@name='email']");
    private By PASSWORD_TEXT_FIELD = By.xpath(" //input[@name='password']");
    private By BUTTON_SIGN_IN = By.xpath("//button[@name='logbtn']");
    private By ERROR_POP_UP = By.xpath("//div[@class='error alert-danger alert-warning_pop_']");

    @Test
    public void testLogInInvalidCredentials() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LINK_SIGH_IN)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(EMAIL_TEXT_FIELD))
                .sendKeys("test@test.com");
        driver.findElement(PASSWORD_TEXT_FIELD)
                .sendKeys("123456");
        driver.findElement(BUTTON_SIGN_IN).click();
        WebElement error_popUp = wait.until(ExpectedConditions.presenceOfElementLocated(ERROR_POP_UP));
        String currentBackgroundColor = error_popUp.getCssValue("border-color");
        Assert.assertEquals(currentBackgroundColor, expectedBackgroundColor);
        String errorPopUpText = error_popUp.getText();
        Assert.assertEquals(errorPopUpText, expectedLoginErrorPopUpText);
        List<WebElement> errorPopUp =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ERROR_POP_UP));
        Assert.assertEquals(errorPopUp.size(), 1);
        Assert.assertTrue(errorPopUp.size() > 0);
    }
}
