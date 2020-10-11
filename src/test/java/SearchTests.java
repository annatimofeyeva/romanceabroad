import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseUI {
    private String currentUrlSearch;
    private String expectedUrlSearch = "https://romanceabroad.com/users/search";
    private By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    private By AGE_DROP_DOWN = By.cssSelector("#age_max");

    @Test
    public void testSearch() {
        driver.findElement(LINK_SEARCH).click();
        currentUrlSearch = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlSearch, expectedUrlSearch);
    }

    @Test
    public void testSearchMaxAgeDropDown() {
        driver.findElement(LINK_SEARCH).click();
        WebElement ageDropDown =
                wait.until(ExpectedConditions.presenceOfElementLocated(AGE_DROP_DOWN));
        ageDropDown.click();
    }
}
