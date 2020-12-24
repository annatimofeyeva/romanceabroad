package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage extends BaseActions{
    public UserProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void getToUserProfile() {
        driver.get(Data.userProfileUrl);
    }



}
