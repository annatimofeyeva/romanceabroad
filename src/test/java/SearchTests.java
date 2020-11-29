import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseUI {

    @Test
    public void testSearchWomenByName() {
        mainPage.clickSearchTab();
        Assert.assertEquals(Data.expectedTextSelectedInDropDown, searchPage.searchWomenByName());
    }

    @Test
    public void testSearchWomenByAgesResult() {
        mainPage.clickSearchTab();
        Assert.assertEquals(Data.expectedSearchResultSize, searchPage.searchWomenByAgesResult());
    }
}


