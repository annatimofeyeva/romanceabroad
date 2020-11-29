import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BaseActions {
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void dropDownListSortByUserData() {
        driver.findElement(Locators.LINK_SEARCH).click();
        /*Select select = new Select(driver.findElement(By.xpath("//div[@class='form-inline']//select")));
        select.selectByVisibleText("Name");
        select.selectByIndex(3);
        select.selectByValue("views_count"); //actual text = "Views"*/
        //getDropDownListByIndex(Locators.DROP_DOWN_LIST_SORT_BY, 3);
        //getDropDownListByText(Locators.DROP_DOWN_LIST_SORT_BY, "Name");
        WebElement dropDownListSortByUserData =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.DROP_DOWN_LIST_SORT_BY));
        getDropDownListByValue(dropDownListSortByUserData, "views_count");
    }

    public String searchWomenResults() {
        getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MAX, "40");
        getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY_AGE_MIN, "20");
        getNavigateToLinkPage(Locators.BUTTON_SEARCH);
        String resultSize = driver.findElement(Locators.SEARCH_RESULT).getText();
        System.out.println(resultSize);
        return resultSize;
    }
}
