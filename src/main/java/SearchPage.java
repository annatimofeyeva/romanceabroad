import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage extends BaseActions {
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String searchWomenByName() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.DROP_DOWN_LIST_SORT_BY));
        Select select = new Select(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY));
        select.selectByValue("name");
        /*Select select = new Select(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY)));
        select.selectByIndex(3);
        select.selectByValue("views_count"); //actual text = "Views"*/
        String selectedTextInDropDown = select.getFirstSelectedOption().getText().trim();
        System.out.println(selectedTextInDropDown);
        return selectedTextInDropDown;
    }

    public String searchWomenByAgesResult() {
        getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MAX, "40");
        getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MIN, "20");
        getNavigateToLinkPage(Locators.BUTTON_SEARCH);
        String resultSize = driver.findElement(Locators.SEARCH_RESULT).getText();
        System.out.println(resultSize);
        return resultSize;
    }
}
