package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTests extends BaseUI {
    public static final boolean testCase11 = true;
    public static final boolean testCase12 = true;
    public static final boolean testCase13 = true;
    public static final boolean testCase14 = true;
    public static final boolean testCase15 = true;

    @Test(priority = 5, enabled = testCase11, groups = {"chrome"})
    public void testSearchWomenByNameTestCase11() {
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
    public void testSearchDifferentResultsTestCase15(String minAge, String maxAge, String sortBy ) {
        searchPage.getNavigate(Locators.LINK_SEARCH);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MIN), minAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MAX), maxAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY), sortBy);
        searchPage.clickElement(Locators.BUTTON_SEARCH);




    }
}


