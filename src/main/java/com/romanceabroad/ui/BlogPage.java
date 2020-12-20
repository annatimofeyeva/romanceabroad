package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class BlogPage extends BaseActions {
    String currentUrlBlog;

    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String verifyBlogLinkUrl() {
        getNavigate(Locators.LINK_BLOG);
        currentUrlBlog = driver.getCurrentUrl();
        return currentUrlBlog;
    }

    public List<String> checkAllContentPagesLinks() {
        getNavigate(Locators.LINK_BLOG);
        List<String> titles = new ArrayList<>();
        List<WebElement> list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
        for (int i = 0; i < list.size(); i++) {
            String nameOfArticle = list.get(i).getText();
            titles.add(nameOfArticle);
            System.out.println(titles);
            System.out.println(titles.size());
            if(nameOfArticle.contains("Travel to Ukraine")) {
                System.out.println("Name of article - Travel to Ukraine");
            }else if(nameOfArticle.contains("How it works")) {
                System.out.println("Name of article - How it works");
            }
            else{
                continue;
            }
            ajaxClick(list.get(i));
            list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LINK_CONTENT_PAGE_TITLES));
        }
        return titles;
    }
}






