import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HowWeWorkPage extends BaseActions {
    public HowWeWorkPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public List<String> getContentPagesTitles() {
        List<String> titles = new ArrayList<>();
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li")));
        System.out.println("List size: " + list.size());
        if (list.size() != 0) {
            for (WebElement element : list) {
                titles.add(element.getText());
            }
        } else {
            System.out.println("Sorry, - no content pages links");
        }
        System.out.println("Titles of all content pages: " + titles);
        return titles;
    }
}
