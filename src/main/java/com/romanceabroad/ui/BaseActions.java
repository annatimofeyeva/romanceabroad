package com.romanceabroad.ui;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BaseActions {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void javaImplicitWait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void javaImplicitWaitSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String generateUniqueUserName(String name, int length) {
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
    // method signature - method name plus parameters list
    // for Angular apps - advanced level of clicks (for Chrome)
    public void ajaxClick(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

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

    public void performedClick(By locator, int index) {
        WebElement element = driver.findElements(locator).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    public void performedClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    public void ajaxSendKeys(WebElement element, String text) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute( 'value', ' " + text + " ')", element);
    }


    public void clickUnselectedCheckbox(WebElement currentCheckbox) {
        if (!currentCheckbox.isSelected()) {
            ajaxClick(currentCheckbox);
        }
    }

    public void ajaxScroll(WebElement element) {
        ((JavascriptExecutor)
                driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void ajaxScroll(By by) {
        ajaxScroll(driver.findElement(by));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void ajaxScroll(By by, int index) {
        ajaxScroll(driver.findElements(by).get(index));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    // doesn't work
    public void scrollToBottomOfPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void ajaxScrollUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250)", " ");
    }

    public void getNavigate(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void getNavigate(String url) {
        driver.get(url);
    }

    public void typeValueInTextFiled(By locator, String text) {
      WebElement element = driver.findElement(locator);
      element.sendKeys(text);
    }

    //Method for random choice from DropDown list
    public void selectItemDropDownRandomOption(By locator, String dropDownName) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select select = new Select(driver.findElement(locator));
            select.selectByIndex((int) (Math.random() * (select.getOptions().size() - 1)) + 1);
            System.out.println(dropDownName + " : " + select.getFirstSelectedOption().getText());
        } catch (NoSuchElementException e) {
        }
    }

    public String getTextFromDropDownSelectedValue(By locator, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByValue(value);
        String selectedTextInDropDown = select.getFirstSelectedOption().getText().trim();
        return selectedTextInDropDown;
    }

    public String clickValueOfList(By locator, String text) {
        String info = "";
        String actualUrl = "";
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        for (int i = 0; i < list.size(); i++) {
            list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            info = list.get(i).getText();
            if (info.equals(text)) {
                ajaxClick(list.get(i));
                actualUrl = driver.getCurrentUrl();
                System.out.println(actualUrl);
                driver.navigate().back();
            }
        }
        return actualUrl;
    }

    public void clickSpecificListValue(By locator, String text) {
        String info = "";
        String actualUrl = "";
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        for (int i = 0; i < list.size(); i++) {
            list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            info = list.get(i).getText();
            if (info.equals(text)) {
                ajaxClick(list.get(i));
                actualUrl = driver.getCurrentUrl();
                System.out.println(actualUrl);

            }
        }
    }

    public void checkLinksOnWebPage(String xpathValue, String attribute) {
        List<WebElement> links = driver.findElements(By.xpath(xpathValue));
        System.out.println("I start taking attribute values:");
        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getAttribute(attribute);
            verifyLinkActive(url);
        }
        System.out.println("Total size: " + links.size());
    }

    //Method for link verification
    public void verifyLinkActive(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkUrl + "-" + httpURLConnect.getResponseMessage());
            } else if (httpURLConnect.getResponseCode() >= 400 && httpURLConnect.getResponseCode() <= 504) {
                System.out.println(linkUrl + "-" + httpURLConnect.getResponseMessage() + "-" + httpURLConnect.getResponseMessage());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSizeDropDownList(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select select = new Select(driver.findElement(locator));
            return select.getOptions().size();

        } catch (NoSuchElementException e) {
            System.out.println("getSizeDropDownList error");
        }
        return 0;
    }

    public void scrollSmoothToBottom() {
        for (int i = 0; i < 6000; i++) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1)", "");
        }
    }

    public void clickListValue(By locator, String text) {
        List<WebElement> elements = driver.findElements(locator);
        for (int i = 0; i < elements.size(); i++) {
            elements = driver.findElements(locator);
            WebElement elementOfList = elements.get(i);
            String elementOfListText = elements.get(i).getText();
            if (elementOfListText.contains(text)) {
                System.out.println(elements.get(i).getText());
                elementOfList.click();
            }
        }
    }

    public void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public String getAnyTitle(By locator) {
        String title = driver.findElement(locator).getText();
        return title;
    }

    public List<String> getTextOfEachListElement(By locator) {
        List<String> elementsText = new ArrayList<>();
        List<WebElement> elements =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        for (WebElement element : elements) {
            elementsText.add(element.getText());
        }
        System.out.println(elementsText);
        for (int i = 0; i < elementsText.size(); i++) {
            System.out.println("Title of elements: " + elementsText.get(i));
        }
        return elementsText;
    }

    public void clickUnselectedCheckbox(By locator) {
        Reports.log("Create webelement for checkbox");
        WebElement currentCheckbox = driver.findElement(locator);
        Reports.log("Click checkbox confirmation");
        if (!currentCheckbox.isSelected()) {
            ajaxClick(currentCheckbox);
        }
    }
}



