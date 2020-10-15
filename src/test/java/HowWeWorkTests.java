import org.testng.Assert;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseUI {
    private String currentUrlHowWeWork;

    @Test
    public void testHowWeWorkTab() {
        getHowWeWorkPage(Locators.LINK_HOW_WORK);
        currentUrlHowWeWork = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlHowWeWork, Data.expectedUrlHowWeWork);
    }
}
