import javafx.scene.paint.PhongMaterial;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class HowWeWorkTests extends BaseUI {
    @Test
    public void testGetContentPagesTitles() {
        mainPage.clickHowWeWorkTab();
        List<String> titles = howWeWorkPage.getContentPagesTitles();
        if (titles.size() == 22) {
            System.out.println("Titles number: " + titles.size() + " ." + " We have all titles for all content pages.");
        } else {
            System.out.println("We have missed some titles");
        }
        Assert.assertEquals(titles.size(), 22);
    }

    @Test
    public void testClickContentPageLinksAreClickable() {
        mainPage.clickHowWeWorkTab();
        howWeWorkPage.clickContentPageLinks();
    }
}
