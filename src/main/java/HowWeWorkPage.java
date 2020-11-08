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
//            wait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
            //org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
        }
    }

    public List<String> getFooterLinkTitles() {
        List<String> footerTitles = new ArrayList<>();
        List<WebElement> helpFooterLinks =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINKS_TITLES_FOOTER));
        for (WebElement element : helpFooterLinks) {
            footerTitles.add(element.getText());
        }
        System.out.println(footerTitles);
        for (int i = 0; i < footerTitles.size(); i++) {
            System.out.println("Title of Footers link: " + footerTitles.get(i));
        }
        return footerTitles;
    }
}


