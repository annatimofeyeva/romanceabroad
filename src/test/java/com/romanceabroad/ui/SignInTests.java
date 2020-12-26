package com.romanceabroad.ui;


import org.testng.annotations.Test;

public class SignInTests extends BaseUI{

    @Test(dataProvider = "SignIn", dataProviderClass = DataProviders.class)
    public void testSignInInvalidCredentials(String email, String password, boolean emailIsCorrect, boolean passwordIsCorrect) {
        mainPage.getNavigate(Data.signInUrl);
        mainPage.typeValueInTextFiled(Locators.EMAIL_TEXT_FIELD, email);
        mainPage.typeValueInTextFiled(Locators.PASSWORD_TEXT_FIELD, password);
        mainPage.clickElement(Locators.BUTTON_SIGN_IN);

        if(!emailIsCorrect) {

            System.out.println( "Email: " + email + " is not correct");

        }else if(!passwordIsCorrect) {
            System.out.println( "Password: " + " is not correct");
        }else if(!passwordIsCorrect || !emailIsCorrect) {

        }else if(!passwordIsCorrect && !emailIsCorrect) {

        }
    }
}



// two assertions

//Email is incorrect, please, try again


// Login or password is incorrect, please try again