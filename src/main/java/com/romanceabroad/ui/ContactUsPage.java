package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactUsPage extends BaseActions{
    public ContactUsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void completeContactForm() {
        getNavigate(Locators.LINK_SEARCH);
        ajaxClick(Locators.LINKS_TITLES_FOOTER);
        clickSpecificListValue(Locators.LINKS_TITLES_FOOTER, Data.nameLinkContactUs);
        WebElement dropDownReasons = driver.findElement(Locators.DROP_DOWN_REASONS);
        getDropDownListByValue(dropDownReasons, Data.dropDownValueText);
        sendKeys(Locators.TEXT_FIELD_USER_NAME_CONTACT_US, Data.userNameContactUs);
        sendKeys(Locators.TEXT_FIELD_USER_EMAIL_CONTACT_US, Data.userEmailContactUs);
        sendKeys(Locators.TEXT_FIELD_SUBJECT, Data.subjectText);
        sendKeys(Locators.TEXT_AREA_MESSAGE, Data.messageText);
        clickElement(Locators.BUTTON_SUBMIT);
    }

    public void completeContactForm1(String username, String useremail, String subject, String message) {
        getNavigate(Locators.LINK_SEARCH);
        ajaxClick(Locators.LINKS_TITLES_FOOTER);
        clickSpecificListValue(Locators.LINKS_TITLES_FOOTER, Data.nameLinkContactUs);
        WebElement dropDownReasons = driver.findElement(Locators.DROP_DOWN_REASONS);
        getDropDownListByValue(dropDownReasons, Data.dropDownValueText);
        WebElement userName = driver.findElement(Locators.TEXT_FIELD_USER_NAME_CONTACT_US);
        userName.sendKeys(username);
        WebElement userEmail = driver.findElement(Locators.TEXT_FIELD_USER_EMAIL_CONTACT_US);
        userEmail.sendKeys(useremail);
        WebElement userSubject = driver.findElement(Locators.TEXT_FIELD_SUBJECT);
        userSubject.sendKeys(subject);
        WebElement userMessage = driver.findElement(Locators.TEXT_AREA_MESSAGE);
        userMessage.sendKeys(message);
        clickElement(Locators.BUTTON_SUBMIT);
    }
}
