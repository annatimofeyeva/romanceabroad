import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseUI {
    private String currentUrlHowWeWork;
    private String expectedUrlHowWeWork = "https://romanceabroad.com/content/view/how-it-works";

    @Test
    public void testHowWeWorkTab() {
        driver.findElement(Locators.LINK_HOW_WORK).click();
        currentUrlHowWeWork = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlHowWeWork, expectedUrlHowWeWork);
    }
}
