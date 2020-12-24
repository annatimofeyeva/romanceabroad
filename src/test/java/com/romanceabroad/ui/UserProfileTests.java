package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserProfileTests extends BaseUI {
    @Test
    public void testUserDescriptionBlock() {
        userProfilePage.getToUserProfile();
        WebElement profilePhoto = wait.until(ExpectedConditions
                .elementToBeClickable(Locators.USER_PROFILE_PHOTO));
        System.out.println("ProfilePhoto tag name: " + profilePhoto.getTagName());
        boolean displayedProfilePhoto = profilePhoto.isDisplayed();
        Assert.assertTrue(displayedProfilePhoto);

        String actualUserName = driver.findElement(Locators.H1_TITLE).getText();
        System.out.println("User name is: " + actualUserName);
        Assert.assertEquals(actualUserName, Data.expectedUserName);

        WebElement userDescriptionBlock = driver.findElement(Locators.USER_DESCRIPTION);
        System.out.println("User Description Block class name: " + userDescriptionBlock.getAttribute("class"));
        boolean displayedPersonalDescriptionBlock = userDescriptionBlock.isDisplayed();
        Assert.assertTrue(displayedPersonalDescriptionBlock);

        List<String> titlesOfPersonalInformation = new ArrayList<>();
        List<WebElement> personalInformationTitles = driver.findElements(Locators.USER_INFORMATION_TITLES);
        for(WebElement element : personalInformationTitles) {
            titlesOfPersonalInformation.add (element.getText());
        }

        List<String> personalInformationValues = new ArrayList<>();
        List<WebElement> personalInformation = driver.findElements(Locators.USER_INFORMATION_VALUES);
        for(WebElement element : personalInformation) {
            personalInformationValues.add (element.getText());
        }
        String newline = System.lineSeparator();
        System.out.println(newline + "User's personal information titles: ");
        titlesOfPersonalInformation.forEach(x -> System.out.println(x));
        System.out.println(newline + "User's personal information values: ");
        personalInformationValues.forEach(x -> System.out.println(x));









    }







//    @Test
//    public void testProfileMenuTabs() {
//
//    }
}
