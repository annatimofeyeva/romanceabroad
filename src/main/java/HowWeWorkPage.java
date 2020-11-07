import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class HowWeWorkPage extends BaseActions {
    String url = "";
    HttpURLConnection huc = null;
    int respCode = 200;
    public HowWeWorkPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public List<String> getContentPagesTitles() {
        List<String> titles = new ArrayList<>();
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
        System.out.println("List size: " + list.size());
        if (list.size() != 0) {
            for (WebElement element : list) {
                titles.add(element.getText());
            }
        } else {
            System.out.println("Sorry, - no content pages links displayed");
        }
        System.out.println("Titles of all content pages: " + titles);
        return titles;
    }

    public void clickContentPageLinks() {
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
        for (int i = 0; i < list.size(); i++) {
            String title = list.get(i).getText();
            System.out.println(title);
            WebElement link = list.get(i);
            ajaxClick(link);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
