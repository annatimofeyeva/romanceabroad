package com.romanceabroad.ui;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(VideoListener.class)

    public class RegistrationTests extends BaseUI {


    @Test(dataProvider = "Registration", dataProviderClass = DataProviders.class)
    public void testRegistration(String email, String password, String day, String month, String year, String phone, String city, String location) {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, password);
        mainPage.completeSecondPartOfRegistration(mainPage.generateUniqueUserName(Data.userName, 5), month, day, phone, year, city, location);
    }

    //@Video(name="Registration test")
    @Test(dataProvider = "Registration2", dataProviderClass = DataProviders.class)
    public void testRegistration2(String email, String nickName, boolean isEmailCorrect) {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, Data.password);
        if (!isEmailCorrect) {
            Reports.log("Error: email is not correct");
            WebElement element = driver.findElement(Locators.TOOLTIP_ERROR);
            Assert.assertTrue(element.isDisplayed());
            System.out.println("Email is not correct");
        } else {
            mainPage.completeSecondPartOfRegistration(nickName, Data.month, Data.day, Data.phone, Data.year,
                    Data.city, Data.location);
        }
    }
}


