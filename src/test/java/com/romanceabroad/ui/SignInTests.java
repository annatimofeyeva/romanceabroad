package com.romanceabroad.ui;


import org.testng.annotations.Test;

public class SignInTests extends BaseUI{

    @Test(dataProvider = "SignIn", dataProviderClass = DataProviders.class)
    public void testSignInInvalidCredentials(String email, String password, boolean emailIsCorrect, boolean passwordIsCorrect) {
        mainPage.getNavigate("https://romanceabroad.com/users/login_form");
        if(!emailIsCorrect) {

            System.out.println( "Email: " + " is not correct");

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