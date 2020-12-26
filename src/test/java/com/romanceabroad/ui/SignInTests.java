package com.romanceabroad.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTests extends BaseUI {

    @Test(dataProvider = "SignIn", dataProviderClass = DataProviders.class)
    public void testSignInInvalidCredentials(String email, String password, boolean emailIsCorrect, boolean passwordIsCorrect) {
        mainPage.getNavigate(Data.signInUrl);
        mainPage.typeValueInTextFiled(Locators.EMAIL_TEXT_FIELD, email);
        mainPage.typeValueInTextFiled(Locators.PASSWORD_TEXT_FIELD, password);
        mainPage.clickElement(Locators.BUTTON_SIGN_IN);
        if (!emailIsCorrect) {
            WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error alert-danger alert-warning_pop_']"));
            String actualErrorMessage = errorMessage.getText();
            Assert.assertTrue(errorMessage.isDisplayed());
            Assert.assertEquals(Data.expectedErrorMessage, actualErrorMessage);
            System.out.println("Email: " + email + " is not correct. " + "Error message: " + actualErrorMessage);

        } else if (!passwordIsCorrect) {
            WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error alert-danger alert-warning_pop_']"));
            String actualErrorMessage = errorMessage.getText();
            Assert.assertTrue(errorMessage.isDisplayed());
            System.out.println("Password: " + password + " is not correct. " + "Error message: " + actualErrorMessage);
        } else if (!passwordIsCorrect || !emailIsCorrect) {

        } else if (!passwordIsCorrect && !emailIsCorrect) {

        }
    }
}
