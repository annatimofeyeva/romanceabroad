import org.testng.annotations.Test;

public class SearchTests extends BaseUI {
    @Test
    public void testDropDownListSortByUserData() {
        searchPage.dropDownListSortByUserData();
    }

    @Test
    public void testDropDownListSortByAgesMin() {
        searchPage.dropDownListSortByAgesMin();
    }

    @Test
    public void testDropDownListSortByAgesMax() {
        searchPage.dropDownListSortByAgesMax();
    }
}
