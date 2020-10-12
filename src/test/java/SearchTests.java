import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseUI {
    private String currentUrlSearch;
    private String expectedUrlSearch = "https://romanceabroad.com/users/search";

    @Test
    public void testSearch() {
        driver.findElement(Locators.LINK_SEARCH).click();
        currentUrlSearch = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlSearch, expectedUrlSearch);
    }

    @Test
    public void testSearchMaxAgeDropDown() {
        driver.findElement(Locators.LINK_SEARCH).click();
        WebElement ageDropDown =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.AGE_DROP_DOWN));
        ageDropDown.click();
    }
}
