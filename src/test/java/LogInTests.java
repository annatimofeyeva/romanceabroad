import org.testng.Assert;
import org.testng.annotations.Test;


public class LogInTests extends BaseUI {

    @Test
    public void testLogInInvalidCredentials() {
        String actualErrorMessageText = loginPage.loginInvalidCredentials();
        System.out.println(actualErrorMessageText);
        Assert.assertEquals(actualErrorMessageText, Data.expectedErrorMessageText);
        if(actualErrorMessageText.isEmpty()) {
            Assert.fail("Invalid credentials: No error message provided to user.");
        }
//        WebElement error_popUp = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.ERROR_POP_UP));
//        String currentBackgroundColor = error_popUp.getCssValue("border-color");
//        Assert.assertEquals(currentBackgroundColor, Data.expectedBackgroundColor);
//        String errorPopUpText = error_popUp.getText();
//        Assert.assertEquals(errorPopUpText, Data.expectedLoginErrorPopUpText);
//        List<WebElement> errorPopUp =
//                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.ERROR_POP_UP));
//        Assert.assertEquals(errorPopUp.size(), 1);
//        Assert.assertTrue(errorPopUp.size() > 0);
    }
}
