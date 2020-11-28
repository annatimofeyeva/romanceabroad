import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        Select select = new Select (wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByIndex(index);
    }

    public void getDropDownListByText(By locator, String text) {
        Select select = new Select (wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByVisibleText(text);
    }
    // for Angular apps - advanced level of clicks
    public void ajaxClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    // for Angular apps - advanced level of clicks
    public void ajaxClick(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElement(by));
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
