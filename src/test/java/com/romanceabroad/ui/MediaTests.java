package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MediaTests extends BaseUI {
    String actualTitle;

    @Test
    public void testSortingPhotosByViewsCount() {
        String actualSortingValueText = mediaPage.sortingPhotosByViewsCount();
        Assert.assertEquals(actualSortingValueText, Data.expectedSortingValueText);
    }

    @Test
    public void testUserTabs() {
        mediaPage.getNavigate(Locators.LINK_PHOTOS);
        List<WebElement> userTabs = driver.findElements(Locators.LINK_PHOTOS_ALL);
        actualTitle = mediaPage.getAnyTitle(Locators.H1_TITLE);
        Assert.assertEquals(actualTitle, Data.expectedTitleAllPhotos);
        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            actualTitle = mediaPage.getAnyTitle(Locators.H1_TITLE);
/*
            if (actualTitle.contains(Data.expectedTitleGallery) || actualTitle.contains(Data.expectedTitlePhotoGallery)
                    || actualTitle.contains(Data.expectedTitleVideoGallery) || actualTitle.contains(Data.expectedTitleAlbumsGallery)) {
                System.out.println("Title is valid: " + actualTitle);
            }
            } else {
                Assert.fail("Title is not valid");
            }
*/
            if (i == 0) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGallery);
            } else if (i == 1) {
                Assert.assertEquals(actualTitle, Data.expectedTitlePhotoGallery);
            } else if (i == 2) {
                Assert.assertEquals(actualTitle, Data.expectedTitleVideoGallery);
                WebElement textElement = wait.until(ExpectedConditions.elementToBeClickable
                        (Locators.TEXT_NO_MEDIA));
                String textMedia = textElement.getText();
                System.out.println(textMedia);
            } else if (i == 3) {
                Assert.assertEquals(actualTitle, Data.expectedTitleAlbumsGallery);
                WebElement portraitElement = wait.until(ExpectedConditions.elementToBeClickable
                        (Locators.PORTRET_ELEMENT));
                boolean displayedPortraitElement = portraitElement.isDisplayed();
                String actualPortraitElementTitle = portraitElement.getText();
                System.out.println(actualPortraitElementTitle);
                Assert.assertTrue(displayedPortraitElement);
                Assert.assertEquals(actualPortraitElementTitle, Data.expectedPortraitElementTitle);
            }
            userTabs = driver.findElements(Locators.LINK_PHOTOS_ALL);
        }
    }
}

