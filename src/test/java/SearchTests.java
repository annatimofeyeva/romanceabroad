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

    @Test
    public void testRandomSearchFromDropDown() {
        searchPage.randomSearchFromDropDown();
    }

    @Test
    public void testRandomSearchFromDropDownSecond() {
        searchPage.randomSearchFromDropDownSecond();
    }

    @Test
    public void testGetSizeDropDownList() {
        int actualSize = searchPage.getSizeDropDownList();
        System.out.println("Size of DropDown list: " + actualSize);
        Assert.assertEquals(actualSize, Data.expectedSizeOfDropDown);
    }
}


