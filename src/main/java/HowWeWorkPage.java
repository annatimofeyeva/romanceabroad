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

    public int getContentPagesNumber() {
        int size = 0;
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
        size = list.size();
        if (list.size() == 22) {
            System.out.println("Titles number: " + list.size() + " ." + "We have all titles for all content pages.");

        } else {
            System.out.println("We have missed some titles");
        }
        return size;
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

   /*  "глазами" тест проходит, но потом падает:
     org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
    https://stackoverflow.com/questions/18225997/stale-element-reference-element-is-not-attached-to-the-page-document*/

    public void clickSelectedContentPageLinks() {
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
        for (int i = 0; i < list.size(); i++) {
            String title = list.get(i).getText();
            if (title.contains(Data.contetnPageLink)) {
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
                wait.until(ExpectedConditions.elementToBeClickable(list.get(i)));
                list.get(i).click();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



