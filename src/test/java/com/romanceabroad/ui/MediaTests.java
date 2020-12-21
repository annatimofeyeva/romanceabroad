package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
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
            if (i == 0) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGallery);
            } else if (i == 1) {
                Assert.assertEquals(actualTitle, Data.expectedTitlePhotoGallery);
            } else if (i == 2) {
                Assert.assertEquals(actualTitle, Data.expectedTitleVideoGallery);
            } else if (i == 3) {
                Assert.assertEquals(actualTitle, Data.expectedTitleAlbumsGallery);
            }
            userTabs = driver.findElements(Locators.LINK_PHOTOS_ALL);
        }
    }
}

