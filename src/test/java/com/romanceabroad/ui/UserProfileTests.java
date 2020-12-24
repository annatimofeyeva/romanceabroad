package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserProfileTests extends BaseUI {
    @Test
    public void testPersonalInformation() {
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

        List<String> actualTitles = new ArrayList<>();
        List<WebElement> personalInformationTitles = driver.findElements(Locators.USER_INFORMATION_TITLES);
        for(WebElement element : personalInformationTitles) {
            actualTitles.add (element.getText());
        }

        List<String> actualValues = new ArrayList<>();
        List<WebElement> personalInformation = driver.findElements(Locators.USER_INFORMATION_VALUES);
        for(WebElement element : personalInformation) {
            actualValues.add (element.getText());
        }
        String newline = System.lineSeparator();
        System.out.println(newline + "User's personal information titles: ");
        actualTitles.forEach(x -> System.out.println(x));
        System.out.println(newline + "User's personal information values: ");
        actualValues.forEach(x -> System.out.println(x));

        Assert.assertEquals(actualTitles, Data.expectedPersonalInformationTitles);
        Assert.assertEquals(actualValues, Data.expectedPersonalInformationValues);
    }







//    @Test
//    public void testProfileMenuTabs() {
//
//    }
}
