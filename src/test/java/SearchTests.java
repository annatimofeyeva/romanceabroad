import org.testng.annotations.Test;

public class SearchTests extends BaseUI {

    @Test
    public void testDropDownListSortByAgeMax() {
        searchPage.clickSearchButton();
        searchPage.getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MAX, "40");
    }

    @Test
    public void testDropDownListSortByAgeMin() {
        searchPage.clickSearchButton();
        searchPage.getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MIN, "40");
    }

    @Test
    public void dropDownListSortByUserData() {
        searchPage.clickSearchButton();
        searchPage.getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY, "views_count");
    }
}
