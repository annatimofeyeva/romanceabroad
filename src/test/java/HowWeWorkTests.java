import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseUI {
    private String currentUrlHowWeWork;
    private String expectedUrlHowWeWork = "https://romanceabroad.com/content/view/how-it-works";
    private By LINK_HOW_WORK = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");

    @Test
    public void testHowWeWorkTab() {
        driver.findElement(LINK_HOW_WORK).click();
        currentUrlHowWeWork = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlHowWeWork, expectedUrlHowWeWork);
    }
}
