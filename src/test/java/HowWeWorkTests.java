import org.testng.Assert;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseUI {

    @Test
    public void testGetContentPagesTitles() {
        mainPage.clickHowWeWorkTab();
        howWeWorkPage.getContentPagesTitles();
        Data.expectedContentPageTitles.forEach(System.out::println);
        //Assert.assertEquals(howWeWorkPage.getContentPagesTitles(), Data.expectedContentPageTitles);
    }

    @Test
    public void testGetContentPagesNumber() {
        mainPage.clickHowWeWorkTab();
        Assert.assertEquals(howWeWorkPage.getContentPagesNumber(), Data.expectedNumberOfContentPages);
    }

    @Test
    public void testCheckFooterLinkTitles() {
        mainPage.clickHowWeWorkTab();
        Assert.assertEquals(howWeWorkPage.getFooterLinkTitles(), Data.expectedFooterTitles);
    }

    @Test
    public void testClickContentPageLink() {
        mainPage.clickHowWeWorkTab();
        howWeWorkPage.clickValueOfList(Locators.LINK_CONTENT_PAGE_TITLES, "Terms of use");
    }

}
