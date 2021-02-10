package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BaseActions {
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String searchWomenByName() {
        //Click on menu hamburger (for mobile optimization):
        //getNavigate(Locators.LINK_SEARCH_MOBILE);
        getNavigate(Locators.LINK_SEARCH);
        String selectedTextInDropDown = getTextFromDropDownSelectedValue(Locators.DROP_DOWN_LIST_SORT_BY, "name");
        return selectedTextInDropDown;
    }

    public String searchWomenByAges() {
        getNavigate(Locators.LINK_SEARCH);
        getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MAX, "40");
        getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MIN, "20");
        driver.findElement(Locators.BUTTON_SEARCH).click();
        String numberOfWomens = driver.findElement(Locators.SEARCH_RESULT).getText();
        System.out.println(numberOfWomens);
        return numberOfWomens;
    }

    public void randomSearchFromDropDown() {
        getNavigate(Locators.LINK_SEARCH);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.DROP_DOWN_LIST_SORT_BY));
        selectItemDropDownRandomOption(Locators.DROP_DOWN_LIST_SORT_BY, "SearchByValue");
    }

    public void randomSearchFromDropDownSecond() {
        getNavigate(Locators.LINK_SEARCH);       ;
        wait.until(ExpectedConditions.elementToBeClickable(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MIN));
        int dropDownListSize = getSizeDropDownList(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MIN);
        System.out.println("DropDownList size: " + dropDownListSize);
        for (int i = 0; i < dropDownListSize; i++) {
            selectItemDropDownRandomOption(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MIN, "SearchByValue");
        }
    }

    public int getSizeDropDownList() {
        getNavigate(Locators.LINK_SEARCH);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.DROP_DOWN_LIST_SORT_BY));
        return getSizeDropDownList(Locators.DROP_DOWN_LIST_SORT_BY);
    }

    public void clickMobileMenu(String valueOfBox) {
        if (valueOfBox.contains("mobile")) {
           getNavigate(Locators.LINK_SEARCH_MOBILE);
        }
    }
}
