import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToursToUkraineTests extends BaseUI {
    private String currentUrlTours;
    private String expectedUrlTours = "https://romanceabroad.com/store/sweets/20-tour_to_ukraine";
    private String expectedToursToUkraineTitle = "TOURS TO UKRAINE";

    @Test
    public void testToutToUkraineTab() {
        driver.findElement(Locators.LINK_TOUR).click();
        currentUrlTours = driver.getCurrentUrl();
        String searchToursToUkraineHeader =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.HEADER_TOURS_TO_UKRAIN))
                        .getText();
        Assert.assertEquals(expectedToursToUkraineTitle, searchToursToUkraineHeader);
        Assert.assertEquals(currentUrlTours, expectedUrlTours);
    }
}
