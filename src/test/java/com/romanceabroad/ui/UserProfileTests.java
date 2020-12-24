package com.romanceabroad.ui;

import org.openqa.selenium.By;
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
        for (WebElement element : personalInformationTitles) {
            actualTitles.add(element.getText());
        }

        List<String> actualValues = new ArrayList<>();
        List<WebElement> personalInformation = driver.findElements(Locators.USER_INFORMATION_VALUES);
        for (WebElement element : personalInformation) {
            actualValues.add(element.getText());
        }
        String newline = System.lineSeparator();
        System.out.println(newline + "User's personal information titles: ");
        actualTitles.forEach(x -> System.out.println(x));
        System.out.println(newline + "User's personal information values: ");
        actualValues.forEach(x -> System.out.println(x));

        Assert.assertEquals(actualTitles, Data.expectedPersonalInformationTitles);
        Assert.assertEquals(actualValues, Data.expectedPersonalInformationValues);
    }

    @Test
    public void testProfileMenuTabs() {
        String actualPostDay;
        String actualPhotosNumber;
        userProfilePage.getToUserProfile();
        List<WebElement> menuTabs =
                driver.findElements(By.xpath("//div[@class='profile-menu clearfix']//ul//li"));
        for (int i = 0; i < menuTabs.size(); i++) {
            menuTabs.get(i).click();
            menuTabs =
                    driver.findElements(By.xpath("//div[@class='profile-menu clearfix']//ul//li"));
            String tabText = menuTabs.get(i).getText();
            if (tabText.contains("Wall")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='wall-post-date']")));
                actualPostDay = driver.findElement(By.xpath("//span[@class='wall-post-date']")).getText();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'has uploaded new photos     (1)')]")));
                actualPhotosNumber = driver.findElement(By.xpath("//div[contains(text(),'has uploaded new photos     (1)')]")).getText();
                System.out.println("Date of upload: " + actualPostDay);
                System.out.println("Number of photos: " + actualPhotosNumber);
                String photoNumber = String.valueOf(actualPhotosNumber.charAt(actualPhotosNumber.length() - 2));
                System.out.println("String actual photos number: " + photoNumber);
                int actualPhotoNumber = Integer.parseInt(photoNumber);
                System.out.println("Actual photos number (integer): " + actualPhotoNumber);
                Assert.assertEquals(actualPostDay, Data.expectedPostDay);
                Assert.assertEquals(actualPhotoNumber, Data.expectedPhotoNumber);
            }
            if (tabText.contains("Gallery")) {
                WebElement galleryFilters = driver.findElement(By.xpath("//ul[@id='filters']"));
                Assert.assertTrue(galleryFilters.isDisplayed());
                mainPage.getDropDownListByValue(By.xpath("//select[@class='form-control']"), "views");
                WebElement viewCount = driver.findElement(By.xpath("//span[@class='view_num'][text()='47']"));
                int maxViewsCountNumber = Integer.parseInt(viewCount.getText());
                System.out.println("Max number of views: " + maxViewsCountNumber);
                Assert.assertEquals(maxViewsCountNumber, Data.expectedMaxViewsCountNumber);











            }


        }
    }
}