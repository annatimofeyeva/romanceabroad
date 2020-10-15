import org.testng.Assert;
import org.testng.annotations.Test;

public class BookNowTests extends BaseUI {
    private String currentUrlBookNow;

    @Test
    public void testBookNowTab() {
        getBookNowPage(Locators.LINK_BOOK_NOW);
        currentUrlBookNow = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlBookNow, Data.expectedUrlTours);
        driver.navigate().back();
        String mainUrl = driver.getCurrentUrl();
        Assert.assertEquals(mainUrl, Data.mainUrl);
    }
}
