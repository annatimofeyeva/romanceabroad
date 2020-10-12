import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GiftsTests extends BaseUI {
    private String currentUrlGifts;
    private String expectedUrlGifts = "https://romanceabroad.com/store/category-sweets";

    @Test
    public void testGiftsTab() {
        driver.findElement(Locators.LINK_GIFTS).click();
        currentUrlGifts = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlGifts, expectedUrlGifts);
    }

    @Test
    public void testGiftsTabBestsellersSelected() {
        driver.findElement(Locators.LINK_GIFTS).click();
        currentUrlGifts = driver.getCurrentUrl();
        List bestsellers =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.LIST_OF_BESTSELLERS));
        //System.out.println(bestsellers.size());
        Assert.assertEquals(currentUrlGifts, expectedUrlGifts);
        Assert.assertTrue(bestsellers.size() > 0);
    }

    @Test
    public void testSearchForExactGift() {
        driver.findElement(Locators.LINK_GIFTS).click();
        WebElement giftSearchField =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TEXT_FIELD_GIFTS_SEARCH));
        giftSearchField.sendKeys(Data.GiftName);
        WebElement giftSearchButton = driver.findElement(Locators.BUTTON_GIFTS_SEARCH);
        giftSearchButton.click();
    }

    @Test
    public void testSearchForGiftsAndClickMainNavBar() {
        driver.findElement(Locators.LINK_GIFTS).click();
        WebElement mainNavBarButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BUTTON_MAIN_NAV_BAR));
        mainNavBarButton.click();
    }
}
