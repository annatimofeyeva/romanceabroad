import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookNowTests extends BaseUI {
    private String currentUrlBookNow;
    private String expectedUrlTours = "https://romanceabroad.com/store/sweets/20-tour_to_ukraine";
    private By LINK_BOOK_NOW = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']");

    @Test
    public void testBookNowTab() {
        driver.findElement(LINK_BOOK_NOW).click();
        currentUrlBookNow = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlBookNow, expectedUrlTours);
    }
}
