package com.romanceabroad.ui;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;


public class UserProfilePage extends BaseActions {
    public UserProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void getToUserProfile() {
        getNavigate(Locators.LINK_SEARCH);
        WebElement userName = driver.findElement(Locators.USER_NAME);
        ajaxClick(userName);
    }
}
