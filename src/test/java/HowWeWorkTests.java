import org.testng.Assert;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseUI {
    private String currentUrlHowWeWork;

    @Test
    public void testHowWeWorkTab() {
        driver.findElement(Locators.LINK_HOW_WORK).click();
        currentUrlHowWeWork = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlHowWeWork, Data.expectedUrlHowWeWork);
    }
}
