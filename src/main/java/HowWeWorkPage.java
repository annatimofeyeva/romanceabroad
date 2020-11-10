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

    public String getSelectedContentPageLinkUrl() {
        String url = "";
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
        for (int i = 0; i < list.size(); i++) {
            WebElement element = list.get(i);
            String title = element.getText();
            if (title.contains(Data.contetnPageLinkText)) {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                list =
                        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES_AFTER_PAGE_RELOAD));
                element.click();
                url = driver.getCurrentUrl();
                //System.out.println(url);
            }
        }
        return url;
    }

    public String getSelectedFooterLink() {
        String urlSelectedFooterLink = "";
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINKS_TITLES_FOOTER));
        WebElement link = list.get(Data.FOOTER_LINKS_INDEX);
        ajaxClick(link);
        urlSelectedFooterLink = driver.getCurrentUrl();
        //System.out.println(urlSelectedFooterLink);
        return urlSelectedFooterLink;
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

    public int getNumberOfContentPages() {
        int size = 0;
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
        size = list.size();
        if (list.size() == 22) {
            System.out.println("Pages number: " + list.size() + " ." + "We have all content pages.");

        } else {
            System.out.println("We have missed some pages");
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

    public List<String> checkAllFooterLinks() {
        List<String> footerLinksUrls = new ArrayList<>();
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINKS_TITLES_FOOTER));
        // i < list.size() -1   because last array element is not displaying on the footer. it's <span>...<iframe> ..text()="Mobile"
        for (int i = 0; i < list.size() - 1; i++) {
            list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINKS_TITLES_FOOTER));
            ajaxClick(list.get(i));
            footerLinksUrls.add(driver.getCurrentUrl());
            //System.out.println(footerLinksUrls);
        }
        return footerLinksUrls;
    }

    public void clickOnContentPagesTitles() {
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
        for (int i = 0; i < list.size(); i++) {
           /* resolving  StaleElementReferenceException;
            OpenQA.Selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document*/
            list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
            list.get(i).click();
        }
    }
}




