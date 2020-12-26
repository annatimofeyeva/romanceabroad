package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTests extends BaseUI {

    @Test(dataProvider = "SignIn", dataProviderClass = DataProviders.class)
    public void testSignInInvalidCredentials(String email, String password, boolean emailIsCorrect, boolean passwordIsCorrect) {
        String actualErrorMessage;
        WebElement errorMessage;
        mainPage.getNavigate(Data.signInUrl);
        mainPage.typeValueInTextFiled(Locators.EMAIL_TEXT_FIELD, email);
        mainPage.typeValueInTextFiled(Locators.PASSWORD_TEXT_FIELD, password);
        mainPage.clickElement(Locators.BUTTON_SIGN_IN);
        if (!emailIsCorrect) {
            errorMessage = driver.findElement(Locators.ERROR_MESSAGE);
            actualErrorMessage = errorMessage.getText();
            Assert.assertTrue(errorMessage.isDisplayed());
            Assert.assertEquals(Data.expectedEmailErrorMessage, actualErrorMessage);
            System.out.println("Email: " + email + " is invalid. " + "Error message: " + actualErrorMessage);

        } else if (!passwordIsCorrect) {
            errorMessage = driver.findElement(Locators.ERROR_MESSAGE);
            actualErrorMessage = errorMessage.getText();
            Assert.assertTrue(errorMessage.isDisplayed());
            Assert.assertEquals(Data.expectedPasswordErrorMessage, actualErrorMessage);
            System.out.println("Password: " + password + " is invalid. " + "Error message: " + actualErrorMessage);
        }
    }
}
