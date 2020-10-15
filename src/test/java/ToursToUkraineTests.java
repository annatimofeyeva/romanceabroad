import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToursToUkraineTests extends BaseUI {
    private String currentUrlTours;

    @Test
    public void testToutToUkraineTab() {
        getTourToUkrainePage(Locators.LINK_TOUR);
        currentUrlTours = driver.getCurrentUrl();
        String searchToursToUkraineHeader =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.HEADER_TOURS_TO_UKRAINE))
                        .getText();
        Assert.assertEquals(Data.expectedToursToUkraineTitle, searchToursToUkraineHeader);
        Assert.assertEquals(currentUrlTours, Data.expectedUrlTours);
    }
}
