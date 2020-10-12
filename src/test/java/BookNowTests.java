import org.testng.Assert;
import org.testng.annotations.Test;

public class BookNowTests extends BaseUI {
    private String currentUrlBookNow;

    @Test
    public void testBookNowTab() {
        driver.findElement(Locators.LINK_BOOK_NOW).click();
        currentUrlBookNow = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlBookNow, Data.expectedUrlTours);
    }
}
