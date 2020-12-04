import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseUI {

    @Test(priority = 5)
    public void testSearchWomenByName() {
        String actualTextSelectedINDropDown = searchPage.searchWomenByName();
        Assert.assertEquals(Data.expectedTextSelectedInDropDown, actualTextSelectedINDropDown);
    }

    @Test(priority = 4)
    public void testSearchWomenByAges() {
        String actualNumberOfWomen = searchPage.searchWomenByAges();
        Assert.assertEquals(Data.expectedSearchResultSize, actualNumberOfWomen);
    }

    @Test(priority = 3)
    public void testRandomSearchFromDropDown() {
        searchPage.randomSearchFromDropDown();
    }

    @Test(priority = 2)
    public void testRandomSearchFromDropDownSecond() {
        searchPage.randomSearchFromDropDownSecond();
    }

    @Test(priority = 1)
    public void testGetSizeDropDownList() {
        int actualSize = searchPage.getSizeDropDownList();
        System.out.println("Size of DropDown list: " + actualSize);
        Assert.assertEquals(actualSize, Data.expectedSizeOfDropDownList);
    }
}


