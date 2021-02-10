package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseUI {
    public static final boolean testCase11 = true;
    public static final boolean testCase12 = false;
    public static final boolean testCase13 = false;
    public static final boolean testCase14 = false;
    public static final boolean testCase15 = false;


    @Test(priority = 5, enabled = testCase11, groups = {"chrome"})
    public void testSearchWomenByNameTestCase11() {
        String value = valueOfBox;
        searchPage.clickMobileMenu(value);
        searchPage.getNavigate(Locators.LINK_SEARCH);
        String selectedTextInDropDown = searchPage.getTextFromDropDownSelectedValue(Locators.DROP_DOWN_LIST_SORT_BY, "name");
        String actualTextSelectedINDropDown = searchPage.searchWomenByName();
        Assert.assertEquals(Data.expectedTextSelectedInDropDown, actualTextSelectedINDropDown);
    }

    @Test(priority = 4, enabled = testCase12, groups = {"chrome"})
    public void testSearchWomenByAgesTestCase12() {
        String actualNumberOfWomen = searchPage.searchWomenByAges();
        Assert.assertEquals(Data.expectedSearchResultSize, actualNumberOfWomen);
    }

    @Test(priority = 3, enabled = testCase13, groups = {"user", "admin"})
    public void testRandomSearchFromDropDownTestCase13() {
        searchPage.randomSearchFromDropDown();
    }

    @Test(priority = 2, enabled = testCase13)
    public void testRandomSearchFromDropDownSecond() {
        searchPage.randomSearchFromDropDownSecond();
    }

    @Test(priority = 1, enabled = testCase14, groups = {"user", "admin"})
    public void testGetSizeDropDownListTestCase14() {
        int actualSize = searchPage.getSizeDropDownList();
        System.out.println("Size of DropDown list: " + actualSize);
        Assert.assertEquals(actualSize, Data.expectedSizeOfDropDownList);
    }

    @Test(dataProvider = "Search", dataProviderClass = DataProviders.class, priority = 6, enabled = testCase15, groups = {"user", "admin"})
    public void testSearchDifferentResultsTestCase15(String minAge, String maxAge, String sortBy) {
        int min = Integer.parseInt(minAge);
        int max = Integer.parseInt(maxAge);
        searchPage.getNavigate(Locators.LINK_SEARCH);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MIN), minAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MAX), maxAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY), sortBy);
        searchPage.javaImplicitWaitSec(3);
        searchPage.clickElement(Locators.BUTTON_SEARCH);
        List<WebElement> infoAboutUser = driver.findElements(Locators.TEXT_USER_INFO);
        System.out.println("Size of list: " + infoAboutUser.size());
        for (int i = 0; i < infoAboutUser.size(); i++) {
            if (i % 2 == 0) {
                String info = infoAboutUser.get(i).getText();
                String[] splitedPhrase = info.split(", ");
                String age = splitedPhrase[1];
                int ageNum = Integer.parseInt(age);
                if (ageNum >= min && ageNum <= max) {
                    System.out.println("This age: " + ageNum + " is correct");
                } else {
                    Assert.fail("Wrong age: " + ageNum);
                }
            }
            searchPage.javaImplicitWaitSec(3);
            infoAboutUser = driver.findElements(Locators.TEXT_USER_INFO);
        }
    }
}


