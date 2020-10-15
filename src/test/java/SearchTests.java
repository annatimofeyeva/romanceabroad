import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.Locator;

public class SearchTests extends BaseUI {
    private String currentUrlSearch;

    @Test
    public void testSearch() {
        getSearchPage(Locators.LINK_SEARCH);
        //driver.findElement(Locators.LINK_SEARCH).click();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        //Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);
    }

    @Test
    public void testDropDownListSortByUserData() {
        getSearchPage(Locators.LINK_SEARCH);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*Select select = new Select(driver.findElement(By.xpath("//div[@class='form-inline']//select")));
        select.selectByVisibleText("Name");
        select.selectByIndex(3);
        select.selectByValue("views_count"); //actual text = "Views"*/
        //getDropDownListByIndex(Locators.DROP_DOWN_LIST_SORT_BY, 3);
        //getDropDownListByText(Locators.DROP_DOWN_LIST_SORT_BY, "Name");
        WebElement dropDownListSortBy = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY);
        getDropDownListByValue(dropDownListSortBy, "views_count");
    }

    @Test
    public void testDropDownListSortByAgesMin() {
        getSearchPage(Locators.LINK_SEARCH);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement dropDownListSortBy = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MIN);
        getDropDownListByValue(dropDownListSortBy, "23");
    }

    @Test
    public void testDropDownListSortByAgesMax() {
        getSearchPage(Locators.LINK_SEARCH);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement dropDownListSortBy = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MAX);
        getDropDownListByValue(dropDownListSortBy, "50");
    }
}
