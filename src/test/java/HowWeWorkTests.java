import org.testng.Assert;
import org.testng.annotations.Test;
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

    @Test
    public void testClickContentPageLink() {
        mainPage.clickHowWeWorkTab();
        howWeWorkPage.clickValueOfList(Locators.LINK_CONTENT_PAGE_TITLES, "Terms of use");
    }

    @Test
    public void testCheckFooterLinkTitles() {
        mainPage.clickHowWeWorkTab();
        Data.expectedFooterTitles.forEach(System.out::println);
        Assert.assertEquals(howWeWorkPage.getFooterLinkTitles(), Data.expectedFooterTitles);
    }
}
