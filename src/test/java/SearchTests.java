import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseUI {

    @Test
    public void testSearchWomenByName() {
        mainPage.clickSearchTab();
        String actualTextSelectedINDropDown = searchPage.searchWomenByName();
        Assert.assertEquals(Data.expectedTextSelectedInDropDown, actualTextSelectedINDropDown);
    }

    @Test
    public void testSearchWomenByAgesResult() {
        mainPage.clickSearchTab();
        String actualNumberOfSearchResults = searchPage.searchWomenByAgesResult();
        Assert.assertEquals(Data.expectedSearchResultSize, actualNumberOfSearchResults);
    }
}


