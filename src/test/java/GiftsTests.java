import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GiftsTests extends BaseUI{
    private String currentUrlGifts;
    private String expectedUrlGifts = "https://romanceabroad.com/store/category-sweets";
    private By LINK_GIFTS = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");
    private By LIST_OF_BESTSELLERS = By.xpath("//div[@class='g-users-gallery__item col-xs-4 col-md-3 col-lg-2 bestseller']");
    private By TEXT_FIELD_GIFTS_SEARCH = By.cssSelector("#search_product");
    private By BUTTON_GIFTS_SEARCH = By.cssSelector("#search_friend");
    private By BUTTON_MAIN_NAV_BAR = By.cssSelector(".fa.fa-bars.fa-lg.item");

    @Test
    public void testGiftsTab() {
        driver.findElement(LINK_GIFTS).click();
        currentUrlGifts = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlGifts, expectedUrlGifts);
    }

    @Test
    public void testGiftsTabBestsellersSelected() {
        driver.findElement(LINK_GIFTS).click();
        currentUrlGifts = driver.getCurrentUrl();
        List bestsellers =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(LIST_OF_BESTSELLERS));
        //System.out.println(bestsellers.size());
        Assert.assertEquals(currentUrlGifts, expectedUrlGifts);
        Assert.assertTrue(bestsellers.size() > 0);
    }

    @Test
    public void testSearchForExactGift() {
        driver.findElement(LINK_GIFTS).click();
        WebElement giftSearchField =
                wait.until(ExpectedConditions.presenceOfElementLocated(TEXT_FIELD_GIFTS_SEARCH));
        giftSearchField.sendKeys("Flower busket");
        WebElement giftSearchButton = driver.findElement(BUTTON_GIFTS_SEARCH);
        giftSearchButton.click();
    }

    @Test
    public void testSearchForGiftsAndClickMainNavBar() {
        driver.findElement(LINK_GIFTS).click();
        WebElement mainNavBarButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_MAIN_NAV_BAR));
        mainNavBarButton.click();
    }
}
