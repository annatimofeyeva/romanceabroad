import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class HowWeWorkTests extends BaseUI {
    @Test
    public void testGetContentPagesTitles() {
        mainPage.clickHowWeWorkTab();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']")));

        List<String> titles = howWeWorkPage.getContentPagesTitles();
        if (titles.size() == 22) {
            System.out.println("Titles number: " + titles.size() + " ." + " We have all titles for all content pages.");
        } else {
            System.out.println("We have missed some titles");
        }
    }
}
