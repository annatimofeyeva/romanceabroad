package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTests extends BaseUI {
    @Test
    public void testUserProfile() {
        userProfilePage.getToUserProfile();
        WebElement profilePhoto = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[@id='user_photo']")));
        System.out.println("ProfilePhoto tag name: " + profilePhoto.getTagName());
        boolean displayedProfilePhoto = profilePhoto.isDisplayed();
        Assert.assertTrue(displayedProfilePhoto);

        String actualUserName = driver.findElement(Locators.H1_TITLE).getText();
        System.out.println("User name is: " + actualUserName);
        Assert.assertEquals(actualUserName, Data.expectedUserName);

        WebElement personalDescriptionBlock = driver.findElement(By.xpath("//div[@class='view-user__descr']"));
        System.out.println("personalDescriptionBlock class name: " + personalDescriptionBlock.getAttribute("class"));
        boolean displayedPersonalDescriptionBlock = personalDescriptionBlock.isDisplayed();
        Assert.assertTrue(displayedPersonalDescriptionBlock);







    }


}
