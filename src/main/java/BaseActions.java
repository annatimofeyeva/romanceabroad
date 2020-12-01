import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseActions {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String generateUniqueUserName(String name, int length) {
        return name + RandomStringUtils.random(length, "172984757");
    }

    public void getDropDownListByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void getDropDownListByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void getDropDownListByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void getDropDownListByValue(By locator, String value) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByValue(value);
    }

    public void getDropDownListByIndex(By locator, int index) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByIndex(index);
    }

    public void getDropDownListByText(By locator, String text) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByVisibleText(text);
    }

    // for Angular apps - advanced level of clicks (for Chrome)
    public void ajaxClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void ajaxClick(By by) {
        //wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElement(by));
    }

    public void ajaxClick(By by, int index) {
        //wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElements(by).get(index));
    }

    // Click by mouse using Locator - advanced level of clicks (mostly works for IE)
    public void performedClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    // Click by mouse using index - advanced level of clicks (mostly works for IE)
    public void performedClick(By locator, int index) {
        WebElement element = driver.findElements(locator).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    // Click by mouse using WebElement - advanced level of clicks (mostly works for IE)
    public void performedClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    public void clickUnselectedCheckbox(By checkbox) {
        WebElement currentCheckbox = driver.findElement(checkbox);
        if (!currentCheckbox.isSelected()) {
            ajaxClick(currentCheckbox);
        }
    }

    public void clickUnselectedCheckbox(WebElement currentCheckbox) {
        if (!currentCheckbox.isSelected()) {
            ajaxClick(currentCheckbox);
        }
    }

    public void ajaxScroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void ajaxScroll(By by) {
        ajaxScroll(driver.findElement(by));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void ajaxScroll(By by, int index) {
        ajaxScroll(driver.findElements(by).get(index));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public void scrollToBottomOfPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }


    public void ajaxScrollUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250)", " ");
    }

    public void getNavigateToLinkPage(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public String getTextFromDropDownSelectedValue(By locator, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select( wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByValue(value);
        /*Select select = new Select(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY)));
        select.selectByIndex(3);
        select.selectByValue("views_count"); //actual text = "Views"*/
        String selectedTextInDropDown = select.getFirstSelectedOption().getText().trim();
        return selectedTextInDropDown;
    }





    public void clickValueOfList(By locator, String text) {
        List<WebElement> elements = driver.findElements(locator);
        for (int i = 0; i < elements.size(); i++) {
            WebElement elementOfList = elements.get(i);
            String value = elementOfList.getText();
            if (value.contains(text)) {
                wait.until(ExpectedConditions.elementToBeClickable(elementOfList));
                elementOfList.click();
            }
        }
    }
}
