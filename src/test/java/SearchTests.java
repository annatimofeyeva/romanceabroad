import org.testng.annotations.Test;

public class SearchTests extends BaseUI {
    @Test
    public void testDropDownListSortByUserData() {
        searchPage.DropDownListSortByUserData();
    }

    @Test
    public void testDropDownListSortByAgesMin() {
        searchPage.DropDownListSortByAgesMin();
    }

    @Test
    public void testDropDownListSortByAgesMax() {
        searchPage.DropDownListSortByAgesMax();
    }
}
