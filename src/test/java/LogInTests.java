import com.romanceabroad.ui.Algos.Data;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogInTests extends BaseUI {

    @Test
    public void testLogInInvalidCredentials() {
        String actualErrorMessageText = loginPage.loginInvalidCredentials();
        Assert.assertEquals(actualErrorMessageText, Data.expectedErrorMessageText);
        if(actualErrorMessageText.isEmpty()) {
            Assert.fail("Invalid credentials: No error message provided to user.");
        }
//        WebElement error_popUp = wait.until(ExpectedConditions.presenceOfElementLocated(com.romanceabroad.ui.Algos.Locators.ERROR_POP_UP));
//        String currentBackgroundColor = error_popUp.getCssValue("border-color");
//        Assert.assertEquals(currentBackgroundColor, com.romanceabroad.ui.Algos.Data.expectedBackgroundColor);
//        String errorPopUpText = error_popUp.getText();
//        Assert.assertEquals(errorPopUpText, com.romanceabroad.ui.Algos.Data.expectedLoginErrorPopUpText);
//        List<WebElement> errorPopUp =
//                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(com.romanceabroad.ui.Algos.Locators.ERROR_POP_UP));
//        Assert.assertEquals(errorPopUp.size(), 1);
//        Assert.assertTrue(errorPopUp.size() > 0);
    }
}
