package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GiftsPage extends BaseActions {
    public GiftsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void giftSearch(String gift) {
        Reports.log("Redirection to Gifts page");
        getNavigate(Locators.LINK_GIFTS);

        Reports.log("Wait until Search field is clickable");
        WebElement searchFiled =  wait.until(ExpectedConditions.elementToBeClickable(Locators.TEXT_FIELD_GIFTS_SEARCH));

        Reports.log("Type gift name: " + gift + " in Search filed");
        searchFiled.sendKeys(gift);

        Reports.log("Click Search Button");
        WebElement element = driver.findElement(By.xpath("//button[@id='search_friend']"));
        element.click();
    }

    public String bestsellerSelection() {
        Reports.log("Redirection to Gifts page");
        getNavigate(Locators.LINK_GIFTS);

        Reports.log("Redirection to Bestseller Purchase");
        ajaxClick(Locators.LINK_TO_BESTSELLER_PURCHASE);
        String bestSellerTitle =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.BESTSELLER_TITLE)).getText();
        Reports.log("Bestseller title text: " + bestSellerTitle);
        System.out.println(bestSellerTitle);
        return bestSellerTitle;
    }

    public String bestsellerPurchase() {
        Reports.log("Redirection to Gifts page");
        getNavigate(Locators.LINK_GIFTS);

        Reports.log("Redirection to Bestseller Purchase");
        ajaxClick(Locators.LINK_TO_BESTSELLER_PURCHASE);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_PAY_PAL));
        WebElement payPalButton = driver.findElement(Locators.BUTTON_PAY_PAL);
        if (payPalButton.isEnabled()) {
            System.out.println("It's possible to make payment with PayPal");
        } else {
            System.out.println("Some issues with PauPal payment");
        }
        String payPalButtonText = payPalButton.getText().trim();
        Reports.log("PayPal Button text: " + payPalButtonText);
        return payPalButtonText;
    }
}
