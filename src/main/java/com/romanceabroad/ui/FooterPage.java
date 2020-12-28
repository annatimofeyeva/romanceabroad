package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FooterPage extends BaseActions{
    public FooterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getSelectedFooterLink() {
        String urlSelectedFooterLink = "";
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINKS_TITLES_FOOTER));
        WebElement link = list.get(Data.FOOTER_LINKS_INDEX);
        ajaxClick(link);
        urlSelectedFooterLink = driver.getCurrentUrl();
        //System.out.println(urlSelectedFooterLink);
        return urlSelectedFooterLink;
    }
}
