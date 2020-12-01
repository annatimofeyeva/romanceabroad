import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage extends BaseActions {
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String searchWomenByName() {
        getNavigate(Locators.LINK_SEARCH);
        String selectedTextInDropDown = getTextFromDropDownSelectedValue(Locators.DROP_DOWN_LIST_SORT_BY, "name");
        return selectedTextInDropDown;
    }

    public String searchWomenByAges() {
        getNavigate(Locators.LINK_SEARCH);
        getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MAX, "40");
        getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MIN, "20");
        driver.findElement(Locators.BUTTON_SEARCH).click();
        String numberOfWomens = driver.findElement(Locators.SEARCH_RESULT).getText();
        System.out.println(numberOfWomens);
        return numberOfWomens;
    }
}
