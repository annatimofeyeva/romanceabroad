import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseUI {

    @Test
    public void testDropDownListSortByUserData() {
        mainPage.clickSearchTab();
        searchPage.getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY, "views_count");
    }

    @Test
    public void testSearchWomen() {
        mainPage.clickSearchTab();
        Assert.assertEquals("People found: 71", searchPage.searchWomenResults());
    }
}


