import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseUI {

    @Test
    public void testSearchWomenByName() {
        String actualTextSelectedINDropDown = searchPage.searchWomenByName();
        Assert.assertEquals(Data.expectedTextSelectedInDropDown, actualTextSelectedINDropDown);
    }

    @Test
    public void testSearchWomenByAges() {
        String actualNumberOfWomen = searchPage.searchWomenByAges();
        Assert.assertEquals(Data.expectedSearchResultSize, actualNumberOfWomen);
    }
}


