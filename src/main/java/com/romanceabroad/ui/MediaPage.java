package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MediaPage extends BaseActions {
    public MediaPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String sortingPhotosByViewsCount() {
        getNavigate(Locators.LINK_PHOTOS);
        String actualSortingValueText = getTextFromDropDownSelectedValue(Locators.LINK_DROP_DOWN, "views");
        return actualSortingValueText;
    }
}





